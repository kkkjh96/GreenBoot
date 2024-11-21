package com.ex01_241121.repositoryTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ex01_241121.entity.Board;
import com.ex01_241121.repository.BoardRepository;
@SpringBootTest
class BoardRepositoryTest {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	void testUpdate() {
		
		Board board = Board.builder()
				.bno(1)
				.title("수정2...test 제목 1")
				.content("수정2...content 내용 1")
				.writer("user01")
				.build();
		
		Board result = boardRepository.save(board);
		System.out.println(result);
	}
	
//	@Test
	void testInsert() {
		
		Board board = Board.builder()
				.title("test 제목 1")
				.content("content 내용 1")
				.writer("user01")
				.build();
		
		Board result = boardRepository.save(board);
		System.out.println(result);
	}

}
