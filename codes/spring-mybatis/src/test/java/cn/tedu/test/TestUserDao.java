package cn.tedu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class TestUserDao {
	//����dao�ӿ�
	@Test
	public void testCase() {
		//ʵ���������Ķ���
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		//��ȡdao����
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		User user = dao.findByName("demo");
		if(user!=null) {
			System.out.println("�û����ڣ�");
		}else {
			System.out.println("�û������ڣ�");
		}
		System.out.println(user);
	}
}
