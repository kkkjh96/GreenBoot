package com.ex01_241122.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex01_241122.dto.TeamMemberDto;

@Controller
public class MainController {

	@RequestMapping("/")
	public String root() {
		return "main";
	}
	
	@RequestMapping("/regForm")
	public String regForm(Model model) {
			List<TeamMemberDto> list = new ArrayList<>();
			list.add(new TeamMemberDto());
		    list.add(new TeamMemberDto());
		    list.add(new TeamMemberDto());
		model.addAttribute("list", list);
		return "regForm";
	}
	
	@RequestMapping("/list")
	public String list() {
		
		return "list";
	}
}
