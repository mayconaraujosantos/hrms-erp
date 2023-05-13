package com.mkdata.company.presentation.controller;

import com.mkdata.company.app.dto.JobPostingDTORequest;
import com.mkdata.company.app.dto.JobPostingDTOResponse;
import com.mkdata.company.domain.usecase.SaveJobPostingUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/job-postings")
public class JobPostingController {

    private final SaveJobPostingUseCase saveJobPostingUseCase;
    private static final Logger log = LoggerFactory.getLogger(JobPostingController.class);

    public JobPostingController(SaveJobPostingUseCase saveJobPostingUseCase) {
        this.saveJobPostingUseCase = saveJobPostingUseCase;
    }

    @PostMapping
    public ResponseEntity<JobPostingDTOResponse> saveJobPosting(
            @RequestBody JobPostingDTORequest jobPostingDTORequest) {
        log.info("Received request to save job posting: {}", jobPostingDTORequest);
        JobPostingDTOResponse savedJobPosting = saveJobPostingUseCase.saveJobPosting(jobPostingDTORequest);
        log.info("Successfully saved job posting: {}", savedJobPosting);
        return new ResponseEntity<>(savedJobPosting, HttpStatus.CREATED);
    }
}
