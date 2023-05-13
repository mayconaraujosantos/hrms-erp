package com.mkdata.company.domain.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.mkdata.company.domain.exception.InvalidYearsOfExperienceException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExperienceLevelTest {

    @Test
    public void testFromYearsOfExperience_entryLevel() {
        assertThat(ExperienceLevel.fromYearsOfExperience(0)).isEqualTo(ExperienceLevel.ENTRY_LEVEL);
    }

    @Test
    public void testFromYearsOfExperience_midLevel() {
        assertThat(ExperienceLevel.fromYearsOfExperience(3)).isEqualTo(ExperienceLevel.MID_LEVEL);
    }

    @Test
    public void testFromYearsOfExperience_seniorLevel() {
        assertThat(ExperienceLevel.fromYearsOfExperience(7)).isEqualTo(ExperienceLevel.SENIOR_LEVEL);
    }

    @Test
    public void testFromYearsOfExperience_executive() {
        assertThat(ExperienceLevel.fromYearsOfExperience(10)).isEqualTo(ExperienceLevel.EXECUTIVE);
    }

    @Test
    public void testFromYearsOfExperience_invalidYearsOfExperience() {
        assertThatThrownBy(() -> ExperienceLevel.fromYearsOfExperience(-1))
                .isInstanceOf(InvalidYearsOfExperienceException.class)
                .hasMessageContaining("Invalid years of experience: -1");

        assertThatThrownBy(() -> ExperienceLevel.fromYearsOfExperience(2))
                .isInstanceOf(InvalidYearsOfExperienceException.class)
                .hasMessageContaining("Invalid years of experience: 2");

        assertThatThrownBy(() -> ExperienceLevel.fromYearsOfExperience(5))
                .isInstanceOf(InvalidYearsOfExperienceException.class)
                .hasMessageContaining("Invalid years of experience: 5");
    }
}
