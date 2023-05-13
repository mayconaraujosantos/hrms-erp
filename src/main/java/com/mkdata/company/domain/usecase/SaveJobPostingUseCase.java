package com.mkdata.company.domain.usecase;

import com.mkdata.company.app.dto.JobPostingDTORequest;
import com.mkdata.company.app.dto.JobPostingDTOResponse;

public interface SaveJobPostingUseCase {
    JobPostingDTOResponse saveJobPosting(JobPostingDTORequest jobPostingDTORequest);
}
