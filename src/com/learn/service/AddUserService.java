package com.learn.service;

import com.learn.model.User;
import com.learn.utils.JdbcTemplateUtil;

public class AddUserService {

	static AddUserService addUserService = null;

	/**
	 * 单例
	 * 
	 * @return
	 */
	public static AddUserService getService() {
		if (addUserService == null) {
			addUserService = new AddUserService();
		}
		return addUserService;
	}

	/**
	 * 保存用户
	 * 
	 * @param userName
	 * @return
	 */
	public int addUser(String userName) {
		User user = new User();
		user.setUserName(userName);
		return JdbcTemplateUtil.insert(user);
	}
}
