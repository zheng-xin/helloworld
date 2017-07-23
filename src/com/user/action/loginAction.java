package com.user.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class loginAction {
	@RequestMapping(value="/sign.do")
	public String index(){
		return "login";
	}
}
