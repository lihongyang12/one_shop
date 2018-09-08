package com.lhy.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhy.dao.LoginDao;
import com.lhy.entity.User;
import com.lhy.service.LoginService;
import com.lhy.utils.RedisUtil;

@Service(version="1.0.0")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Value("${server.port}")
	private Integer port;

	@Autowired
	private LoginDao loginDao;

	@Override
	public Boolean checkRegister(String username) {
		int i = loginDao.checkRegister(username);
		return i==0;
	}

	@Override
	public void register(User user) {
		loginDao.register(user);
	}

	@Override
	public User checkLogin(User user) {
		return loginDao.checkLogin(user);
	}

	@Override
	public String createToken(User u) {
		String token = UUID.randomUUID().toString();
		token = token.replaceAll("-", "");
		
		//jackson fastjson gson
		
		String json = null;
		try {
			json = mapper.writeValueAsString(u);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error";
		}
		//以token为key，用户信息为valu存入redis
		redisUtil.set(token, json,30*60);
		
		return token;
	}

	@Override
	public User exchangeUserInfo(String token) {
		String json = (String) redisUtil.get(token);
		User u = null;
		try {
			u = mapper.readValue(json, User.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User checkThirdBind(String uid) {
		return loginDao.checkThirdBind(uid);
	}

	@Override
	public void bindThirdAccount(User u) {
		loginDao.bindThirdAccount(u);
	}

	@Override
	public void logout(String token) {
		redisUtil.del(token);	
	}

}
