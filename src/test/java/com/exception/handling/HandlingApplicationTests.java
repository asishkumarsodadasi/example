package com.exception.handling;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HandlingApplicationTests {

	@Test
	void contextLoads() {
		String s = "hi";
		Assert.assertEquals("hi",s);
	}

}
