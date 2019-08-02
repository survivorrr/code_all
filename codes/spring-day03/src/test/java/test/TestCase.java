package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.Bar;
import annotation.Manager;
import annotation.Restaurant;
import annotation.School;

public class TestCase {
	@Test
	//���Բ���@Autowored��set��ʽע�룩
	public void test1() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		Restaurant rest = ac.getBean("rest", Restaurant.class);
		System.out.println(rest);
	}
	
	@Test
	//����@Autowired��������ע�룩
	public void test2() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		School rest = ac.getBean("school", School.class);
		System.out.println(rest);
	}
	
	@Test
	//����@Resource(ֻ��set��ʽע��)
	public void test3() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		Bar bar = ac.getBean("bar", Bar.class);
		System.out.println(bar);
	}
	
	@Test
	//����@Value
	public void test4() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		Manager mg = ac.getBean("mg", Manager.class);
		System.out.println(mg);
	}
}
