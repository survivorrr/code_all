package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


/*
 * ���дһ��������
 * 1.����ʵ��Controller�ӿ�
 * 2.�����ڴ��������У���Ӷ��������ÿһ����������һ�����͵�����
 * 3.����������Ҫ�󣬷������Ϳ�����ModelAndView��Ҳ������String
 * 4.ʹ��@Controller�����ô���������spring��������Ҳ����˵��spring�����ļ��������øô������ˣ�
 * 5.ʹ��@RequestMapping������ǰ�˿�����(DispatcherServlet)������·���봦�����ķ���
 *   �Ķ�Ӧ��ϵ����spring�����ļ���������HandLerMapping�ˣ�
 * */
@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello()");
		return "hello";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("toLogin()");
		return "toLogin";
	}
	
	@RequestMapping("/login1.do")
	//��ȡ�������ֵ�ĵ�һ�ַ�ʽ��ͨ��request����
	public String login1(HttpServletRequest request) {
		System.out.println("login1()");
		String adminCode = request.getParameter("adminCode");
		String pwd = request.getParameter("pwd");
		System.out.println("adminCode:"+adminCode+","+"pwd:"+pwd);
		return "index";
	}
	
	@RequestMapping("/login2.do")
	//��ȡ�������ֵ�ĵڶ��ַ�ʽ��ʹ��@RequestParamע��
	public String login2(String adminCode,
			            @RequestParam("pwd") String password) {
		System.out.println("login2()");
		System.out.println("adminCode:"+adminCode+","+"pwd:"+password);
		return "index";
	}
	
	@RequestMapping("/login3.do")
	//��ȡ�������ֵ�ĵ����ַ�ʽ�������������װ��һ��javabean(���ǰ��µ�AdminParam��).
	public String login3(AdminParam ap) {
		System.out.println("login3()");
		System.out.println(ap.getAdminCode()+" "+ap.getPwd());
		return "index";
	}
	
	@RequestMapping("/login4.do")
	//��ҳ�洫ֵ�ĵ�һ�ַ�ʽ��ʹ��request
	public String login4(AdminParam ap,HttpServletRequest request) {
		System.out.println("login4()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		//�����ݰ󶨵�request 
		request.setAttribute("adminCode", adminCode);
		//springmvcĬ��ʹ��ת��
		return "index";
	}
	
	@RequestMapping("/login5.do")
	//��ҳ�洫ֵ�ĵڶ��ַ�ʽ��ʹ��ModelAndView
	public ModelAndView login5(AdminParam ap) {
		System.out.println("login5()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		Map<String,Object> data = new HashMap<String,Object>();
		//�൱��request.setAttribute("adminCode",adminCode);
		data.put("adminCode", adminCode);
		//����ModelAndView����
		ModelAndView mav = new ModelAndView("index",data); 
		return mav;
	}
	
	@RequestMapping("/login6.do")
	//��ҳ�洫ֵ�ĵ����ַ�ʽ��ʹ��ModelMap
	public String login6(AdminParam ap,ModelMap mm) {
		System.out.println("login6()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		//�൱����request.setAttribute();
		mm.addAttribute("adminCode", adminCode);
		return "index";
	}
	
	@RequestMapping("/login7.do")
	//��ҳ�洫ֵ�ĵ����ַ�ʽ��ʹ��session
	public String login7(AdminParam ap,HttpSession session) {
		System.out.println("login7()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		//�൱����request.setAttribute();
		session.setAttribute("adminCode", adminCode);
		return "index";
	}
	
	@RequestMapping("/login8.do")
	//������ֵ��Stringʱ���ض���
	public String login8() {
		System.out.println("login8()");
		return "redirect:toIndex.do";
	}
	@RequestMapping("/toIndex.do")
	public String toIndex() {
		System.out.println("toIndex()");
		return "index";
	}
	
	@RequestMapping("/login9.do")
	//������ֵ��ModelAndViewʱ���ض���
	public ModelAndView login9() {
		System.out.println("login9()");
		RedirectView rv = new RedirectView("toIndex.do");
		return new ModelAndView(rv);
	}
}
