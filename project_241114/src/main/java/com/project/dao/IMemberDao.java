package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.dto.MemberDTO;

@Mapper
public interface IMemberDao {
	
	public int insertMember(MemberDTO dto);
	public List<MemberDTO> getListMember();
	public MemberDTO getMember(String id);
	public int updateMember(MemberDTO dto);
	
}
