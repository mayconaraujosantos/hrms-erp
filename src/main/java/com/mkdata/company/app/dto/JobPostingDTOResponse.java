package com.mkdata.company.app.dto;

import com.mkdata.company.domain.enums.EducationLevel;
import com.mkdata.company.domain.enums.ExperienceLevel;
import com.mkdata.company.domain.enums.JobStatus;
import com.mkdata.company.domain.enums.JobType;
import com.mkdata.company.domain.enums.SalaryType;
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JobPostingDTOResponse {
    private Long id;
    private String title;
    private String description;
    private String companyName;
    private String location;
    private String jobDescription;
    private Double salary;
    private JobType jobType;
    private SalaryType salaryType;
    private ExperienceLevel experienceLevel;
    private EducationLevel educationLevel;
    private JobStatus jobStatus;
    private String requirements;
    private String responsibilities;
    private String benefits;
    private Date jobPostedDate;
    private Date applicationDeadline;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
}
