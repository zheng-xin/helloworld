package com.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.user.dao.UserDao;
import com.user.entity.user;
import com.user.util.IdWorker;

@Service
public class UserService {
	private static Logger logger = Logger.getLogger(UserService.class);
	@Autowired
	private UserDao userdao;
	@Cacheable(value="myCache",key="#name")
	public user getUserByName(String name){
		user u=new user();
		u.setName(name);
		logger.info("logger:进来了");
		System.out.println("进来了"+name);
		return userdao.selectByUserName(u);
	}
	public void adduser(user u) {
		u.setId(IdWorker.nextId());
		userdao.add(u);
	}
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public void testTransaction() {
		update("abc");
		//update("123");
		
	}
	public void update(final String name){
		Thread thread = new Thread(){
			@Override
			public void run() {
				userdao.updatename(name);
			}
		};
		thread.start();
	}
}
