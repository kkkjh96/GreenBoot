package com.ex01_241119.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Page {

	private int pageNum;
	private int currentPageNum;
	private int endPageNum;
	private int count;
	private int countNum;
	
}
