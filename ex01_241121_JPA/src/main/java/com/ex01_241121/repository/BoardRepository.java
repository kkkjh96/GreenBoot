package com.ex01_241121.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex01_241121.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	
}
