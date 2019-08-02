package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		System.out.println("hello()");
		ModelAndView view = new ModelAndView("hello");
		return view;
	}
	
	@RequestMapping("/demo/hello2.do")
	public String hello2() {
		System.out.println("hello2()");
		return "hello";
	}
}
