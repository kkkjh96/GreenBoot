package com.ex01_241119.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SampleDto {

	private Long sno;
	private String first;
	private String last;
	private int money;
	private LocalDateTime regTime;
	
	
}
