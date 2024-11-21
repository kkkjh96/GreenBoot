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
		return "redirect:/board/list/1";
	}
	
	@RequestMapping("/list/{page}")
	public String list(@PathVariable("page") int page,
			@RequestParam(value="size", defaultValue = "5") int size, Model model) {
		int page1 = page - 1;
//		List<Memo> list = mservice.getList();
		List<Memo> list = mservice.getPageList(page1, size);
		int totalCount = mservice.totalCount();
		int totalPage = mservice.totalPageSize(size);
		int cnt = totalCount - (size * page1);
		int[] pageArr = {1, 2, 3, 4, 5};
		
		if(totalPage > 5) {
			if(page >= 3 && page <= totalPage - 2) {
				pageArr[0] = page - 2;
				pageArr[1] = page - 1;
				pageArr[2] = page;
				pageArr[3] = page + 1;
				pageArr[4] = page + 2;
			} else if(page == totalPage - 1) {
				pageArr[0] = page - 3;
				pageArr[1] = page - 2;
				pageArr[2] = page - 1;
				pageArr[3] = page;
				pageArr[4] = page + 1;
			} else if(page == totalPage) {
				pageArr[0] = page - 4;
				pageArr[1] = page - 3;
				pageArr[2] = page - 2;
				pageArr[3] = page - 1;
				pageArr[4] = page;
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("cnt", cnt);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageArr", pageArr);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageSize", size);
		model.addAttribute("currentPage", page);
		return "list";
	}
	
	@RequestMapping("/detail/{mno}")
	public String detali(@PathVariable("mno") int mno,
			@RequestParam("size") int size, 
			Model model) {
		MemoDto memo = mservice.getMemo(mno);
		
		model.addAttribute("memo", memo);
		model.addAttribute("size", size);
		return "detail";
	}
	
	@RequestMapping("/modify")
	public String modify(@ModelAttribute MemoDto memo) {
		mservice.updateMemo(memo);
		return "redirect:/board/list/1";
	}
	
	@RequestMapping("/delete/{mno}")
	public String delete(@PathVariable("mno") int mno) {
		mservice.deleteMemo(mno);
		return "redirect:/board/list/1";
	}
}
