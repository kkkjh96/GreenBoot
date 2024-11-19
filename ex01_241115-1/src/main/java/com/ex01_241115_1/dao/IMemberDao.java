package com.ex01_241115_1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ex01_241115_1.dto.MemberDto;

@Mapper
public interface IMemberDao {

	public List<MemberDto> getList();
	public MemberDto getMember(String id);
	
	public List<MemberDto> getMemberByName(String name);
	public List<MemberDto> getMemberByName2(String name);
	public List<MemberDto> getMemberOption(@Param("keyword") String keyword, @Param("option") String option);
	
	public int saveMember(@Param("member") MemberDto dto);
	public int modifyMember(@Param("member") MemberDto dto);
}
