package test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Value.SpelBean;
import Value.ValueBean;
import annotation.SomeBean;
import ioc2.A;
import ioc2.Restaurant;

public class TestCase2 {
	@Test
	//测试构造器方式注入
	public void test1() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("ioc2.xml");
		A a = ac.getBean("a1", A.class);
		a.execute();
	}
	
	@Test
	//测试自动装配
	public void test2() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("ioc2.xml");
		Restaurant rest = ac.getBean("rest1", Restaurant.class);
		System.out.println(rest);
	}
	
	@Test
	//测试基本类型注入
	public void test3() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("value.xml");
		ValueBean vb = ac.getBean("vb1", ValueBean.class);
		System.out.println(vb);
	}
	
	@Test
	//测试引用的方式注入集合类型的值
	public void test4() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("value.xml");
		ValueBean vb = ac.getBean("vb2", ValueBean.class);
		System.out.println(vb);
	}
	
	@Test
	//测试读取properties文件的内容
	public void test5() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("value.xml");
		Properties p = ac.getBean("config", Properties.class);
		System.out.println(p);
	}
	
	@Test
	//测试spring表达式
	public void test6() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("value.xml");
		SpelBean sp = ac.getBean("sp1",SpelBean.class);
		System.out.println(sp);
	}
	
	@Test
	//测试组件扫描
	public void test7() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		SomeBean sb = ac.getBean("sb1",SomeBean.class);
		System.out.println(sb);
	}
	
	@Test
	//测试作用域
	public void test8() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		SomeBean sb1 = ac.getBean("sb1",SomeBean.class);
		SomeBean sb2 = ac.getBean("sb1",SomeBean.class);
		System.out.println(sb1==sb2);//false
	}
	
	@Test
	//测试生命周期
	public void test9() {
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		SomeBean sb1 = ac.getBean("sb1",SomeBean.class);
		ac.close();
	}
	
	@Test
	//测试延迟加载
	public void test10() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
	}
}
