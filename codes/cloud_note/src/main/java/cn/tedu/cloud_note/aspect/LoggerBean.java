package cn.tedu.cloud_note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerBean {
	@Before("within(cn.tedu.cloud_note.controller..*)")
	public void logController() {
		System.out.println("AOP����ע��");
	}
	
	@Before("within(cn.tedu.cloud_note.service..*)")
	public void logService() {
		System.out.println("AOPע��Service");
	}
}
