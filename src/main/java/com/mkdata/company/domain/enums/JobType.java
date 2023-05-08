package com.mkdata.company.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobType {
    FULL_TIME("Full Time", "A job that requires an employee to work a standard 40-hour week"),
    PART_TIME("Part Time", "A job that requires an employee to work fewer hours than a full-time employee"),
    CONTRACT("Contract", "A job that has a fixed duration, usually defined by a contract"),
    INTERNSHIP("Internship", "A job that provides training and experience for someone new to a field"),
    TEMPORARY("Temporary", "A job that lasts for a limited period of time, such as to cover a leave of absence");

    private final String type;
    private final String description;

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
