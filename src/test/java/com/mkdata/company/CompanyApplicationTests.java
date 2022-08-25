package com.mkdata.company;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanyApplicationTests {
	private static boolean isAdmin = true;
	
	@Test
	void contextLoads() {
		CompanyApplication.main(new String[] {});
	}

}
