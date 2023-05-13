package com.mkdata.company.app.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mkdata.company.app.dto.JobPostingDTORequest;
import com.mkdata.company.app.dto.JobPostingDTOResponse;
import com.mkdata.company.domain.entity.JobPosting;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class JobPostingMapperTest {

    private final JobPostingMapper mapper = Mappers.getMapper(JobPostingMapper.class);

    @Test
    void shouldMapDtoToEntity() {
        // arrange
        JobPostingDTORequest dto = new JobPostingDTORequest();
        dto.setTitle("test title");
        dto.setDescription("test description");

        // act
        JobPosting entity = mapper.toEntity(dto);

        // assert
        assertEquals(dto.getTitle(), entity.getTitle());
        assertEquals(dto.getDescription(), entity.getDescription());
    }

    @Test
    void shouldMapEntityToDto() {
        // arrange
        JobPosting entity = new JobPosting();
        entity.setTitle("test title");
        entity.setDescription("test description");

        // act
        JobPostingDTOResponse dto = mapper.toDto(entity);

        // assert
        assertEquals(entity.getTitle(), dto.getTitle());
        assertEquals(entity.getDescription(), dto.getDescription());
    }
}
