package com.learn.service;

import com.learn.utils.JdbcTemplateUtil;

public class AddUserService {

	/**
	 * �������ݵ����ݿ�
	 * @param userName
	 * @return
	 */
	public int addUser(String userName){
		
		return JdbcTemplateUtil.insert(userName);
	}
}
