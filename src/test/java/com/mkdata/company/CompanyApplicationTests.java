package com.mkdata.company;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanyApplicationTests {

  @Test
  void contextLoads() {
    String[] args = { "" };
    Runnable runnable = () -> CompanyApplication.main(args);
    Assertions.assertNotNull(runnable);
  }
}
