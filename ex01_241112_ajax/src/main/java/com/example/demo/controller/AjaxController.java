package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MemberDTO;

@RestController
public class AjaxController {
	
	@PostMapping("/regist1")
	public String regist1(MemberDTO memberDTO) {
		System.out.println("regist1......" + memberDTO);
		String msg = "";
		if(memberDTO != null) {
			msg = "good!!";
		} else {
			msg = "bad...T.T";
		}
		return msg;
	}
	
	@PostMapping("/regist2")
	public String regist2(@RequestBody MemberDTO memberDTO) {
		System.out.println("regist2......" + memberDTO);
		String msg = "";
		if(memberDTO != null) {
			msg = "good!!";
		} else {
			msg = "bad...T.T";
		}
		return msg;
	}
}
