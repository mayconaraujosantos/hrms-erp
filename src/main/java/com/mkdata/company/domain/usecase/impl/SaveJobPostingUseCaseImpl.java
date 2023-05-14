package com.mkdata.company.domain.usecase.impl;

import com.mkdata.company.app.dto.JobPostingDTORequest;
import com.mkdata.company.app.dto.JobPostingDTOResponse;
import com.mkdata.company.app.mapper.JobPostingMapper;
import com.mkdata.company.domain.entity.JobPosting;
import com.mkdata.company.domain.exception.JobPostingException;
import com.mkdata.company.domain.usecase.SaveJobPostingUseCase;
import com.mkdata.company.infrastructure.persistence.JobPostingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service
public class SaveJobPostingUseCaseImpl implements SaveJobPostingUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaveJobPostingUseCaseImpl.class);

    private final JobPostingRepository jobPostingRepository;
    private final JobPostingMapper jobPostingMapper;

    public SaveJobPostingUseCaseImpl(JobPostingRepository jobPostingRepository, JobPostingMapper jobPostingMapper) {
        this.jobPostingRepository = jobPostingRepository;
        this.jobPostingMapper = jobPostingMapper;
    }

    @Override
    @Transactional
    public JobPostingDTOResponse saveJobPosting(JobPostingDTORequest jobPostingDTORequest) {
        try {
            JobPosting jobPosting = jobPostingMapper.toEntity(jobPostingDTORequest);
            JobPosting savedJobPosting = jobPostingRepository.save(jobPosting);
            return jobPostingMapper.toDto(savedJobPosting);
        } catch (JobPostingException e) {
            String errorMessage = "Failed to save Job Posting due to constraint violation: " + e.getMessage();
            LOGGER.error(errorMessage, e);
            throw new JobPostingException(errorMessage, e);
        } catch (Exception ex) {
            String errorMessage = "Failed to save Job Posting: " + ex.getMessage();
            LOGGER.error(errorMessage, ex);
            throw new JobPostingException(errorMessage, ex);
        }
    }
}
