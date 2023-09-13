package com.ncs.test.member.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class MemberController {
	
	@RequestMapping("memberLogin")
	public String memberLogin() {
		
		return "redirect:/";
		
	}

}
