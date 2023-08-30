package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Board;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate session;

	public int insert(Board vo) {
		return session.insert("board.insert", vo);
	}

	public List<Board> selectAll() {
		return session.selectList("board.selectAll");
	}

//	public List<Board> select() {
//		return session.selectList("board.select");
//	}
//
//	public int update(Board vo) {
//		return session.update("board.update", vo);
//	}
	//public
}