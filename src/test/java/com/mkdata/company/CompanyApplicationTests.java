package com.mkdata.company;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanyApplicationTests {

  private static boolean IS_ADMIN = true;

  /**
   *
   */
  @Test
  void contextLoads() {
    String[] args = { "" };
    Runnable runnable = () -> CompanyApplication.main(args);
    assertNotNull(runnable);
  }
}
