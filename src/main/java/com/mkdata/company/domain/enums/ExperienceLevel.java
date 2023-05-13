package com.mkdata.company.domain.enums;

import com.mkdata.company.domain.exception.InvalidYearsOfExperienceException;
import lombok.Getter;

@Getter
public enum ExperienceLevel {
    ENTRY_LEVEL(0),
    MID_LEVEL(3),
    SENIOR_LEVEL(7),
    EXECUTIVE(10);

    private final int yearsOfExperience;

    private ExperienceLevel(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public static ExperienceLevel fromYearsOfExperience(int yearsOfExperience) {
        return switch (yearsOfExperience) {
            case 0 -> ENTRY_LEVEL;
            case 3 -> MID_LEVEL;
            case 7 -> SENIOR_LEVEL;
            case 10 -> EXECUTIVE;
            default -> throw new InvalidYearsOfExperienceException("Invalid years of experience: " + yearsOfExperience);
        };
    }
}
