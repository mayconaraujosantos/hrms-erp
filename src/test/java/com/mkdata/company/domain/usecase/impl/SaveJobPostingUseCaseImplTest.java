package com.mkdata.company.domain.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.mkdata.company.app.dto.JobPostingDTORequest;
import com.mkdata.company.app.dto.JobPostingDTOResponse;
import com.mkdata.company.app.mapper.JobPostingMapper;
import com.mkdata.company.domain.entity.JobPosting;
import com.mkdata.company.domain.exception.JobPostingException;
import com.mkdata.company.infrastructure.persistence.JobPostingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;

@DisplayName("SaveJobPostingUseCaseImpl")
public class SaveJobPostingUseCaseImplTest {

    private SaveJobPostingUseCaseImpl saveJobPostingUseCase;

    @Mock
    private JobPostingRepository jobPostingRepository;

    @Mock
    private JobPostingMapper jobPostingMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        saveJobPostingUseCase = new SaveJobPostingUseCaseImpl(jobPostingRepository, jobPostingMapper);
    }

    @DisplayName("should save job posting and return DTO response")
    @ParameterizedTest(name = "for request \"{0}\" should return DTO response")
    @CsvSource({"Title 1, Description 1", "Title 2, Description 2"})
    void shouldSaveJobPosting(String title, String description) {
        // arrange
        JobPostingDTORequest request = new JobPostingDTORequest();
        request.setTitle(title);
        request.setDescription(description);
        JobPosting jobPosting = new JobPosting();
        when(jobPostingMapper.toEntity(request)).thenReturn(jobPosting);

        JobPosting savedJobPosting = new JobPosting();
        when(jobPostingRepository.save(jobPosting)).thenReturn(savedJobPosting);

        JobPostingDTOResponse expectedResponse = new JobPostingDTOResponse();
        when(jobPostingMapper.toDto(any(JobPosting.class))).thenReturn(expectedResponse);

        // act
        JobPostingDTOResponse response = saveJobPostingUseCase.saveJobPosting(request);

        // assert
        assertEquals(expectedResponse, response);
    }

    @DisplayName("should throw exception when constraint violation occurs")
    @ParameterizedTest(name = "for request \"{0}\" should throw exception")
    @CsvSource({
        "Title, ''", // empty description
        "Title, '123456789012345678901234567890123456789012345678901234567890'" // too long description
    })
    void shouldThrowExceptionWhenConstraintViolationOccurs(String title, String description) {
        // arrange
        JobPostingDTORequest request = new JobPostingDTORequest();
        request.setTitle(title);
        request.setDescription(description);
        when(jobPostingMapper.toEntity(request)).thenThrow(DataIntegrityViolationException.class);

        // assert
        assertThrows(JobPostingException.class, () -> saveJobPostingUseCase.saveJobPosting(request));
    }

    @DisplayName("should throw exception when unexpected error occurs")
    @ParameterizedTest(name = "for request \"{0}\" should throw exception")
    @CsvSource({"Title, Description", "Title 2, Description 2"})
    void shouldThrowExceptionWhenUnexpectedErrorOccurs(String title, String description) {
        // arrange
        JobPostingDTORequest request = new JobPostingDTORequest();
        request.setTitle(title);
        request.setDescription(description);
        when(jobPostingMapper.toEntity(request)).thenThrow(new RuntimeException());

        // assert
        assertThrows(JobPostingException.class, () -> saveJobPostingUseCase.saveJobPosting(request));
    }

    @DisplayName("should log error on constraint violation")
    @ParameterizedTest(name = "for request \"{0}\" should log error")
    @CsvSource({
        "Title, ''", // empty description
        "Title, '123456789012345678901234567890123456789012345678901234567890'" // too long description
    })
    void shouldLogErrorOnConstraintViolation(String title, String description) {
        // arrange
        JobPostingDTORequest request = new JobPostingDTORequest();
        request.setTitle(title);
        request.setDescription(description);
        when(jobPostingMapper.toEntity(request)).thenThrow(DataIntegrityViolationException.class);

        // act
        assertThrows(JobPostingException.class, () -> saveJobPostingUseCase.saveJobPosting(request));

        // assert
        verifyNoInteractions(jobPostingRepository);
    }
}
