package com.mkdata.hrms;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HrmsErpApplicationTests {

    @Test
    void testConfigure() {
        String[] args = {""};
        Runnable runnable = () -> HrmsErpApplication.main(args);
        assertNotNull(runnable);
    }
}
