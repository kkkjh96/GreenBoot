package com.example.demo.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	private String username;
	private String id;
	private String pw;
	private String email;
	
//	private List<String> hobbies;
	private String[] hobbies;
}
