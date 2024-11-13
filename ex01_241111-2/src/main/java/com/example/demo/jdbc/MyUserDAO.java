package com.example.demo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyUserDAO {
	
	@Autowired
	private JdbcTemplate jt;

	public List<MyUserDTO> list(){
		String query = "SELECT * FROM myuser";

		List<MyUserDTO> list = jt.query(	
			query, 
			new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class)
		);
		
		return list;
	}
	public MyUserDTO getUser(String id){
		String query = "SELECT * FROM myuser WHERE id = ?";
		
		MyUserDTO dto = jt.queryForObject(	
				query, 
				new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class),
				//Interger.class, int 타입이면 이렇게 사용한다.
				id
				);
		
		return dto;
	}
	
	public int insert(MyUserDTO dto) {
		String query = "INSERT INTO myuser VALUES(?, ?)";
		
		int result = jt.update(
				query,
				dto.getId(), dto.getName()
				);
		return result;
	}
	public int delete(String id) {
		String query = "DELETE FROM myuser WHERE id = ?";
		
		int result = jt.update(
				query,
				id
				);
		return result;
	}
	public int modify(String newid, String oldid) {
		String query = "UPDATE myuser SET id = ? WHERE id = ?";
		
		int result = jt.update(
				query,
				newid,
				oldid
				);
		return result;
	}
}
