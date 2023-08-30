package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.BoardDAO;
import com.kh.mvc.model.vo.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	public int insertboard(Board vo) {
		return dao.insert(vo);
	}
	public List<Board> selectAll(){
		return dao.selectAll();
	}
//	public List<Board> selectBoard(){
//		return dao.select();
//	}
//	public int updateBoard(Board vo) {
//		return dao.update(vo);
//	}
	//public
}
