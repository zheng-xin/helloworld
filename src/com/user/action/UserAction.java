package com.user.action;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mysql.jdbc.StringUtils;
import com.user.entity.user;
import com.user.service.UserService;
import com.user.validate.ValidateUtil;
@Controller
@RequestMapping(value="/system/user")
public class UserAction {
	@Autowired
	private UserService userservice;
	@RequestMapping(value="/login.do")
	public String loggin(user u,ModelMap mp,HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		if(StringUtils.isNullOrEmpty(u.getName())){
			mp.put("msg", "请输入用户名！");
			return "login";
		}
		if(StringUtils.isNullOrEmpty(u.getPwd())){
			mp.put("msg", "请输入密码");
			return "login";
		}
		if(StringUtils.isNullOrEmpty(u.getValidateCode())){
			mp.put("msg", "请输入验证码");
			return "login";
		}
		if(!u.getValidateCode().equals(subject.getSession().getAttribute("validateCode"))){
			mp.put("msg", "验证码错误");
			return "login";
		}
		user u2 = userservice.getUserByName(u.getName());
		if(!u2.getPwd().equals(u.getPwd())){
			mp.put("msg","用户名或密码错误！");
			return "login";
		}
		if(u2!=null){
			UsernamePasswordToken token=new UsernamePasswordToken(u2.getName(), u.getPwd());
			token.setRememberMe(true);
			try{
				subject.login(token);
				HttpSession session = request.getSession();
				session.setAttribute("user",u2);
				subject.getSession().setAttribute("name","zhengxinnb");
			}
			catch (AuthenticationException e) {
				e.printStackTrace();
				System.out.println("认证失败");
				mp.put("msg", "认证失败");
				return "login";
			}
			
		}
		return "index";
	}
//	@RequiresPermissions("user:add")
	@RequestMapping(value="/add.do")
	public String add(user u,ModelMap mp,HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		Boolean isPermittedAll=subject.isPermittedAll("user:creat", "user:add");
		System.out.println(isPermittedAll);
		if(subject.isPermitted("user:create")){
			return "success";
		}
		else{
			return "login";
		}
	}
	@RequestMapping(value="/logout.do")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
	 @RequestMapping(value = "/validateCode.do")
	    public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 Subject subject = SecurityUtils.getSubject();   
		 response.setHeader("Cache-Control", "no-cache");
	        String verifyCode = ValidateUtil.generateTextCode(ValidateUtil.TYPE_NUM_UPPER, 4, null);
	        subject.getSession().setAttribute("validateCode", verifyCode);
	        response.setContentType("image/jpeg");
	        BufferedImage bim = ValidateUtil.generateImageCode(verifyCode, 90, 30, 0, true, null, null, null);
	        ImageIO.write(bim, "JPEG", response.getOutputStream());
	    }
	 
	 @RequestMapping(value="/transaction.do")
		public void testTransaction(){
		 userservice.testTransaction();
		}
}
