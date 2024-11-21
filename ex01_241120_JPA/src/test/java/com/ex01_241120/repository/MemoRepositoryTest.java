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
	
//	@Test
	void testQueryMethod2() {
		List<Memo> list = memoRepository.findByMemoText("Sample...... 78");
		System.out.println("Title----------");
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	//page 처리
//	@Test
	void testPageDefault() {
		//1페이지 10개
		Pageable pageable = PageRequest.of(3, 10);
		Page<Memo> result = memoRepository.findAll(pageable);
		
		System.out.println(result);
		System.out.println("------------------------");
		
		System.out.println("Total page : " + result.getTotalPages());	// 총 페이지 수
		System.out.println("Total count : " + result.getTotalElements());	// 전체 개수
		System.out.println("Page Number : " + result.getNumber());	// 현재 페이지번호(0부터시작)
		System.out.println("Page Size : " + result.getSize());	// 페이지당 데이터 개수
		System.out.println("has next page? : " + result.hasNext());	// 다음 페이지
		System.out.println("has rist page? : " + result.isFirst());	// 시작 페이지(0) 여부
		
		System.out.println("------------------------");
		
		for(Memo memo : result.getContent()) {
			System.out.println(memo);
		}
	}
	
//	@Test
	void testSort() {
		Sort sort1 = Sort.by("mno").descending();
		Sort sort2 = Sort.by("memoText").ascending();
		Sort sortAll = sort1.and(sort2);
		
		Pageable pageable = PageRequest.of(0,  10, sort1);
		
		Page<Memo> result = memoRepository.findAll(pageable);
		List<Memo> list = new ArrayList<>();
		result.get().forEach(memo -> {
			list.add(memo);
		});
		
		System.out.println(list);
	}
	
//	@Commit
//	@Transactional
//	@Test
	void testDeleteQueryMethod() {
		memoRepository.deleteMemoByMnoLessThan(10L);
	}
	
//	@Test
	void testQueryMethodWithPageable() {
		
		Pageable pageable = PageRequest.of(2, 10, Sort.by("mno"));
		Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);
		result.get().forEach(memo -> System.out.println(memo));
		
	}
	
//	@Test
	void testCount() {
		Long from = memoRepository.count();
		System.out.println(from);
	}
	
//	@Test
	void testTotalPage() {
		 Pageable pageable = PageRequest.of(0, 8);
	     Page<Memo> entityPage = memoRepository.findAll(pageable);
	     
	     System.out.println("전체 페이지 수 : " + entityPage.getTotalPages());
	     System.out.println("전체 게시물 수 : " + entityPage.getTotalElements());
	}
	
//	@Test
	void testJPQL1() {
		List<Memo> list = memoRepository.getList();
		for(Memo m : list) {			
			System.out.println(m);
		}
	}
	
//	@Test
	void testJPQL2() {
		Memo m = memoRepository.getMemo(50L);
			System.out.println(m);
	}
	
//	@Test
	void testJPQL3() {
		int cnt = memoRepository.getCount();
		System.out.println(cnt);
	}
	
//	@Test
	void testJPQL4() {
		List<Memo> list = memoRepository.getListWithKeyword("%2%");
		for(Memo m : list) {			
			System.out.println(m);
		}
	}

	@Test
	void testNativeQuery() {
		List<Memo> list = memoRepository.getListNative();
		for(Memo m : list) {
			System.out.println(m);
		}
	}
	
}
