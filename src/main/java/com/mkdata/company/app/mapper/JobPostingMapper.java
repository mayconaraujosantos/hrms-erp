package com.mkdata.company.app.mapper;

import com.mkdata.company.app.dto.JobPostingDTORequest;
import com.mkdata.company.app.dto.JobPostingDTOResponse;
import com.mkdata.company.domain.entity.JobPosting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobPostingMapper {

    JobPosting toEntity(JobPostingDTORequest jobPostingDTO);

    JobPostingDTOResponse toDto(JobPosting entity);
}
