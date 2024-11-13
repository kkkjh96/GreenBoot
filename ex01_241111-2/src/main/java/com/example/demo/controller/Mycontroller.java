package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.jdbc.MyUserDAO;
import com.example.demo.jdbc.MyUserDTO;

@Controller
public class Mycontroller {

	@Autowired
	private MyUserDAO dao;
	
	@RequestMapping("/")
	public String root() {
		
		System.out.println("root......");
		
		return "main";
	}
	
	@RequestMapping("/list")
	public String root1(Model model) {
		System.out.println("root......");
		List<MyUserDTO> list = dao.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/regUser")
	public String regUser(@RequestParam("id") String id, 
							@RequestParam("name") String name,
							Model model) {
		MyUserDTO dto = new MyUserDTO();
		dto.setId(id);
		dto.setName(name);
		
		int result = dao.insert(dto);
		String msg = null;
		if(result != 0) {
			msg = "등록 성공!!!";
			System.out.println("등록 성공!!!");
		} else {
			msg = "등록 실패...";
		}
		
		model.addAttribute("msg", msg);
		return "redirect:list";
		
	}
	
	@RequestMapping("/delUser")
	public String delUser(@RequestParam("id") String id, 
			Model model) {

		int result = dao.delete(id);
		String msg = null;
		if(result != 0) {
			msg = "삭제 성공!!!";
			System.out.println("등록 성공!!!");
		} else {
			msg = "삭제 실패...";
		} 
		
		model.addAttribute("msg", msg);
		return "redirect:list";
		
	}
	@RequestMapping("/modiUser")
	public String delUser(@RequestParam("newid") String newid,
							@RequestParam("oldid") String oldid,
							Model model) {
		
		int result = dao.modify(newid, oldid);
		String msg = null;
		if(result != 0) {
			msg = "삭제 성공!!!";
			System.out.println("삭제 성공!!!");
		} else {
			msg = "삭제 실패...";
		}
		
		model.addAttribute("msg", msg);
		return "redirect:list";
		
	}
	@RequestMapping("/getUser")
	public String getUser(@RequestParam("id") String id,
			Model model) {
		
		MyUserDTO dto = dao.getUser(id);

		model.addAttribute("dto", dto);
		return "get";
		
	}

}
