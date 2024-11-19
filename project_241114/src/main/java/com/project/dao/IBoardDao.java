package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.dto.BoardDTO;

@Mapper
public interface IBoardDao {

	public int insertBoard(BoardDTO dto);
	public List<BoardDTO> getListBoard(@Param("limit") int limit, @Param("offset")int offset);
	public List<BoardDTO> getList();
	public int getBoardCount();
	public BoardDTO getBoard(String bno);
	public int updateBoard(BoardDTO boardDTO);
	public int deleteBoard(String bno);
	
}
