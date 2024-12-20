package com.project.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.dto.ContentDto;

public class ContentValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> claszz) {
		return ContentDto.class.isAssignableFrom(claszz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ContentDto dto = (ContentDto)target;
		
		String sWriter = dto.getWriter();
		if(sWriter == null || sWriter.trim().isEmpty()) {
			System.out.println("Writer is null or empty......");
			errors.rejectValue("writer", "trouble");
		}
		
		String sContent = dto.getContent();
		if(sContent == null || sContent.trim().isEmpty()) {
			System.out.println("Content is null or empty......");
			errors.rejectValue("content", "trouble");
		}
	}    
}
