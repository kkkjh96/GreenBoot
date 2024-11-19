package com.ex01_241119.service;

import java.util.List;

import com.ex01_241119.dto.BoardDto;

public interface IBoardService {
	
	public int regist(BoardDto board);
	public List<BoardDto> getList();
	public BoardDto getBoard(int bno);
	public int modify(BoardDto board);
	public int remove(int bno);
	public List<BoardDto> getListWithPaging(int startNum, int limit);
	public int totalCount();
	
}
