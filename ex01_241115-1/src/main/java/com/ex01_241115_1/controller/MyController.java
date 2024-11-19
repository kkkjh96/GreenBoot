package com.ex01_241115_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ex01_241115_1.dao.IMemberDao;
import com.ex01_241115_1.dto.MemberDto;

@Controller
public class MyController {

	@Autowired
	IMemberDao dao;
	
	@RequestMapping("/")
	public String root(Model model) {
		List<MemberDto> list = dao.getList();
		model.addAttribute("list", list);
		return "main";
	}
	
	@RequestMapping("/select")
	public String select(@RequestParam("name") String name, Model model) {
		List<MemberDto> list = dao.getMemberByName2(name);
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/select2")
	public String select2(@RequestParam("keyword") String keyword, @RequestParam("option") String option, Model model) {
		List<MemberDto> list  = dao.getMemberOption(keyword, option);
		model.addAttribute("list", list);
		return "list2";
	}
	
	@RequestMapping("/selectForm")
	public void selectForm() {
		
	}
	
	@RequestMapping("/modifyForm")
	public void modifyForm(@RequestParam("id") String id, Model model) {
		MemberDto dto = dao.getMember(id);
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping("/modify")
	public String modify(MemberDto memberDto, RedirectAttributes rttr) {
		
		int result = dao.modifyMember(memberDto);
		rttr.addAttribute("result", result);
		
		return "redirect:/";
	}
	
}
