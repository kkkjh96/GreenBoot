package com.ex01_241120.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ex01_241120.entity.Memo;

@SpringBootTest
class MemoRepositoryTest {
	
	@Autowired
	MemoRepository memoRepository;

	// 삽입
//	@Test
	void testInsertDummies() {
		
		for(int i = 1; i <= 100; i++) {		
			Memo memo = Memo.builder()
					.memoText("Sample...... " + i)
					.build();
			memoRepository.save(memo);
		}
		
//		IntStream.rangeClosed(101, 200).forEach(i -> {
//			Memo memo = Memo.builder().memoText("Sample...... " + i).build();
//			memoRepository.save(memo);
//		});
		
	}
	
	// 조회
//	@Test
	void testSelect() {
		Long mno = 100L;
		
		Optional<Memo> result = memoRepository.findById(mno);
		// Optional : null인지 아닌지 판단 해준다.
		if(result.isPresent()) {
			Memo memo = result.get();
			System.out.println(memo);
		}
	}

	// 전체 조회
//	@Test
	void testSelectAll() {
		
		List<Memo> list = memoRepository.findAll();
		System.out.println("전체 조회 실행 ------ ");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 향상된 포문으로 출력
//		for(Memo memo : list) {
//			System.out.println(memo);
//		}
		System.out.println("전체 조회 종료 ------ ");
		
	}
	
	//수정
//	@Test
	void testUpdate() {
		Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
		
		System.out.println(memoRepository.save(memo));
	}
	
	//삭제
//	@Test
	void testDelete() {
		Long mno = 100L;
		
		memoRepository.deleteById(mno);
	}
	
//	@Test
	void testQueryMethod1() {
		List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
		System.out.println("Between----------");
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	void testQueryMethod2() {
		List<Memo> list = memoRepository.findByMemoText("Sample...... 78");
		System.out.println("Title----------");
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}

}
