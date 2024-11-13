package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.jdbc.BoardDAO;
import com.example.demo.jdbc.BoardDTO;

@Controller
public class MyController {
	
	@Autowired
	public BoardDAO dao;
	
	@GetMapping("/")
	public String root() {
		return "main";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<BoardDTO> list = dao.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping("/write")
	public String write() {
		
		return "write";
	}
	
	@PostMapping("/regBoard")
	public String reg(@RequestParam("title") String title,
			@RequestParam("writer") String writer,
			@RequestParam("content") String content) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		
		dao.reg(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/get")
	public String get() {
		
		return "getBoard";
	}
	
	@GetMapping("/searchBoard")
	public String search() {
//		ObjectMapper mapper = new ObjectMapper();
//		HashMap<String, Object> hashMap = new HashMap<String, Object>();
//		
//		BoardDTO dto = dao.getBoard(bno);
//		hashMap.put("dto", dto);
//		
//		String json = null;
//		try {
//			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(hashMap);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		System.out.println("json String =============================================" + json);
//		
//		return json;
		
		return "getBoard";
	}
	
	@GetMapping("/search")
	public @ResponseBody BoardDTO search(@RequestParam("bno") String bno) {
		BoardDTO dto = dao.getBoard(bno);
		return dto;
	}
	
	@GetMapping("/selDel")
	public String del() {
		
		return "selDel";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bno") String bno) {
		dao.delete(bno);
		return "redirect:list";
	}
}
