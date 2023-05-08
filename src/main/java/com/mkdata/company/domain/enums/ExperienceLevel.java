package com.mkdata.company.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExperienceLevel {
    ENTRY_LEVEL(0),
    MID_LEVEL(3),
    SENIOR_LEVEL(7),
    EXECUTIVE(10);

    private final int yearsOfExperience;

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
