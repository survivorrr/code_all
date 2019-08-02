package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.A;
import scope.MessageBean;
import scope.ScopeBean;

public class TestCase {
	@Test
	//����������
	public void test1() {
		//����spring����
		ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		//��ö���
		ScopeBean s1 = ac.getBean("s1", ScopeBean.class);
		ScopeBean s2 = ac.getBean("s1", ScopeBean.class);
		System.out.println(s1==s2);//false
	}
	
	@Test
	//������������
	public void test2() {
		//����spring����
		//ApplicationContext���ӿ�
		//AbstractApplicationContext:�ӽӿ�
		//ClassPathXmlApplicationContext��ʵ���������ӿڵľ�����
		
		//��ö���
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		MessageBean mb = ac.getBean("mb1", MessageBean.class);
		mb.sendMsg();
		
		//���ٶ���ֻ��Ҫ�ر������Ϳ�����
		ac.close();

	}
	
	//û�е���getBean()����Ҳ�ᴴ��������Ϊ����bean
	//�����ӳټ���
	@Test
	public void test3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		
	}
	
	@Test
	//����set��ʽ��ע��
	public void test4() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("ioc.xml");
		A a1 = ac.getBean("a1", A.class);
		a1.execute();
		
	}
}
