package com.ex01_241120.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex01_241120.dto.UserDto;
import com.ex01_241120.entity.Memo;
import com.ex01_241120.entity.User;
import com.ex01_241120.entity.repository.MemoRepository;
import com.ex01_241120.entity.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	MemoRepository memoRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void regist(UserDto user) {
		User u = User.builder()
				.id(user.getId())
				.pw(user.getPw())
				.name(user.getName())
				.build();
		userRepository.save(u);
	}
	
	@Override
	public UserDto getUser(String id, String pw) {
		User u = new User();
		
		Optional<User> result =  userRepository.findByIdAndPw(id, pw);
		if(result.isPresent()) {
			u = result.get();
		}
		
		UserDto user = UserDto.builder()
				.id(u.getId())
				.pw(u.getPw())
				.name(u.getName())
				.build();
		
		return user;
	}
	
	@Override
	public List<Memo> getUserList(String id){
		
		List<Memo> list = memoRepository.findByWriter(id);
		
		return list;
	}
	
}
