package com.kh.api.service;

import java.util.List;

import com.kh.api.model.Phone;
import com.kh.api.model.UserInfo;

public interface PhoneService { // impl -> PhonServiceImpl

	int insert(Phone phon);
	int update(Phone phone);
	int delete(String num);
	Phone select(String num);
	List<Phone> select();
	UserInfo select(UserInfo user);
}
