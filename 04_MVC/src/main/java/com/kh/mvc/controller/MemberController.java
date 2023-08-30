package com.kh.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		// 서비스 - 비즈니스 로직 처리!
		// --> list 값! 데이터 바인딩 -> Model!
		//model.addAllAttributes("list",list);
		List<Member> list=service.findMember(keyword);
		if(list.size() > 0) {
			model.addAttribute("list",list);
			return "find_ok";
		}
		return "find_fail";
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	@RequestMapping("signUp")
	public String signUp(Member member) {
		service.registerMember(member);
		return "redirect:/"; // index.jsp가 views 밖에있어서
	}
	
	
	@RequestMapping("login")
	// login - 페이지 이동
	public String login() {		
		return "login";
	}
	
	@RequestMapping("signIn")
	// signIn - 비즈니스 로직 포함 : 파라미터 값 -> HttpServletRequest request
	public String signIn(Member vo, HttpSession session) { // 이렇게도됨 
		Member member = service.login(vo);
		//HttpSession session = request.getSession(); 아님 HttpServletRequest request 이렇게
		if(member!=null) {
			session.setAttribute("vo", member);
		}
		return "login_result";
	}
	
	@RequestMapping("allMember")
	// allMember - 비즈니스 로직 포함, 데이터 바인딩 - 모델
	// --> return "find_ok";
	public String allMember(Model model) {
		List<Member> list = service.showAllMember();
		model.addAttribute("list",list);
		return "find_ok";
	}
	
	@RequestMapping("logout")
	// logout - 로그아웃 기능
	public String logout(HttpSession session) {
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	@RequestMapping("update")	
	// update - 페이지 이동
	public String update() {
		return "update";
	}
	
	@RequestMapping("updateMember")
	// updateMember - 비즈니스 로직 포함 -> 파라미터 request 필요
	public String updateMember(Member vo, HttpSession session) {
		service.updateMember(vo);
		if(session.getAttribute("vo")!=null) {
			session.setAttribute("vo", vo);
		}
		return "redirect:/";
	}
}
