package com.lhy.dao;

import java.util.List;

import com.lhy.entity.User;

public interface LoginDao {

	List<User> getList();

	int checkRegister(String username);

	void register(User user);

	User checkLogin(User user);

	User checkThirdBind(String uid);

	void bindThirdAccount(User u);

}
