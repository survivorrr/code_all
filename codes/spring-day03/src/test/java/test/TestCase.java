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
	//测试采用@Autowored（set方式注入）
	public void test1() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		Restaurant rest = ac.getBean("rest", Restaurant.class);
		System.out.println(rest);
	}
	
	@Test
	//测试@Autowired（构造器注入）
	public void test2() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		School rest = ac.getBean("school", School.class);
		System.out.println(rest);
	}
	
	@Test
	//测试@Resource(只能set方式注入)
	public void test3() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		Bar bar = ac.getBean("bar", Bar.class);
		System.out.println(bar);
	}
	
	@Test
	//测试@Value
	public void test4() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		Manager mg = ac.getBean("mg", Manager.class);
		System.out.println(mg);
	}
}
