package com.tarena.netctoss.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.netctoss.entity.Admin;
import com.tarena.netctoss.service.ApplicationException;
import com.tarena.netctoss.service.LoginService;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService service;
	
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpSession session) {
		System.out.println("login()");
		String adminCode = request.getParameter("adminCode");
		String pwd = request.getParameter("password");
		System.out.println(adminCode+" "+pwd);
		
	/*	单独输出账号和密码是会乱码的,因为表单上提交数据的编码方式是utf-8
		(因为在jsp上面定义的格式是utf-8，这是浏览器使用utf-8方式解码静态的jsp，所以表单提交数据
		的方式也是utf-8),而服务器默认的方式是ISO-8859-1，所以会产生乱码，这个时候可以
		设计一个过滤器，就可以解决乱码的问题。
*/		
		//调用业务层服务
		try {
			Admin admin = service.checkLogin(adminCode, pwd);
			//把admin对象绑定到session,用于session验证
			session.setAttribute("adminCode", adminCode);
		}catch(Exception e) {
			e.printStackTrace();
			if(e instanceof ApplicationException) {
				//应用异常，应该明确提示用户采取正确的操作
				request.setAttribute("login_failed",e.getMessage());
				return "login";
			}
			//系统异常，提示用户稍后重试
			return "error";
		}
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex() {
		return "index";
	}
}
