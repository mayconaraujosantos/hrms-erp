package com.mkdata.company.utils;

import com.mkdata.company.app.dto.JobPostingDTORequest;
import com.mkdata.company.app.dto.JobPostingDTOResponse;
import com.mkdata.company.domain.entity.JobPosting;
import java.util.List;

public class JobPostingUtils {

    public static JobPosting buildJobPostingContainingIgnoreCase() {
        return JobPosting.builder()
                .title(JobPostingConstants.TEST_TITLE_1)
                .description(JobPostingConstants.TEST_DESCRIPTION_1)
                .companyName(JobPostingConstants.TEST_COMPANY_NAME_1)
                .location(JobPostingConstants.TEST_LOCATION_1)
                .jobDescription("Java Developer required for a software company.")
                .salary(JobPostingConstants.TEST_SALARY_1)
                .jobType(JobPostingConstants.TEST_JOB_TYPE_1)
                .salaryType(JobPostingConstants.TEST_SALARY_TYPE_1)
                .experienceLevel(JobPostingConstants.TEST_EXPERIENCE_LEVEL_1)
                .educationLevel(JobPostingConstants.TEST_EDUCATION_LEVEL_1)
                .jobStatus(JobPostingConstants.TEST_JOB_STATUS_1)
                .requirements(JobPostingConstants.TEST_REQUIREMENTS_1)
                .responsibilities(JobPostingConstants.TEST_RESPONSIBILITIES_1)
                .benefits(JobPostingConstants.TEST_BENEFITS_1)
                .jobPostedDate(JobPostingConstants.TEST_JOB_POSTED_DATE_1)
                .build();
    }

    public static List<JobPosting> createSoftwareEngineerAndDataScientistJobPostings() {
        return List.of(createSoftwareEngineerJobPosting(), createDataScientistJobPosting());
    }

    public static JobPosting createSoftwareEngineerJobPosting() {
        return JobPosting.builder()
                .title(JobPostingConstants.TEST_TITLE_1)
                .description(JobPostingConstants.TEST_DESCRIPTION_1)
                .companyName(JobPostingConstants.TEST_COMPANY_NAME_1)
                .location(JobPostingConstants.TEST_LOCATION_1)
                .jobDescription(JobPostingConstants.TEST_JOB_DESCRIPTION_1)
                .salary(JobPostingConstants.TEST_SALARY_1)
                .jobType(JobPostingConstants.TEST_JOB_TYPE_1)
                .salaryType(JobPostingConstants.TEST_SALARY_TYPE_1)
                .experienceLevel(JobPostingConstants.TEST_EXPERIENCE_LEVEL_1)
                .educationLevel(JobPostingConstants.TEST_EDUCATION_LEVEL_1)
                .jobStatus(JobPostingConstants.TEST_JOB_STATUS_1)
                .requirements(JobPostingConstants.TEST_REQUIREMENTS_1)
                .responsibilities(JobPostingConstants.TEST_RESPONSIBILITIES_1)
                .benefits(JobPostingConstants.TEST_BENEFITS_1)
                .jobPostedDate(JobPostingConstants.TEST_JOB_POSTED_DATE_1)
                .build();
    }

    public static JobPosting createDataScientistJobPosting() {
        return JobPosting.builder()
                .title(JobPostingConstants.TEST_TITLE_2)
                .description(JobPostingConstants.TEST_DESCRIPTION_2)
                .companyName(JobPostingConstants.TEST_COMPANY_NAME_2)
                .location(JobPostingConstants.TEST_LOCATION_2)
                .jobDescription(JobPostingConstants.TEST_JOB_DESCRIPTION_2)
                .salary(JobPostingConstants.TEST_SALARY_2)
                .jobType(JobPostingConstants.TEST_JOB_TYPE_2)
                .salaryType(JobPostingConstants.TEST_SALARY_TYPE_2)
                .experienceLevel(JobPostingConstants.TEST_EXPERIENCE_LEVEL_2)
                .educationLevel(JobPostingConstants.TEST_EDUCATION_LEVEL_2)
                .jobStatus(JobPostingConstants.TEST_JOB_STATUS_2)
                .requirements(JobPostingConstants.TEST_REQUIREMENTS_2)
                .responsibilities(JobPostingConstants.TEST_RESPONSIBILITIES_2)
                .benefits(JobPostingConstants.TEST_BENEFITS_2)
                .jobPostedDate(JobPostingConstants.TEST_JOB_POSTED_DATE_2)
                .build();
    }

    public static JobPostingDTOResponse createJobPostingDTOResponse() {
        return JobPostingDTOResponse.builder()
                .id(1L)
                .title(JobPostingConstants.TEST_TITLE_2)
                .description(JobPostingConstants.TEST_DESCRIPTION_2)
                .companyName(JobPostingConstants.TEST_COMPANY_NAME_2)
                .location(JobPostingConstants.TEST_LOCATION_2)
                .jobDescription(JobPostingConstants.TEST_JOB_DESCRIPTION_2)
                .salary(JobPostingConstants.TEST_SALARY_2)
                .jobType(JobPostingConstants.TEST_JOB_TYPE_2)
                .salaryType(JobPostingConstants.TEST_SALARY_TYPE_2)
                .experienceLevel(JobPostingConstants.TEST_EXPERIENCE_LEVEL_2)
                .educationLevel(JobPostingConstants.TEST_EDUCATION_LEVEL_2)
                .jobStatus(JobPostingConstants.TEST_JOB_STATUS_2)
                .requirements(JobPostingConstants.TEST_REQUIREMENTS_2)
                .responsibilities(JobPostingConstants.TEST_RESPONSIBILITIES_2)
                .benefits(JobPostingConstants.TEST_BENEFITS_2)
                .jobPostedDate(JobPostingConstants.TEST_JOB_POSTED_DATE_2)
                .build();
    }

    public static JobPostingDTORequest createJobPostingDTORequest() {
        return JobPostingDTORequest.builder()
                .title(JobPostingConstants.TEST_TITLE_2)
                .description(JobPostingConstants.TEST_DESCRIPTION_2)
                .companyName(JobPostingConstants.TEST_COMPANY_NAME_2)
                .location(JobPostingConstants.TEST_LOCATION_2)
                .jobDescription(JobPostingConstants.TEST_JOB_DESCRIPTION_2)
                .salary(JobPostingConstants.TEST_SALARY_2)
                .jobType(JobPostingConstants.TEST_JOB_TYPE_2)
                .salaryType(JobPostingConstants.TEST_SALARY_TYPE_2)
                .experienceLevel(JobPostingConstants.TEST_EXPERIENCE_LEVEL_2)
                .educationLevel(JobPostingConstants.TEST_EDUCATION_LEVEL_2)
                .jobStatus(JobPostingConstants.TEST_JOB_STATUS_2)
                .requirements(JobPostingConstants.TEST_REQUIREMENTS_2)
                .responsibilities(JobPostingConstants.TEST_RESPONSIBILITIES_2)
                .benefits(JobPostingConstants.TEST_BENEFITS_2)
                .jobPostedDate(JobPostingConstants.TEST_JOB_POSTED_DATE_2)
                .build();
    }

    public static JobPosting makeJobPostingWithEnums() {
        return JobPosting.builder()
                .title(JobPostingConstants.TEST_TITLE_2)
                .description(JobPostingConstants.TEST_DESCRIPTION_2)
                .companyName(JobPostingConstants.TEST_COMPANY_NAME_2)
                .location(JobPostingConstants.TEST_LOCATION_2)
                .jobDescription(JobPostingConstants.TEST_JOB_DESCRIPTION_2)
                .salary(JobPostingConstants.TEST_SALARY_2)
                .jobType(JobPostingConstants.TEST_JOB_TYPE_2)
                .salaryType(JobPostingConstants.TEST_SALARY_TYPE_2)
                .experienceLevel(JobPostingConstants.TEST_EXPERIENCE_LEVEL_2)
                .educationLevel(JobPostingConstants.TEST_EDUCATION_LEVEL_2)
                .jobStatus(JobPostingConstants.TEST_JOB_STATUS_2)
                .requirements(JobPostingConstants.TEST_REQUIREMENTS_2)
                .responsibilities(JobPostingConstants.TEST_RESPONSIBILITIES_2)
                .benefits(JobPostingConstants.TEST_BENEFITS_2)
                .jobPostedDate(JobPostingConstants.TEST_JOB_POSTED_DATE_2)
                .build();
    }
}
