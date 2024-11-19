package com.ex01_241118.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private MultipartFile file;
	
}
