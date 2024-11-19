package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dto.ContentDto;

import jakarta.validation.Valid;

@Controller
public class MyController {

	@RequestMapping("/")
	public String root() {
		return "main";
	}
	
	@RequestMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	@RequestMapping("/create")
	public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto, BindingResult result) {
		String page = "createDonePage";
		System.out.println(contentDto);
		
//		ContentValidator validator = new ContentValidator();
//		validator.validate(contentDto, result);
		
		if(result.hasErrors()) {
			if(result.getFieldError("writer") != null) {
				System.out.println("1: " +  result.getFieldError("writer")
				.getDefaultMessage());
			}
			if(result.getFieldError("content") != null) {
				System.out.println("2: " + result.getFieldError("content")
				.getDefaultMessage());
			}
			
			page = "createPage";
		}
		
		return page;
	}
}
