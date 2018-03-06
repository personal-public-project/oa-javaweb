package com.learn.model;

/**
 * 实体类 （与数据库表对应）
 * 
 * @author fengli
 *
 */
public class User {

	private Integer id;

	private String userName;
	
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
