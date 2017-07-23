package com.user.dao;

import com.user.entity.user;

public interface UserDao {
	user selectByPrimaryKey(user u);
	user selectByUserName(user u);
	void add(user u);
	void updatename(String name);
}
