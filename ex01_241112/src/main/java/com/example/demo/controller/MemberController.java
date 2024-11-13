package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.IMemberDao;
import com.example.demo.dao.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	IMemberDao idao;
	
	@RequestMapping("/")
	public String root() {
		return "main";
	}
	
	@RequestMapping("/search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("/getMember")
	public String getMember(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			Model model) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto = idao.getMember(dto);
		model.addAttribute("m", dto);
		return "getMember";
	}
	
	@RequestMapping("/list")
	public String getList(Model model) {
		List<MemberDTO> list = idao.getList();
		int cnt = idao.countMember();
		model.addAttribute("list", list);
		model.addAttribute("cnt", cnt);
		return "list";
	}
	
	@RequestMapping("/reg")
	public String reg() {
		return "reg";
	}
	
	@RequestMapping("/regist")
	public String regist(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		idao.insertMember(dto);
		return "redirect:list";
	}
	
	@RequestMapping("/del")
	public String del() {
		return "del";
	}
	
	@RequestMapping("/delete")
	public String deleteMember(@RequestParam("id") String id) {
		idao.deleteMember(id);
		return "redirect:list";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "up";
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("oldid") String oldid) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		idao.updateMember(dto, oldid);
		return "redirect:list";
	}
	
}
