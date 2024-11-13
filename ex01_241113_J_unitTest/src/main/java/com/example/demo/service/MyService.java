package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	List<String> list = new ArrayList<>();
	
	public MyService() {
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
	}

	public List<String> list(){
		System.out.println("service...list......" + list);	

		return list;
	}

	public String getString(int idx) {
		System.out.println("service...getString..." + list.get(idx));
		
		return list.get(idx);
	}
	
}
