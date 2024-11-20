package com.ex01_241120.service;

import java.util.List;

import com.ex01_241120.dto.MemoDto;
import com.ex01_241120.entity.Memo;

public interface IMemoService {

	public void regist(MemoDto memo);
	public List<Memo> getList();
	public MemoDto getMemo(int i);
	public void updateMemo(MemoDto memo);
	public void deleteMemo(int i);
	
}
