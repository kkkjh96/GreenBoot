package com.ex01_241121.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex01_241121.dto.BoardDto;
import com.ex01_241121.entity.Board;
import com.ex01_241121.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardRepository boardRepository;
	
	@RequestMapping("/regForm")
	public String regForm() {
		
		return "/board/regForm";
	}
	
	@PostMapping("/regist")
	public String regist(BoardDto boardDto) {
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		Board b = new Board();
		List<Board> list = boardRepository.findAll();
		System.out.println(list.get(0).getModifyDate() + "aaaa");
		model.addAttribute("list", list);
		return "/board/list";
	}
}
