package com.example.demo;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainTest {
	
	@GetMapping("/")
	public String root(Model model) {
		
		model.addAttribute("name", "홍길동");
		model.addAttribute("name", "전우치");
		model.addAttribute("member1", new Member("aaa", "111", "홍길동"));
		model.addAttribute("member2", new Member("bbb", "111", "전우치"));
		List<Member> list = new Vector<>();
		list.add(new Member("aaa", "111", "홍길동"));
		list.add(new Member("bbb", "111", "전우치"));
		model.addAttribute("member", list);
		
		return "test";
	}
}
