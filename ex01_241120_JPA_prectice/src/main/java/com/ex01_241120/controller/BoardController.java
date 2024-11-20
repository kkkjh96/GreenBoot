package com.ex01_241120.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex01_241120.dto.MemoDto;
import com.ex01_241120.entity.Memo;
import com.ex01_241120.entity.repository.MemoRepository;
import com.ex01_241120.service.IMemoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	MemoRepository memoRepository;
	
	@Autowired
	IMemoService mservice;
	
	@GetMapping("/registForm")
	public String regist(Model model, HttpSession session) {
		String username = (String) session.getAttribute("id");
		if(username != null) {
			model.addAttribute("memo", new MemoDto());
			return "regForm";			
		} else {
			return "redirect:/sign";
		}
	}
	
	@PostMapping("/regist")
	public String regist(MemoDto memo, Model model, @RequestParam("writer") String writer) {
		MemoDto m = MemoDto.builder()
				.memoText(memo.getMemoText())
				.writer(writer)
				.build();
		System.out.println(m);
		mservice.regist(m);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Memo> list = mservice.getList();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/detail/{mno}")
	public String detali(@PathVariable("mno") int mno, Model model) {
		MemoDto memo = mservice.getMemo(mno);
		model.addAttribute("memo", memo);
		return "detail";
	}
	
	@RequestMapping("/modify")
	public String modify(@ModelAttribute MemoDto memo) {
		mservice.updateMemo(memo);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/delete/{mno}")
	public String delete(@PathVariable("mno") int mno) {
		mservice.deleteMemo(mno);
		return "redirect:/board/list";
	}
}
