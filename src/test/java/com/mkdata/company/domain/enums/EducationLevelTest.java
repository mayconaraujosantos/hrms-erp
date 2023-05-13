package com.mkdata.company.domain.enums;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.mkdata.company.domain.entity.JobPosting;
import com.mkdata.company.infrastructure.persistence.JobPostingRepository;
import com.mkdata.company.utils.JobPostingUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
@Rollback(false)
@TestInstance(Lifecycle.PER_CLASS)
public class EducationLevelTest {

    @Autowired
    JobPostingRepository jobPostingRepository;

    @BeforeAll
    void init() {
        jobPostingRepository.deleteAll();
    }

    @Test
    void testEnumConversion() {
        JobPosting jobPosting = JobPostingUtils.makeJobPostingWithEnums();
        assertThat(jobPostingRepository.save(jobPosting)).isNotNull();
    }

    @Test
    public void testEducationLevelGetEducationLevel() {
        assertThat(EducationLevel.HIGH_SCHOOL.getDescriptionLevel()).isEqualTo("High School");
        assertThat(EducationLevel.ASSOCIATE.getDescriptionLevel()).isEqualTo("Associate's Degree");
        assertThat(EducationLevel.BACHELOR.getDescriptionLevel()).isEqualTo("Bachelor's Degree");
        assertThat(EducationLevel.MASTER.getDescriptionLevel()).isEqualTo("Master's Degree");
        assertThat(EducationLevel.DOCTORATE.getDescriptionLevel()).isEqualTo("Doctorate Degree");
    }

    @Test
    public void testEducationLevelToString() {
        assertThat(EducationLevel.HIGH_SCHOOL).hasToString("HIGH_SCHOOL");
        assertThat(EducationLevel.ASSOCIATE).hasToString("ASSOCIATE");
        assertThat(EducationLevel.BACHELOR).hasToString("BACHELOR");
        assertThat(EducationLevel.MASTER).hasToString("MASTER");
        assertThat(EducationLevel.DOCTORATE).hasToString("DOCTORATE");
    }

    @Test
    public void testEducationLevelValueOf() {
        assertThat(EducationLevel.valueOf("HIGH_SCHOOL")).isEqualTo(EducationLevel.HIGH_SCHOOL);
        assertThat(EducationLevel.valueOf("ASSOCIATE")).isEqualTo(EducationLevel.ASSOCIATE);
        assertThat(EducationLevel.valueOf("BACHELOR")).isEqualTo(EducationLevel.BACHELOR);
        assertThat(EducationLevel.valueOf("MASTER")).isEqualTo(EducationLevel.MASTER);
        assertThat(EducationLevel.valueOf("DOCTORATE")).isEqualTo(EducationLevel.DOCTORATE);
    }

    @Test
    public void testEducationLevelOrder() {
        assertThat(EducationLevel.values())
                .containsExactly(
                        EducationLevel.HIGH_SCHOOL,
                        EducationLevel.ASSOCIATE,
                        EducationLevel.BACHELOR,
                        EducationLevel.MASTER,
                        EducationLevel.DOCTORATE);
    }

    @Test
    public void testEducationLevelEquality() {
        EducationLevel bachelor1 = EducationLevel.BACHELOR;
        EducationLevel bachelor2 = EducationLevel.valueOf("BACHELOR");
        assertThat(bachelor1).isEqualTo(bachelor2);
    }
}
