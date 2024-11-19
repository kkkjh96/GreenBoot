package com.ex01_241118.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex01_241118.dto.BoardDto;
import com.ex01_241118.dto.Page;
import com.ex01_241118.service.IBoardService;

@Controller
@RequestMapping("/board")
public class PageController {
	
//	@Value("${app.page.amount}")
//	private int limit;
	
	@Autowired
	IBoardService service;
	
	@RequestMapping("/list2/{pageNum}")
	public String list2(@PathVariable("pageNum") int pageNum, 
			@RequestParam(value = "size", defaultValue = "10") int limit, Model model) {
		System.out.println("***Controller - list2 >> " + pageNum);
		int startNum = (pageNum - 1) * limit;
		int count = service.totalCount();
		int endPageNum = Math.ceilDiv(count, limit);
		int countNum = count - startNum;
		List<BoardDto> list = service.getListWithPaging(startNum, limit);
		Page page = Page.builder()
				.currentPageNum(pageNum)
				.endPageNum(endPageNum)
				.countNum(countNum)
				.build();
		model.addAttribute("size", limit);
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		return "/board/list2";
	}
}
