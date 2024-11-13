package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMemberDao {
//	public MemberDTO getMember(@Param("id") String id, @Param("pw") String pw);
	public MemberDTO getMember(MemberDTO dto);
	public List<MemberDTO> getList();
	public int insertMember(MemberDTO dto);
	public int deleteMember(String id);
	public int updateMember(@Param("member") MemberDTO dto, @Param("id") String id);
	public int countMember();
}
