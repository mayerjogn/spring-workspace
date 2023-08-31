package com.kh.mvc.model.vo;

import lombok.Getter;
import lombok.Setter;

// page와 amount 값을 같이 전달하는 용도
@Setter
@Getter
public class Criteria {

	private int page; // 페이지 번호
	private int amount; // 한 페이지 당 몇개의 데이터를 보여줄지
	
	public Criteria() {
		this(1, 10); // 기본값 지정해서 처리 1페이지에 10개 게시글
	}
	
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
}