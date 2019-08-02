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
		
	/*	��������˺ź������ǻ������,��Ϊ�����ύ���ݵı��뷽ʽ��utf-8
		(��Ϊ��jsp���涨��ĸ�ʽ��utf-8�����������ʹ��utf-8��ʽ���뾲̬��jsp�����Ա��ύ����
		�ķ�ʽҲ��utf-8),��������Ĭ�ϵķ�ʽ��ISO-8859-1�����Ի�������룬���ʱ�����
		���һ�����������Ϳ��Խ����������⡣
*/		
		//����ҵ������
		try {
			Admin admin = service.checkLogin(adminCode, pwd);
			//��admin����󶨵�session,����session��֤
			session.setAttribute("adminCode", adminCode);
		}catch(Exception e) {
			e.printStackTrace();
			if(e instanceof ApplicationException) {
				//Ӧ���쳣��Ӧ����ȷ��ʾ�û���ȡ��ȷ�Ĳ���
				request.setAttribute("login_failed",e.getMessage());
				return "login";
			}
			//ϵͳ�쳣����ʾ�û��Ժ�����
			return "error";
		}
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex() {
		return "index";
	}
}
