package com.mkdata.company.infra.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import com.mkdata.company.domain.entity.JobPosting;
import com.mkdata.company.domain.enums.EducationLevel;
import com.mkdata.company.domain.enums.ExperienceLevel;
import com.mkdata.company.domain.enums.JobStatus;
import com.mkdata.company.domain.enums.JobType;
import com.mkdata.company.infrastructure.persistence.JobPostingRepository;
import com.mkdata.company.utils.JobPostingDateUtils;
import com.mkdata.company.utils.JobPostingUtils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@DataJpaTest
@TestPropertySource("classpath:application-test.yml")
@DirtiesContext
public class JobPostingRepositoryTest {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @BeforeEach
    public void setUp() {}

    @AfterEach
    public void tearDown() {
        jobPostingRepository.deleteAll();
    }

    @Test
    public void testFindBySalaryGreaterThanOrderBySalaryDesc() {
        List<JobPosting> jobPostingList = JobPostingUtils.createSoftwareEngineerAndDataScientistJobPostings();
        jobPostingRepository.saveAll(jobPostingList);

        List<JobPosting> jobPostings = jobPostingRepository.findBySalaryGreaterThanOrderBySalaryDesc(5000.0);
        assertThat(jobPostings).hasSize(2);
        assertThat(jobPostings.get(0).getSalary()).isEqualTo(10000.0);
        assertThat(jobPostings.get(1).getSalary()).isEqualTo(7500.0);
    }

    @Test
    public void testFindByJobDescriptionContainingIgnoreCase() {
        String descriptionToSearch = "Java";
        JobPosting jobPosting = JobPostingUtils.buildJobPostingContainingIgnoreCase();

        jobPostingRepository.save(jobPosting);

        List<JobPosting> jobPostings =
                jobPostingRepository.findByJobDescriptionContainingIgnoreCase(descriptionToSearch);

        assertThat(jobPostings)
                .isNotNull()
                .hasSizeGreaterThanOrEqualTo(1)
                .extracting(JobPosting::getJobDescription)
                .asString()
                .containsIgnoringCase(descriptionToSearch);
    }

    @Test
    public void testFindByJobPostedDateAfter() {

        Date testDate = JobPostingDateUtils.asDate(LocalDate.of(2023, 1, 1));
        JobPosting softwareEngineerJobPosting = JobPostingUtils.createSoftwareEngineerJobPosting();
        JobPosting dataScientistJobPosting = JobPostingUtils.createDataScientistJobPosting();
        jobPostingRepository.saveAll(List.of(softwareEngineerJobPosting, dataScientistJobPosting));

        List<JobPosting> result = jobPostingRepository.findByJobPostedDateAfter(testDate);

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(dataScientistJobPosting);
    }

    @Test
    public void testFindByJobTypeAndExperienceLevel() {
        JobPosting softwareEngineerJobPosting = JobPostingUtils.createSoftwareEngineerJobPosting();
        JobPosting dataScientistJobPosting = JobPostingUtils.createDataScientistJobPosting();
        jobPostingRepository.saveAll(List.of(softwareEngineerJobPosting, dataScientistJobPosting));

        List<JobPosting> result =
                jobPostingRepository.findByJobTypeAndExperienceLevel(JobType.FULL_TIME, ExperienceLevel.SENIOR_LEVEL);

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(softwareEngineerJobPosting);
    }

    @Test
    public void testFindByJobStatusAndJobPostedDateBefore() {
        Date testDate = JobPostingDateUtils.asDate(LocalDate.of(2023, 5, 1));
        JobPosting softwareEngineerJobPosting = JobPostingUtils.createSoftwareEngineerJobPosting();
        JobPosting dataScientistJobPosting = JobPostingUtils.createDataScientistJobPosting();
        jobPostingRepository.saveAll(List.of(softwareEngineerJobPosting, dataScientistJobPosting));

        List<JobPosting> result = jobPostingRepository.findByJobStatusAndJobPostedDateBefore(JobStatus.OPEN, testDate);

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(softwareEngineerJobPosting);
    }

    @Test
    public void testFindByEducationLevelGreaterThanEqualAndJobType() {
        JobPosting softwareEngineerJobPosting = JobPostingUtils.createSoftwareEngineerJobPosting();
        JobPosting dataScientistJobPosting = JobPostingUtils.createDataScientistJobPosting();
        jobPostingRepository.saveAll(List.of(softwareEngineerJobPosting, dataScientistJobPosting));

        List<JobPosting> result = jobPostingRepository.findByEducationLevelGreaterThanEqualAndJobType(
                EducationLevel.BACHELOR, JobType.FULL_TIME);

        assertThat(result).isNotEmpty().contains(softwareEngineerJobPosting).doesNotContain(dataScientistJobPosting);
    }

    @Test
    public void testFindOpenJobPostings() {
        JobPosting softwareEngineerJobPosting = JobPostingUtils.createSoftwareEngineerJobPosting();
        JobPosting dataScientistJobPosting = JobPostingUtils.createDataScientistJobPosting();
        softwareEngineerJobPosting.setJobStatus(JobStatus.OPEN);
        softwareEngineerJobPosting.setApplicationDeadline(Date.from(
                LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        dataScientistJobPosting.setJobStatus(JobStatus.CLOSED);
        jobPostingRepository.saveAll(List.of(softwareEngineerJobPosting, dataScientistJobPosting));

        List<JobPosting> result = jobPostingRepository.findOpenJobPostings();

        assertThat(result).isNotEmpty().contains(softwareEngineerJobPosting).doesNotContain(dataScientistJobPosting);
    }

    @Test
    public void testFindAllByOrderByJobPostedDateDesc() {
        JobPosting softwareEngineerJobPosting = JobPostingUtils.createSoftwareEngineerJobPosting();
        JobPosting dataScientistJobPosting = JobPostingUtils.createDataScientistJobPosting();
        softwareEngineerJobPosting.setJobPostedDate(JobPostingDateUtils.createDate(2023, 4, 20));
        dataScientistJobPosting.setJobPostedDate(JobPostingDateUtils.createDate(2023, 5, 20));
        jobPostingRepository.saveAll(List.of(softwareEngineerJobPosting, dataScientistJobPosting));

        List<JobPosting> result = jobPostingRepository.findAllByOrderByJobPostedDateDesc();

        assertThat(result).isNotEmpty().hasSize(2).contains(dataScientistJobPosting);
    }
}
