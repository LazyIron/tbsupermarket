package com.ucaitop.tb.service;

import com.ucaitop.tb.domain.User;

public interface UserService {
	/**
	 * 用户注册服务层接口 传入要注册的用户
	*/
	void addUser(User user);
	
	/**
	用户修改密码接口 传入要修改的用户以及密码
	*/
	boolean changePsw(String telephone,String password);
	
	/**
	 * 用户登录方法
	 */
	User findUser(String telephone,String password);
}
