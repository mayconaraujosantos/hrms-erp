package com.mkdata.company.presentation.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mkdata.company.app.dto.JobPostingDTORequest;
import com.mkdata.company.app.dto.JobPostingDTOResponse;
import com.mkdata.company.domain.usecase.SaveJobPostingUseCase;
import com.mkdata.company.utils.JobPostingUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class JobPostingControllerTest {
    private SaveJobPostingUseCase saveJobPostingUseCase = mock(SaveJobPostingUseCase.class);
    private JobPostingController jobPostingController = new JobPostingController(saveJobPostingUseCase);

    @Test
    void shouldSaveJobPosting() {
        JobPostingDTORequest jobPostingDTORequest = JobPostingUtils.createJobPostingDTORequest();
        JobPostingDTOResponse jobPostingDTOResponse = JobPostingUtils.createJobPostingDTOResponse();

        when(saveJobPostingUseCase.saveJobPosting(jobPostingDTORequest)).thenReturn(jobPostingDTOResponse);

        ResponseEntity<JobPostingDTOResponse> responseEntity =
                jobPostingController.saveJobPosting(jobPostingDTORequest);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody()).isEqualTo(jobPostingDTOResponse);
    }
}
