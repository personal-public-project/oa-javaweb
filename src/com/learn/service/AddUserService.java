package com.learn.service;

import com.learn.utils.JdbcTemplateUtil;

public class AddUserService {

	/**
	 * 保存数据到数据库
	 * @param userName
	 * @return
	 */
	public int addUser(String userName){
		
		return JdbcTemplateUtil.insert(userName);
	}
}
