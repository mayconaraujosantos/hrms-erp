package com.mkdata.company.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobStatus {
    DRAFT("Draft", "The job posting is still being created"),
    OPEN("Open", "The job is open and accepting applications"),
    CLOSED("Closed", "The job is no longer accepting applications"),
    FILLED("Filled", "The job has been filled"),
    CANCELED("Canceled", "The job posting has been canceled");

    private final String status;
    private final String description;
}
