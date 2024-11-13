package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.command.Member;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MyController {
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root......");
		
		return "main";
	}
	
	@PostMapping("/test1")
	public String test1(HttpServletRequest request, Model model) {
		System.out.println("test1......");
		
		String param = request.getParameter("username");
		System.out.println("parameter : " + param);
		model.addAttribute("username", param);

		return "test1_result";
	}
	
	@PostMapping("/test2")
	public @ResponseBody String test1(@RequestParam("username") String param, Model model) {
		System.out.println("test1......");
		
		System.out.println("parameter : " + param);
		model.addAttribute("username", param);
		return "test1_result";
	}
	
	@PostMapping("/test3")
	public String test3(@ModelAttribute("m") Member member) {
		System.out.println("test3......" + member);

		return "test3_result";
	}
	
	@RequestMapping("/test4/{username}")
	public String test4(@PathVariable("username") String username, Model model) {
		
		model.addAttribute("username", username);
		
		return "test4_result";
	}
	
	@PostMapping("/test5")
	public String test5(@ModelAttribute("m") Member member, 
			@RequestParam("age") String age,
			Model model) {
		System.out.println("test5......" + member + age);
		model.addAttribute("age", age);
		return "test5_result";
	}
}
