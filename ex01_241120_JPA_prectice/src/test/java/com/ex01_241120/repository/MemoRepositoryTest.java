package com.ex01_241120.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ex01_241120.entity.Memo;
import com.ex01_241120.entity.repository.MemoRepository;

@SpringBootTest
class MemoRepositoryTest {
	
	@Autowired
	MemoRepository memoRepository;
	
	// 삽입
	@Test
	void testInsertDummies() {
		
		for(int i = 11; i <= 40; i++) {		
			Memo memo = Memo.builder()
					.memoText("Sample...... " + i)
					.writer("aaa")
					.build();
			memoRepository.save(memo);
		}
		
//		IntStream.rangeClosed(101, 200).forEach(i -> {
//			Memo memo = Memo.builder().memoText("Sample...... " + i).build();
//			memoRepository.save(memo);
//		});
		
	}
	


}
