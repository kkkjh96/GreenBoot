package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MyService;

@RestController
public class MyController {
	
	@Autowired
	MyService service;
	
	@RequestMapping("/list")
	public List<String> root() {
		System.out.println("root......");
		List<String> list = service.list();
		return list;
	}
	
	@RequestMapping("/str/{idx}")
	public String str(@PathVariable("idx") int idx) {
		System.out.println("getString......" + idx);
		return service.getString(idx);
	}
	
}
