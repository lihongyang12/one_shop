package com.lhy.service;


import com.lhy.entity.User;

public interface LoginService {
	
	Boolean checkRegister(String username);

	void register(User user);

	User checkLogin(User user);

	String createToken(User u);

	User exchangeUserInfo(String token);

	User checkThirdBind(String uid);

	void bindThirdAccount(User u);

	void logout(String token);



	

}
