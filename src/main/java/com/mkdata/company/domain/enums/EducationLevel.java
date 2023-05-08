package com.mkdata.company.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EducationLevel {
    HIGH_SCHOOL("High School"),
    ASSOCIATE("Associate's Degree"),
    BACHELOR("Bachelor's Degree"),
    MASTER("Master's Degree"),
    DOCTORATE("Doctorate Degree");

    private final String educationLevel;

    public String getEducationLevel() {
        return educationLevel;
    }
}
