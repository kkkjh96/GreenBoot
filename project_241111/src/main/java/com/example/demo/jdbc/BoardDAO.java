package com.example.demo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jt;
	
	public List<BoardDTO> list(){
		String query = "SELECT * FROM board_241111 ORDER BY bno DESC";
		
		List<BoardDTO> list = jt.query(
				query,
				new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class)
		);
		return list;
	}
	
	public int reg(BoardDTO dto) {
		int result = 0;
		String query = "INSERT INTO board_241111 VALUES (NULL, ?, ?, ?)";
		
		result = jt.update(
				query,
				dto.getTitle(), dto.getContent(), dto.getWriter()
				);
		return result;
	}
	
	public BoardDTO getBoard(String bno) {
		String query = "SELECT * FROM board_241111 WHERE bno = ?";
		BoardDTO dto = new BoardDTO();
		try {		
			dto = jt.queryForObject(
					query, 
					new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class),
					bno
					);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int delete(String bno) {
		int result = 0;
		
		String query = "DELETE FROM board_241111 WHERE bno = ?";
		
		result = jt.update(
				query,
				bno
				);
		return result;
	}
}
