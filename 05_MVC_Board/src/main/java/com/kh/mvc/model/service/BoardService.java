package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.BoardDAO;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;

@Service
public class BoardService{
	@Autowired
	private BoardDAO dao;
	
	public int insertboard(Board vo) {
		return dao.insert(vo);
	}
	public List<Board> selectAll(Criteria cri){
		return dao.selectAll(cri);
	}
	public int getTotal() {
		return dao.getTotal();
	}
	public Board selectBoard(int no){
		return dao.select(no);
	}
	public int updateBoard(Board vo) {
		return dao.update(vo);
	}
	public int deleteBoard(int no) {
		return dao.delete(no);
	}
}
