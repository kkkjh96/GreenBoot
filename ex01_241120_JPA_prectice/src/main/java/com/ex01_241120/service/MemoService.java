package com.ex01_241120.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex01_241120.dto.MemoDto;
import com.ex01_241120.entity.Memo;
import com.ex01_241120.entity.repository.MemoRepository;

@Service
public class MemoService implements IMemoService {
	
	@Autowired
	MemoRepository memoRepository;
	
	@Override
	public void regist(MemoDto memo) {
		Memo m = Memo.builder()
				.memoText(memo.getMemoText())
				.writer(memo.getWriter())
				.build();
		memoRepository.save(m);
	}
	
	@Override
	public List<Memo> getList(){
		List<Memo> list = memoRepository.findAll();
		return list;
	}
	
	@Override
	public MemoDto getMemo(int i) {
		Memo m = new Memo();
		
		Optional<Memo> result = memoRepository.findById(i);
		if(result.isPresent()) {
			m = result.get();
		}
		MemoDto memo = MemoDto.builder()
			.mno(m.getMno())
			.memoText(m.getMemoText())
			.writer(m.getWriter())
			.build();
		return memo;
	}
	
	@Override
	public void updateMemo(MemoDto memo) {
		Memo m = Memo.builder()
				.mno(memo.getMno())
				.memoText(memo.getMemoText())
				.writer(memo.getWriter())
				.build();
		memoRepository.save(m);

	}
	
	@Override
	public void deleteMemo(int i) {
		memoRepository.deleteById(i);
	}
	
	
}
