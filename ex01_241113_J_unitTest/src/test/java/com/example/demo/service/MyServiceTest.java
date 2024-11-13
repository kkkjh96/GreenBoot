package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyServiceTest {

	@Autowired
	MyService service;
	
	@Test
	void testList() {
		List<String> list = service.list();
		
		assertNotNull(list);
	}
	
	@Test
	void testGetString() {
		String s = service.getString(1);
		
		assertEquals(s, "aaa");
	}

}
