package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.PriDao;
import com.user.entity.pri;
import com.user.entity.user;

@Service
public class PriService {
	@Autowired
    private 	PriDao priDao;
	public List<pri> getUserAllPri(user u){
		return priDao.selectUserPri(u);
	}
}
