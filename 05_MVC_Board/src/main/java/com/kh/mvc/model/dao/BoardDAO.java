package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate session;

	public int insert(Board vo) {
		return session.insert("board.insert", vo);
	}

	public List<Board> selectAll(Criteria cri) {
		return session.selectList("board.selectAll", cri);
	}
	public int getTotal() {
		return session.selectOne("board.getTotal");
	}

	public Board select(int no) {
		return session.selectOne("board.select",no);
	}

	public int update(Board vo) {
		return session.update("board.update", vo);
	}
	public int delete(int no) {
		return session.delete("board.delete",no);
	}
}