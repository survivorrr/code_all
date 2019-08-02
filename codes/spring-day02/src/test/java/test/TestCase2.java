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
	//���Թ�������ʽע��
	public void test1() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("ioc2.xml");
		A a = ac.getBean("a1", A.class);
		a.execute();
	}
	
	@Test
	//�����Զ�װ��
	public void test2() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("ioc2.xml");
		Restaurant rest = ac.getBean("rest1", Restaurant.class);
		System.out.println(rest);
	}
	
	@Test
	//���Ի�������ע��
	public void test3() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("value.xml");
		ValueBean vb = ac.getBean("vb1", ValueBean.class);
		System.out.println(vb);
	}
	
	@Test
	//�������õķ�ʽע�뼯�����͵�ֵ
	public void test4() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("value.xml");
		ValueBean vb = ac.getBean("vb2", ValueBean.class);
		System.out.println(vb);
	}
	
	@Test
	//���Զ�ȡproperties�ļ�������
	public void test5() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("value.xml");
		Properties p = ac.getBean("config", Properties.class);
		System.out.println(p);
	}
	
	@Test
	//����spring���ʽ
	public void test6() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("value.xml");
		SpelBean sp = ac.getBean("sp1",SpelBean.class);
		System.out.println(sp);
	}
	
	@Test
	//�������ɨ��
	public void test7() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		SomeBean sb = ac.getBean("sb1",SomeBean.class);
		System.out.println(sb);
	}
	
	@Test
	//����������
	public void test8() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		SomeBean sb1 = ac.getBean("sb1",SomeBean.class);
		SomeBean sb2 = ac.getBean("sb1",SomeBean.class);
		System.out.println(sb1==sb2);//false
	}
	
	@Test
	//������������
	public void test9() {
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
		SomeBean sb1 = ac.getBean("sb1",SomeBean.class);
		ac.close();
	}
	
	@Test
	//�����ӳټ���
	public void test10() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("annotation.xml");
	}
}
