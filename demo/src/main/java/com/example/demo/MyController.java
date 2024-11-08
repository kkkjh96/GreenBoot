package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody Member root() {
		Member m = new Member();
		m.setId("aaa");
		m.setPw("111");
		m.setName("홍길동");
		return m;
	}
	@GetMapping("/p2")
	public String root2() {
		System.out.println("p2......................");
		return "p2";
	}
	@GetMapping("/p3")
	public String root3() {
		System.out.println("p3......................");
		return "sub/p3";
	}
	@GetMapping("/test")
	public String test(Model model) {
		
		model.addAttribute("name", "홍길동");
		
		return "test";
	}
}
