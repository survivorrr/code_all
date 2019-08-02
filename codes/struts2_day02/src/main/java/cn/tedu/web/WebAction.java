package cn.tedu.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.action.BaseAction;
@Controller
@Scope("prototype")

public class WebAction extends BaseAction{
	//ע��ҵ������
	@Resource private DemoService demoService;
	private String msg;
	public String execute() {
		//��ȡ����webAction���߳�
		Thread t = Thread.currentThread();
		System.out.println("webAction:"+t);
		msg = t.getName();
		System.out.println("WebAction");
		//����������ҵ��㣬����ҵ����������
		String str = demoService.test();
		request.put("message", "I am from Spring"+","+msg+","+str);
		return SUCCESS;
	}

}
