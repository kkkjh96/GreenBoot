package com.ex01_241120.service;

import java.util.List;

import com.ex01_241120.dto.UserDto;
import com.ex01_241120.entity.Memo;

public interface IUserService {
	
	public void regist(UserDto user);
	public UserDto getUser(String id, String pw);
	public List<Memo> getUserList(String id);
	
}
