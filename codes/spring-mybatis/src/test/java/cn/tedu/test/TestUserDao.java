package cn.tedu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class TestUserDao {
	//测试dao接口
	@Test
	public void testCase() {
		//实例化上下文对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		//获取dao对象
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		User user = dao.findByName("demo");
		if(user!=null) {
			System.out.println("用户存在！");
		}else {
			System.out.println("用户不存在！");
		}
		System.out.println(user);
	}
}
