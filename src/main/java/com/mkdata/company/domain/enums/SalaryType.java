package com.mkdata.company.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SalaryType {
    HOURLY("Hourly", "Per hour"),
    MONTHLY("Monthly", "Per month"),
    YEARLY("Yearly", "Per year");

    private final String type;
    private final String description;
}
