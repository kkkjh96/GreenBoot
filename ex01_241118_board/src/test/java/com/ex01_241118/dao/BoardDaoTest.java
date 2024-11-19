package com.ex01_241118.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ex01_241118.dto.BoardDto;

@SpringBootTest
class BoardDaoTest {

	@Autowired
	IBoardDao bdao;
	
//	@Test
//	void testInsert() {
//		int result = 0;
//		for(int count = 1; count < 25; count++) {		
//			BoardDto bdto = BoardDto.builder()
//					.title("test " + count)
//					.content("test 내용 " + count)
//					.writer("admin")
//					.filename("ready.png")
//					.build();
//			result += bdao.insertBoard(bdto);
//		}
//		
//		assertEquals(result, 24);
//	}
//
//	@Test
//	void testDelete() {
//		int result = 0;
//		result = bdao.deleteBoard(24);
//		assertEquals(result, 1);
//	}
	
	@Test
	void testSelect() {
		BoardDto dto = bdao.findByBno(1);
		assertNotNull(dto);
	}
	
	@Test
	void testList() {
		List<BoardDto> list = bdao.findAll();
		assertNotNull(list);
	}
	
	@Test
	void testUpdate() {
		int result = 0;
		BoardDto dto = BoardDto.builder()
				.bno(23)
				.title("23 Test")
				.content("23 TEST 내용")
				.filename("ready.png")
				.build();
		result = bdao.updateBoard(dto);
		assertEquals(result, 1);
	}
	


}
