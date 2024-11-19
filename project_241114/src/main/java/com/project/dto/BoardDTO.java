package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

	private String bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	
}