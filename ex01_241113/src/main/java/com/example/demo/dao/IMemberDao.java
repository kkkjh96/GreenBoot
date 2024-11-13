package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.MemberDTO;

@Mapper
public interface IMemberDao {
	public int insertMember(@Param("member") MemberDTO dto);
	public List<MemberDTO> getList();
	public MemberDTO getMember(String id);
	public int updateMember(@Param("member") MemberDTO dto);
}
