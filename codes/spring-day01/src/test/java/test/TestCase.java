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
	//测试作用域
	public void test1() {
		//启动spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		//获得对象
		ScopeBean s1 = ac.getBean("s1", ScopeBean.class);
		ScopeBean s2 = ac.getBean("s1", ScopeBean.class);
		System.out.println(s1==s2);//false
	}
	
	@Test
	//测试生命周期
	public void test2() {
		//启动spring容器
		//ApplicationContext：接口
		//AbstractApplicationContext:子接口
		//ClassPathXmlApplicationContext：实现了上述接口的具体类
		
		//获得对象
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		MessageBean mb = ac.getBean("mb1", MessageBean.class);
		mb.sendMsg();
		
		//销毁对象只需要关闭容器就可以了
		ac.close();

	}
	
	//没有调用getBean()方法也会创建作用域为单例bean
	//测试延迟加载
	@Test
	public void test3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		
	}
	
	@Test
	//测试set方式的注入
	public void test4() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("ioc.xml");
		A a1 = ac.getBean("a1", A.class);
		a1.execute();
		
	}
}
