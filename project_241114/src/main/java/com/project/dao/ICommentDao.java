package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.dto.CommentDTO;

@Mapper
public interface ICommentDao {
	public int insertComment(CommentDTO dto);
	public List<CommentDTO> getListComment(String bno);
	public int updateComment(CommentDTO boardDTO);
	public int deleteComment(String cno);
}
