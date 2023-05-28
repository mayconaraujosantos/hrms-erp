package com.mkdata.hrms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HrmsErpApplicationTests {

    @Test
    void contextLoads() {
        String[] args = {};
        Runnable runnable = () -> HrmsErpApplication.main(args);
    }
}
