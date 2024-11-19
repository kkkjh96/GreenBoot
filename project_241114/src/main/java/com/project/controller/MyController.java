package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dao.IBoardDao;
import com.project.dao.ICommentDao;
import com.project.dao.IMemberDao;
import com.project.dto.BoardDTO;
import com.project.dto.CommentDTO;
import com.project.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	IMemberDao idao;
	
	@Autowired
	IBoardDao bdao;
	
	@Autowired
	ICommentDao cdao;
	
	@GetMapping("/")
	public String root(Model model) {
		int limit = 5;
		int offset = 0;
		int totalCnt = bdao.getBoardCount();
		int totalPages = (int) Math.ceil((double) totalCnt / limit);
		List<BoardDTO> list1 = bdao.getListBoard(limit, offset);
		List<BoardDTO> list = bdao.getList();
		int size = list.size(); 
		int startNumber = totalCnt;
		model.addAttribute("startNumber", startNumber);
		model.addAttribute("lists", list1);
		model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", 1);
		return "main";
	}
	
	@GetMapping("/page")
	public String page(Model model, @RequestParam("page") String page) {
		System.out.println(page);
		int limit = 5;
		int temp = Integer.parseInt(page);
		int offset = (temp -1) * limit;
		int totalCnt = bdao.getBoardCount();
		int totalPages = (int) Math.ceil((double) totalCnt / limit);
		List<BoardDTO> list = bdao.getListBoard(limit, offset);
		int size = list.size();
		int startNumber = totalCnt - offset;
		model.addAttribute("startNumber", startNumber);
		model.addAttribute("lists", list);
		model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
		return "main";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/insert")
	public String insert(MemberDTO memberDTO, Model model) {
		int result = idao.insertMember(memberDTO);
		String msg = null;
		if(result != 0) {
			msg = "회원가입에 성공하셨습니다.";
		} else {
			msg = "회원가입에 실패하셨습니다.";
		}
		model.addAttribute("msg", msg);
		return "sign";
	}
	
	@GetMapping("/sign")
	public String sign() {
		return "sign";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		List<MemberDTO> list = idao.getListMember();
		String msg = null;
		for(int i = 0; i < list.size(); i++) {
			if(id.equals(list.get(i).getId()) && pw.equals(list.get(i).getPw())) {
				 session.setAttribute("userid", id);
				 msg = "반갑습니다. " + id + "님";
				 model.addAttribute("msg1", msg);
				 return "redirect:/";
			} else {
				msg = "ID 또는 PW가 일치 하지 않습니다.";
			}
		}
		model.addAttribute("msg1", msg);
		return "fail";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userid");
		return "redirect:/";
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(BoardDTO boardDTO, Model model) {
		int result = bdao.insertBoard(boardDTO);
		String msg = null;
		if(result != 0) {
			msg = "등록에 성공하셨습니다.";
		} else {
			msg = "등록에 실패하셨습니다.";
		}
		model.addAttribute("msg2", msg);
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("bno") String bno, Model model) {
		BoardDTO bdto = bdao.getBoard(bno);
		model.addAttribute("dto", bdto);
		return "detail";
	}
	
	@GetMapping("/modi")
	public String modi(@RequestParam("bno") String bno, Model model) {
		BoardDTO bdto = bdao.getBoard(bno);
		model.addAttribute("dto", bdto);
		return "modi";
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("bno") String bno, Model model) {
		int result = bdao.deleteBoard(bno);
		if (result != 0) {
			return "redirect:/";
		} else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/update")
	public String update(BoardDTO boardDTO, Model model) {
		System.out.println(boardDTO.getTitle());
		System.out.println(boardDTO.getContent());
		int result = bdao.updateBoard(boardDTO);
		System.out.println(result);
		String msg = null;
		if(result != 0) {
			msg = "수정에 성공하셨습니다.";
		} else {
			msg = "수정에 실패하셨습니다.";
		}
		model.addAttribute("msg3", msg);
		return "redirect:/";
	}
	
	@GetMapping("/commentList")
	public @ResponseBody List<CommentDTO> getCommentList(@RequestParam("bno") String bno) {
		List<CommentDTO> list = cdao.getListComment(bno);
		return list;
	}
	
	@PostMapping("/commentInsert")
	public @ResponseBody CommentDTO insertComment(CommentDTO commentDTO) {
		int result = cdao.insertComment(commentDTO);
		if(result != 0) {		
			return commentDTO;
		} else {
			return null;
		}
	}
	
	@PostMapping("/commentUpdate")
	public @ResponseBody CommentDTO commentUpdate(CommentDTO commentDTO) {
		int result = cdao.updateComment(commentDTO);
		if(result != 0) {			
			return commentDTO;
		} else {
			return null;
		}
	}
	
	@GetMapping("/commentDelete")
	public @ResponseBody String commentDelete(@RequestParam("cno") String cno) {
		int result = cdao.deleteComment(cno);
		String msg = null;
		if(result != 0) {
			msg = "삭제되었습니다.";
		} else {
			msg = "삭제에 실패했습니다.";
		}
		return msg;
	}
	
	@GetMapping("/mypage")
	public String mypage(@RequestParam("id") String id, Model model) {
		MemberDTO dto = idao.getMember(id);
		model.addAttribute("dto", dto);
		return "mypage";
	}
	
	@PostMapping("/memberModi")
	public String memberModi(MemberDTO memberDTO, Model model) {
		int result = idao.updateMember(memberDTO);
		if(result != 0) {
			model.addAttribute("dto", memberDTO);
			return "redirect:mypage?id=" + memberDTO.getId();
		} else {
			return "redirect:/";
		}
	}
}
