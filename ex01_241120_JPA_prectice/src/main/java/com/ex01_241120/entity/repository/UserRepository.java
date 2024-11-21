package com.ex01_241120.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ex01_241120.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	 Optional<User> findByIdAndPw(String id, String pw);
	 
	 @Query("SELECT COUNT(*) FROM User u WHERE u.id = ?1 AND u.pw = ?2")
	 int loginCheck(String id, String pw);
	 
	 @Query("SELECT u.id, u.name, m.memoText FROM User u INNER JOIN Memo m ON u.id = m.writer")
	 List<Object[]> getUserJoinMemo();
}
