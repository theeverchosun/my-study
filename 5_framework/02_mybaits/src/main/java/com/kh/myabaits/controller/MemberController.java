package com.kh.myabaits.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.myabaits.model.dto.MemberDTO;
import com.kh.myabaits.model.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor

public class MemberController {
	
	/**
	 * 회원목록 조회
	 * URL :[GET]/member/list
	 * param: X
	 * 응답: 회원목록페이지(WEB_INF/views/member/list.jsp)포워딩
	 * 
	 * 회원추가
	 * URL:[POST]/member/insert
	 * Param:name(String), email(String), age(int)
	 * 응답: 회원목록페이지로 리다이렉트
	 * 
	 */
	private final MemberMapper mapper;
	
		
	@GetMapping("/list")
	public String memberList(Model model) {
		 List<MemberDTO> list = mapper.findAll();
		 model.addAttribute("memberList",list);
		return "member/list";
		// => /WEB-INF/views/member/list.jsp
	}
	
	@PostMapping("/insert") 
	public String memberInsert(
			//@RequestParam(value="name",defaultValue="xx") String name, String email, int age
			@ModelAttribute MemberDTO member,HttpSession session
			) {
		int result = mapper.insert(member);
		
		if(result > 0) {
			session.setAttribute("message", "회원가입에 성공했습니다");
			
		}else {
			session.setAttribute("message", "회원 가입에 실패했습니다");
		}
		
		return "redirect:/member/list";
		
	}
	@GetMapping("/insert")
	public String memberInsertForm() {
		return "member/insertForm";
	}


}