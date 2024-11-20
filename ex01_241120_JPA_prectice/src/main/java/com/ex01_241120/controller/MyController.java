package com.ex01_241120.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ex01_241120.dto.UserDto;
import com.ex01_241120.entity.Memo;
import com.ex01_241120.entity.repository.MemoRepository;
import com.ex01_241120.entity.repository.UserRepository;
import com.ex01_241120.service.IMemoService;
import com.ex01_241120.service.IUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	@Autowired
	MemoRepository memoRepository;
	
	@Autowired
	IMemoService mservice;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	IUserService uservice;
	
	@GetMapping("/")
	public String root() {
		return "main";
	}
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("user", new UserDto());
		return "signup";
	}
	
	@PostMapping("/registUser")
	public String registUser(UserDto user) {
		uservice.regist(user);
		return "redirect:/sign";
	}
	
	@GetMapping("/sign")
	public String sign(Model model) {
		model.addAttribute("user", new UserDto());
		return "sign";
	}
	
	@PostMapping("/login")
	public String login(UserDto user, HttpServletRequest request, Model model) {
		String id = user.getId();
		String pw = user.getPw();
		UserDto u = uservice.getUser(id, pw);
		if(u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "로그인에 실패하셨습니다.");
			return "redirect:/sign";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}
	
	@GetMapping("/mypage/{id}")
	public String mypage(@PathVariable("id") String id, Model model) {
		List<Memo> list = uservice.getUserList(id);
		model.addAttribute("list", list);
		return "mypage";
	}
}
