package com.ex01_241119.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVo {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private MultipartFile file;
	private String filename;
	private String regdate;
	private String modifydate;
}
