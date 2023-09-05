package com.kh.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Greeting;

@RestController
public class GreetingController {

	// http://localhost:8080/api/greet --> selectList
	@GetMapping("/greet")
	public Greeting sayGreet() {
		return new Greeting(314L,"Restful API");
	}
	
	// http://localhost:8080/board/view?no=23 (x)
	// http://localhost:8080/board/23(o) 이런식으로 디자인 바꿀꺼임 --> selectOne 파라미터 형식이 아니라 경로에 포함시키는 형식
	// @PathVariable이 어노테이션을 사용하면 파라미터 형식으로 받지않음
	
	@GetMapping("/greet/{id}")
	public String showSample(@PathVariable int id) { // PathVariable : URL 경로의 일부를 파라미터로 사용할 때
		return "Hello REST API case number.." + id;
	}
	
	// http://localhost:8080/search?keyword=키워드
	
	@GetMapping("/greet2")
	public Greeting sayGreet2(String content) {
		return new Greeting(500L, content);
	}
}
