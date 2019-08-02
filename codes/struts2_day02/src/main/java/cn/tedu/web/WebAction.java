package cn.tedu.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.action.BaseAction;
@Controller
@Scope("prototype")

public class WebAction extends BaseAction{
	//注入业务层组件
	@Resource private DemoService demoService;
	private String msg;
	public String execute() {
		//获取调用webAction的线程
		Thread t = Thread.currentThread();
		System.out.println("webAction:"+t);
		msg = t.getName();
		System.out.println("WebAction");
		//控制器访问业务层，调用业务层组件方法
		String str = demoService.test();
		request.put("message", "I am from Spring"+","+msg+","+str);
		return SUCCESS;
	}

}
