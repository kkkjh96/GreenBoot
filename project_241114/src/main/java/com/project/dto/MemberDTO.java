package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String regdate;
	
}
