package com.ex01_241120.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex01_241120.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {

	List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
	List<Memo> findByMemoText(String memoText);
	
}
