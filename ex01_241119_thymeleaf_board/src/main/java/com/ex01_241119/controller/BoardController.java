package com.ex01_241119.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ex01_241119.dto.BoardDto;
import com.ex01_241119.service.IBoardService;
import com.ex01_241119.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Value("${app.page.amount}")
	private int limit;
	
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	
	@Autowired
	IBoardService service;
	
	@RequestMapping("/registForm")
	public String registForm(Model model) {
		System.out.println("board...registForm...");
		model.addAttribute("board", new BoardVo());
		return "/board/registForm";
	}
	
	@RequestMapping("/regist")
	public String regist(@ModelAttribute BoardVo vo) {
		System.out.println("board...regist..." + vo);
		
		//파일 쓰기
		MultipartFile file = vo.getFile();
		String filename = file.getOriginalFilename();
		
		File uploadFile = new File(uploadPath + filename);
		System.out.println("File name: " + filename);
		System.out.println("Upload path: " + uploadPath);
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		//파일 이름을 BoardDto에 저장하기
//		BoardDto dto = new BoardDto();
//		dto.setTitle(vo.getTitle());
//		dto.setContent(vo.getContent());
//		dto.setWriter(vo.getWriter());
//		dto.setFilename(filename);
		BoardDto dto = BoardDto.builder()
				.title(vo.getTitle())
				.content(vo.getContent())
				.writer(vo.getWriter())
				.filename(filename)
				.build();
		
		int result = service.regist(dto);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		//DB에서 board테이블의 데이터들을 가져온다.
		List<BoardDto> blist = service.getList();
		System.out.println("controller..." + blist);
		//가져온 데이터를 view(list.jsp)에 전달한다. => Model
		model.addAttribute("blist", blist);
		return "/board/list";
	}
	
//	@RequestMapping("/list2/{pageNum}")
//	public String list2(@PathVariable("pageNum") int pageNum, Model model) {
//		System.out.println("***Controller - list2 >> " + pageNum);
//		
//		int startNum = (pageNum - 1) * limit;
//		int count = service.totalCount();
//		int endPageNum = Math.ceilDiv(count, limit);
//		int countNum = count - startNum;
//		List<BoardDto> list = service.getListWithPaging(startNum, limit);
//		model.addAttribute("count", countNum);
//		model.addAttribute("currentPageNum", pageNum);
//		model.addAttribute("endPageNum", endPageNum);
//		model.addAttribute("list", list);
//		return "/board/list2";
//	}
	
	@RequestMapping("/detail/{bno}")
	public String detail(@PathVariable("bno") int bno, Model model) {
		BoardDto board = service.getBoard(bno);
		BoardVo vo = BoardVo.builder()
				.bno(board.getBno())
				.title(board.getTitle())
				.content(board.getContent())
				.writer(board.getWriter())
				.filename(board.getFilename())
				.regdate(board.getRegdate())
				.modifydate(board.getModifydate())
				.build();
		model.addAttribute("board", vo);
		return "/board/detail";
	}
	
	@RequestMapping("/modify")
	public String modify(@ModelAttribute BoardVo vo) {
		System.out.println("board...modify..." + vo);
		
		//파일 쓰기
		MultipartFile file = vo.getFile();
		String filename = file.getOriginalFilename();
		
		File uploadFile = new File(uploadPath + filename);

		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		//파일 이름을 BoardDto에 저장하기
		BoardDto dto = new BoardDto();
		dto.setBno(vo.getBno());
		dto.setTitle(vo.getTitle());
		dto.setContent(vo.getContent());
		dto.setWriter(vo.getWriter());
		dto.setFilename(filename);
		
		int result = service.modify(dto);
		System.out.println("service controller" + result);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/delete/{bno}")
	public String delete(@PathVariable("bno") int bno, Model model) {
		System.out.println("delete..." + bno);
		int result = service.remove(bno);
		return "redirect:/board/list";
	}
	
}
