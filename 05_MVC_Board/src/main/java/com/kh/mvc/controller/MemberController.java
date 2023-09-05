package com.kh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.mvc.model.service.MemberService;

@Controller
//@RequestMapping("/member/*") 공통적인것이 있을땐 이렇게 처리가능
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	@GetMapping("/member/login")
	public void login() {}
		

}
