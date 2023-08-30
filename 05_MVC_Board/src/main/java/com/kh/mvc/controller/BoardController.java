package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping			//@RequestMapping("/list") // = @RequestMapping
	public void list(Model model) {
		List<Board> list = service.selectAll();
				model.addAttribute("list",list);
	}
//	public ModelAndView list() {
//		List<Board> list = service.selectAll();
//		return new ModelAndView("board/list","list",list);
//	}
	
//	@PostMapping("/list")
//	@PutMapping
//	@DeleteMapping
	@RequestMapping("/insert")
	public void insert() {
		
	}
}
