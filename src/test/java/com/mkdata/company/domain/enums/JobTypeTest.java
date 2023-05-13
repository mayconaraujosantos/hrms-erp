package com.mkdata.company.domain.enums;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class JobTypeTest {
    @Test
    public void testJobTypeGetType() {
        assertThat(JobType.FULL_TIME.getType()).isEqualTo("Full Time");
        assertThat(JobType.PART_TIME.getType()).isEqualTo("Part Time");
        assertThat(JobType.CONTRACT.getType()).isEqualTo("Contract");
        assertThat(JobType.INTERNSHIP.getType()).isEqualTo("Internship");
        assertThat(JobType.TEMPORARY.getType()).isEqualTo("Temporary");
    }

    @Test
    public void testJobTypeGetDescription() {
        assertThat(JobType.FULL_TIME.getDescription())
                .isEqualTo("A job that requires an employee to work a standard 40-hour week");
        assertThat(JobType.PART_TIME.getDescription())
                .isEqualTo("A job that requires an employee to work fewer hours than a full-time employee");
        assertThat(JobType.CONTRACT.getDescription())
                .isEqualTo("A job that has a fixed duration, usually defined by a contract");
        assertThat(JobType.INTERNSHIP.getDescription())
                .isEqualTo("A job that provides training and experience for someone new to a field");
        assertThat(JobType.TEMPORARY.getDescription())
                .isEqualTo("A job that lasts for a limited period of time, such as to cover a leave of absence");
    }

    @Test
    public void testJobTypeToString() {
        assertThat(JobType.FULL_TIME).hasToString("FULL_TIME");
        assertThat(JobType.PART_TIME).hasToString("PART_TIME");
        assertThat(JobType.CONTRACT).hasToString("CONTRACT");
        assertThat(JobType.INTERNSHIP).hasToString("INTERNSHIP");
        assertThat(JobType.TEMPORARY).hasToString("TEMPORARY");
    }

    @Test
    public void testJobTypeValueOf() {
        assertThat(JobType.valueOf("FULL_TIME")).isEqualTo(JobType.FULL_TIME);
        assertThat(JobType.valueOf("PART_TIME")).isEqualTo(JobType.PART_TIME);
        assertThat(JobType.valueOf("CONTRACT")).isEqualTo(JobType.CONTRACT);
        assertThat(JobType.valueOf("INTERNSHIP")).isEqualTo(JobType.INTERNSHIP);
        assertThat(JobType.valueOf("TEMPORARY")).isEqualTo(JobType.TEMPORARY);
    }

    @Test
    public void testJobTypeEquality() {
        JobType fullTime1 = JobType.FULL_TIME;
        JobType fullTime2 = JobType.valueOf("FULL_TIME");
        assertThat(fullTime1).isEqualTo(fullTime2);
    }

    @Test
    public void testJobTypeValueOfWithInvalidName() {
        assertThatThrownBy(() -> JobType.valueOf("INVALID"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No enum constant");
    }
}
