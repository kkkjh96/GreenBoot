package com.ex01_241119.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ex01_241119.dto.SampleDto;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String root() {
		return "main";
	}
	
	@GetMapping({"/list", "/list2"})
	public void list(Model model) {
		
		List<SampleDto> list = new ArrayList<>();
		for(Long i = (long) 1; i <= 20; i++) {			
			SampleDto dto = SampleDto.builder()
					.sno(i)
					.first("first...... " + i)
					.last("last......" + i)
					.money(123456789)
					.regTime(LocalDateTime.now())
					.build();
			list.add(dto);
		}
		System.out.println(list);
		model.addAttribute("list", list);
	}
	
	@RequestMapping("/exInline")
	public String exInline(RedirectAttributes rttr) {
		// redirect 상황일 때 사용한다.
		// 
		SampleDto dto = SampleDto.builder()
				.sno(4L)
				.first("first..." + 4)
				.last("last..." + 4)
				.regTime(LocalDateTime.now())
				.build();
		
		rttr.addFlashAttribute("result", "red");
		rttr.addFlashAttribute("endNum", "3");
		rttr.addFlashAttribute("dto", dto);
		
		return "redirect:/ex3";
	}
	
	@RequestMapping("/ex3")
	public void ex3() {
		
	}
	
	@RequestMapping({"/exLayout1", "/exLayout2", "/exTemplate"})
	public void exLayout1() {
		
	}

}
