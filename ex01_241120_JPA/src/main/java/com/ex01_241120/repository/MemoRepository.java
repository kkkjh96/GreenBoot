package com.ex01_241120.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ex01_241120.entity.Memo;

import jakarta.transaction.Transactional;

public interface MemoRepository extends JpaRepository<Memo, Long> {
// 쿼리 메소드
	List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
	List<Memo> findByMemoText(String memoText);
	Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);
	
	void deleteMemoByMnoLessThan(Long mno);
	
// JPQL
	@Query("SELECT m FROM Memo m")
	List<Memo> getList();	// 자바 객체(엔티티)에 보냄
	
	// :이 파라미터 처리 할 때 사용하는 기호이다.
	@Query("SELECT m FROM Memo m WHERE m.mno = :mno")
	Memo getMemo(@Param("mno")Long mno);
	
	@Query("SELECT COUNT(*) FROM Memo m")
	int getCount();
	
	@Query("SELECT m FROM Memo m WHERE m.memoText LIKE :keyword")
	List<Memo> getListWithKeyword(@Param("keyword") String keyword);
	
	@Query("SELECT m FROM Memo m WHERE m.memoText LIKE CONCAT ('%', :keyword, '%')")
	List<Memo> getListWithKeyword2(@Param("keyword") String keyword);
	
	@Transactional
	@Modifying
	@Query("UPDATE Memo m SET m.memoText = :#{#param.memoTetxt}, m.writer = :#{#param.writer} WHERE m.mno = :#{#param.mno}")
	int updateMemo(@Param("param")Memo memo);
	
	@Transactional
	@Modifying
	@Query("INSERT INTO Memo m (m.memoText, m.writer) VALUES (:#{#param.memoText}, :#{#param.writer})")
	int insertMemo(@Param("param")Memo memo);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Memo m WHERE m.mno = ?1")	//?1 이라고 쓰면 뒤에 mno 가 자동으로 나온다.
	int deleteMemo(Long mno);
	
	//Native Query
	@Query(value = "SELECT * FROM tbl_memo", nativeQuery = true)
	List<Memo> getListNative();
	
}
