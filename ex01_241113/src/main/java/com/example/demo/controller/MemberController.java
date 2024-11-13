package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.IMemberDao;
import com.example.demo.dto.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	IMemberDao dao;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@PostMapping("/regist")
	public @ResponseBody String regist(MemberDTO memberDTO) {
		int result = dao.insertMember(memberDTO);
		String msg = "";
		if(result != 0) {
			msg = "등록되었습니다!!";
		} else {
			msg = "등록에 실패했습니다 ㅠ.ㅠ";
		}
		return msg;
	}
	
	@RequestMapping("/list")
	public @ResponseBody List<MemberDTO> list() {
		List<MemberDTO> lists = dao.getList();
		return lists;
	}
	
	@RequestMapping("/search/{id}")
	public @ResponseBody MemberDTO search(@PathVariable("id") String id) {
		System.out.println(id);
		MemberDTO member = dao.getMember(id);
		return member;
	}
	
	@RequestMapping("/modi")
	public @ResponseBody MemberDTO modi(@RequestParam("id") String id) {
		System.out.println(id);
		MemberDTO member = dao.getMember(id);
		return member;
	}
	
	@PostMapping("/update")
	public @ResponseBody String update(MemberDTO memberDTO) {
		int result = dao.updateMember(memberDTO);
		String msg = "";
		if(result != 0) {
			msg = "수정되었습니다!!";
		} else {
			msg = "수정에 실패했습니다 ㅠ.ㅠ";
		}
		return msg;
	}
	
}
