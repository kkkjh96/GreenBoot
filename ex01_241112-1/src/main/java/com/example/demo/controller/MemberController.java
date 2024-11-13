package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.IMemberDao;
import com.example.demo.dto.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	IMemberDao dao;
	
	@RequestMapping("/")
	public String root() {
		return "main";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<MemberDTO> list = dao.getList();
		model.addAttribute("list", list);
		return "list";
	}
}
