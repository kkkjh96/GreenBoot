package com.ex01_241118.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex01_241118.dao.IBoardDao;
import com.ex01_241118.dto.BoardDto;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	IBoardDao dao;
	
	@Override
	public int regist(BoardDto board) {
		System.out.println("service...regist..." + board);
		int result = dao.insertBoard(board);
		return result;
	}
	
	@Override
	public List<BoardDto> getList(){
		System.out.println("service...getList...");
		
		List<BoardDto> list = dao.findAll();
		
		return list;
	}
	@Override
	public BoardDto getBoard(int bno){
		System.out.println("service...getList...");
		
		BoardDto board = dao.findByBno(bno);
		
		return board;
	}
	
	@Override
	public int modify(BoardDto board) {
		System.out.println("service...modify..." + board);
		int result = dao.updateBoard(board);
		System.out.println("service Modify" + result);
		return result;
	}
	
	@Override
	public int remove(int bno) {
		System.out.println("service...remove..." + bno);
		int result = dao.deleteBoard(bno);
		return result;
	}
	
	@Override
	public List<BoardDto> getListWithPaging(int startNum, int limit){
		System.out.println("***service - getListWithPaging >> " + startNum);
		List<BoardDto> list = dao.findAllWithPaging(startNum, limit);
		return list;
	}
	
	@Override
	public int totalCount() {
		int totalCount = dao.count();
		return totalCount;
	}
	
}
