package com.user.dao;

import java.util.List;

import com.user.entity.pri;
import com.user.entity.user;

public interface PriDao {
	List<pri> selectUserPri(user u);
}
