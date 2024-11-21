package com.ex01_241120.entity.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ex01_241120.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Integer> {
	List<Memo> findByWriter(String writer);
	List<Memo> findByWriter(String writer, Pageable pageable);
}
