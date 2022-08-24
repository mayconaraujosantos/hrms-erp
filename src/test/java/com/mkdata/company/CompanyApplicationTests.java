package com.mkdata.company;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanyApplicationTests {
	private static boolean isAdmin = true;
	
	@Test
	void contextLoads() {
		assertTrue(isAdmin);
	}

}
