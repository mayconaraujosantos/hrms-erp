package com.mkdata.company.domain.enums;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class SalaryTypeTest {
    @Test
    public void testSalaryTypeGetType() {
        assertThat(SalaryType.HOURLY.getType()).isEqualTo("Hourly");
        assertThat(SalaryType.MONTHLY.getType()).isEqualTo("Monthly");
        assertThat(SalaryType.YEARLY.getType()).isEqualTo("Yearly");
    }

    @Test
    public void testSalaryTypeGetDescription() {
        assertThat(SalaryType.HOURLY.getDescription()).isEqualTo("Per hour");
        assertThat(SalaryType.MONTHLY.getDescription()).isEqualTo("Per month");
        assertThat(SalaryType.YEARLY.getDescription()).isEqualTo("Per year");
    }

    @Test
    public void testSalaryTypeToString() {
        assertThat(SalaryType.HOURLY).hasToString("HOURLY");
        assertThat(SalaryType.MONTHLY).hasToString("MONTHLY");
        assertThat(SalaryType.YEARLY).hasToString("YEARLY");
    }

    @Test
    public void testSalaryTypeValueOf() {
        assertThat(SalaryType.valueOf("HOURLY")).isEqualTo(SalaryType.HOURLY);
        assertThat(SalaryType.valueOf("MONTHLY")).isEqualTo(SalaryType.MONTHLY);
        assertThat(SalaryType.valueOf("YEARLY")).isEqualTo(SalaryType.YEARLY);
    }

    @Test
    public void testSalaryTypeEquality() {
        SalaryType hourly1 = SalaryType.HOURLY;
        SalaryType hourly2 = SalaryType.valueOf("HOURLY");
        assertThat(hourly1).isEqualTo(hourly2);
    }

    @Test
    public void testSalaryTypeValueOfWithInvalidName() {
        assertThatThrownBy(() -> SalaryType.valueOf("INVALID"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No enum constant");
    }
}
