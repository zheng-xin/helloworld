package com.user.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.user.Exception.MyException;
import com.user.dao.PriDao;
import com.user.entity.pri;
import com.user.entity.user;
import com.user.service.PriService;
import com.user.service.UserService;

public class Realm  extends AuthorizingRealm{
	@Autowired
	private UserService userservice;
	@Autowired
	private PriService priService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("授权");
		String loginName = (String) arg0.fromRealm(getName()).iterator().next();
		user u2=new user();
		u2.setName(loginName);
		user u = userservice.getUserByName(u2.getName());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if(u!=null){
			List<String> pers=new ArrayList<String>();
			List<pri> pris = priService.getUserAllPri(u);
			for(pri p:pris){
				pers.add(p.getCode());
			}
			info.addStringPermissions(pers);
			return info;
		}
		else{
			return null;
		}
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("登录验证");
		UsernamePasswordToken token=(UsernamePasswordToken) arg0;
		user u=new user();
		u.setName(token.getUsername());
		user u2 = userservice.getUserByName(u.getName());
		if(u2!=null){
				return new SimpleAuthenticationInfo(u2.getName(), u2.getPwd(), getName());
		}
		else{
			return null;
		}
	}
	public  void clearCached() {  
	    PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();  
	    clearCache(principals);  
	}
}
