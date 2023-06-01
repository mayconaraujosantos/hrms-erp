package com.hrms.auth;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthApplicationTests {

    @Test
    void contextLoads() {
        String[] args = {""};
        Runnable runnable = () -> AuthApplication.main(args);
    }
}
