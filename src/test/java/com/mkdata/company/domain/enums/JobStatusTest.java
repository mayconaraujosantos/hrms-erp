package com.mkdata.company.domain.enums;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class JobStatusTest {
    @Test
    public void testJobStatusGetStatus() {
        assertThat(JobStatus.DRAFT.getStatus()).isEqualTo("Draft");
        assertThat(JobStatus.OPEN.getStatus()).isEqualTo("Open");
        assertThat(JobStatus.CLOSED.getStatus()).isEqualTo("Closed");
        assertThat(JobStatus.FILLED.getStatus()).isEqualTo("Filled");
        assertThat(JobStatus.CANCELED.getStatus()).isEqualTo("Canceled");
    }

    @Test
    public void testJobStatusGetDescription() {
        assertThat(JobStatus.DRAFT.getDescription()).isEqualTo("The job posting is still being created");
        assertThat(JobStatus.OPEN.getDescription()).isEqualTo("The job is open and accepting applications");
        assertThat(JobStatus.CLOSED.getDescription()).isEqualTo("The job is no longer accepting applications");
        assertThat(JobStatus.FILLED.getDescription()).isEqualTo("The job has been filled");
        assertThat(JobStatus.CANCELED.getDescription()).isEqualTo("The job posting has been canceled");
    }

    @Test
    public void testJobStatusToString() {
        assertThat(JobStatus.DRAFT).hasToString("DRAFT");
        assertThat(JobStatus.OPEN).hasToString("OPEN");
        assertThat(JobStatus.CLOSED).hasToString("CLOSED");
        assertThat(JobStatus.FILLED).hasToString("FILLED");
        assertThat(JobStatus.CANCELED).hasToString("CANCELED");
    }

    @Test
    public void testJobStatusValueOf() {
        assertThat(JobStatus.valueOf("DRAFT")).isEqualTo(JobStatus.DRAFT);
        assertThat(JobStatus.valueOf("OPEN")).isEqualTo(JobStatus.OPEN);
        assertThat(JobStatus.valueOf("CLOSED")).isEqualTo(JobStatus.CLOSED);
        assertThat(JobStatus.valueOf("FILLED")).isEqualTo(JobStatus.FILLED);
        assertThat(JobStatus.valueOf("CANCELED")).isEqualTo(JobStatus.CANCELED);
    }

    @Test
    public void testJobStatusEquality() {
        JobStatus open1 = JobStatus.OPEN;
        JobStatus open2 = JobStatus.valueOf("OPEN");
        assertThat(open1).isEqualTo(open2);
    }

    @Test
    public void testJobStatusValueOfWithInvalidName() {
        assertThatThrownBy(() -> JobStatus.valueOf("INVALID"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No enum constant");
    }
}
