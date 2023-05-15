package com.mkdata.company.utils;

import com.mkdata.company.domain.enums.EducationLevel;
import com.mkdata.company.domain.enums.ExperienceLevel;
import com.mkdata.company.domain.enums.JobStatus;
import com.mkdata.company.domain.enums.JobType;
import com.mkdata.company.domain.enums.SalaryType;
import java.time.LocalDate;
import java.util.Date;

public class JobPostingConstants {

    public static final String TEST_TITLE_1 = "Software Engineer";
    public static final String TEST_DESCRIPTION_1 =
            "We are seeking a software engineer with experience in Java and Spring Boot";
    public static final String TEST_COMPANY_NAME_1 = "Acme Corporation";
    public static final String TEST_LOCATION_1 = "San Francisco, CA";
    public static final String TEST_JOB_DESCRIPTION_1 =
            "This role involves working on a variety of projects in the software engineering field...";
    public static final double TEST_SALARY_1 = 10000.0;
    public static final JobType TEST_JOB_TYPE_1 = JobType.FULL_TIME;
    public static final SalaryType TEST_SALARY_TYPE_1 = SalaryType.YEARLY;
    public static final ExperienceLevel TEST_EXPERIENCE_LEVEL_1 = ExperienceLevel.SENIOR_LEVEL;
    public static final EducationLevel TEST_EDUCATION_LEVEL_1 = EducationLevel.MASTER;
    public static final JobStatus TEST_JOB_STATUS_1 = JobStatus.OPEN;
    public static final String TEST_REQUIREMENTS_1 = "Java, Spring Boot, SQL, Git";
    public static final String TEST_RESPONSIBILITIES_1 = "Develop software, write code, collaborate with team members";
    public static final String TEST_BENEFITS_1 = "Health insurance, 401k, Paid time off";
    public static final Date TEST_JOB_POSTED_DATE_1 = JobPostingDateUtils.asDate(LocalDate.of(2022, 1, 1));

    // Constants for the second job posting
    public static final String TEST_TITLE_2 = "Data Scientist";
    public static final String TEST_DESCRIPTION_2 =
            "We are seeking a data scientist with experience in Python and machine learning";
    public static final String TEST_COMPANY_NAME_2 = "Beta Corporation";
    public static final String TEST_LOCATION_2 = "New York, NY";
    public static final String TEST_JOB_DESCRIPTION_2 =
            "This role involves working on data analysis and machine learning projects...";
    public static final double TEST_SALARY_2 = 7500.0;
    public static final JobType TEST_JOB_TYPE_2 = JobType.PART_TIME;
    public static final SalaryType TEST_SALARY_TYPE_2 = SalaryType.MONTHLY;
    public static final ExperienceLevel TEST_EXPERIENCE_LEVEL_2 = ExperienceLevel.MID_LEVEL;
    public static final EducationLevel TEST_EDUCATION_LEVEL_2 = EducationLevel.DOCTORATE;
    public static final JobStatus TEST_JOB_STATUS_2 = JobStatus.FILLED;
    public static final String TEST_REQUIREMENTS_2 = "Python, Machine Learning, SQL, Git";
    public static final String TEST_RESPONSIBILITIES_2 =
            "Analyze data, develop machine learning models, collaborate with team members";
    public static final String TEST_BENEFITS_2 = "Health insurance, 401k, Remote work";
    public static final Date TEST_JOB_POSTED_DATE_2 = JobPostingDateUtils.asDate(LocalDate.of(2023, 4, 20));
}
