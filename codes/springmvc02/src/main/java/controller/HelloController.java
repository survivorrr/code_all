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
 * 如何写一个处理器
 * 1.不用实现Controller接口
 * 2.可以在处理器类中，添加多个方法，每一个方法处理一种类型的请求
 * 3.方法名不做要求，返回类型可以是ModelAndView，也可以是String
 * 4.使用@Controller，将该处理器纳入spring容器管理（也就是说，spring配置文件不用配置该处理器了）
 * 5.使用@RequestMapping，告诉前端控制器(DispatcherServlet)，请求路径与处理器的方法
 *   的对应关系。（spring配置文件不用配置HandLerMapping了）
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
	//读取请求参数值的第一种方式：通过request对象
	public String login1(HttpServletRequest request) {
		System.out.println("login1()");
		String adminCode = request.getParameter("adminCode");
		String pwd = request.getParameter("pwd");
		System.out.println("adminCode:"+adminCode+","+"pwd:"+pwd);
		return "index";
	}
	
	@RequestMapping("/login2.do")
	//读取请求参数值的第二种方式：使用@RequestParam注解
	public String login2(String adminCode,
			            @RequestParam("pwd") String password) {
		System.out.println("login2()");
		System.out.println("adminCode:"+adminCode+","+"pwd:"+password);
		return "index";
	}
	
	@RequestMapping("/login3.do")
	//读取请求参数值的第三种方式：将请求参数封装成一个javabean(就是包下的AdminParam类).
	public String login3(AdminParam ap) {
		System.out.println("login3()");
		System.out.println(ap.getAdminCode()+" "+ap.getPwd());
		return "index";
	}
	
	@RequestMapping("/login4.do")
	//向页面传值的第一种方式：使用request
	public String login4(AdminParam ap,HttpServletRequest request) {
		System.out.println("login4()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		//将数据绑定到request 
		request.setAttribute("adminCode", adminCode);
		//springmvc默认使用转发
		return "index";
	}
	
	@RequestMapping("/login5.do")
	//向页面传值的第二种方式：使用ModelAndView
	public ModelAndView login5(AdminParam ap) {
		System.out.println("login5()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		Map<String,Object> data = new HashMap<String,Object>();
		//相当于request.setAttribute("adminCode",adminCode);
		data.put("adminCode", adminCode);
		//构造ModelAndView对象
		ModelAndView mav = new ModelAndView("index",data); 
		return mav;
	}
	
	@RequestMapping("/login6.do")
	//向页面传值的第三种方式：使用ModelMap
	public String login6(AdminParam ap,ModelMap mm) {
		System.out.println("login6()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		//相当于与request.setAttribute();
		mm.addAttribute("adminCode", adminCode);
		return "index";
	}
	
	@RequestMapping("/login7.do")
	//向页面传值的第四种方式：使用session
	public String login7(AdminParam ap,HttpSession session) {
		System.out.println("login7()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		//相当于与request.setAttribute();
		session.setAttribute("adminCode", adminCode);
		return "index";
	}
	
	@RequestMapping("/login8.do")
	//当返回值是String时，重定向
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
	//当返回值是ModelAndView时，重定向
	public ModelAndView login9() {
		System.out.println("login9()");
		RedirectView rv = new RedirectView("toIndex.do");
		return new ModelAndView(rv);
	}
}
