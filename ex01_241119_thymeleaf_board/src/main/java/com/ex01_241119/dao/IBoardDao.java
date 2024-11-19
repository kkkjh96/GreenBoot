package com.ex01_241119.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ex01_241119.dto.BoardDto;

@Mapper
public interface IBoardDao {
	//등록
	public int insertBoard(@Param("board") BoardDto board);
	//목록 조회
	public List<BoardDto> findAll();
	//개별 조회
	public BoardDto findByBno(int bno);
	//수정
	public int updateBoard(@Param("board") BoardDto board);
	//삭제
	public int deleteBoard(int bno);
	//페이징
	public List<BoardDto> findAllWithPaging(@Param("startNum") int startNum, @Param("limit") int limit);
	//게시글 수 조회
	public int count();
}
