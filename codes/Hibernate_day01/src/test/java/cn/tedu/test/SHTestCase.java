package cn.tedu.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.service.UserService;

public class SHTestCase {
	ClassPathXmlApplicationContext ctx;
	SessionFactory factory;
	@Before
	public void init() {
		String[] cfg = {"spring-orm.xml"};
		ctx = new ClassPathXmlApplicationContext(cfg);
		factory = ctx.getBean("sessionFactory",SessionFactory.class);
	}
	
	@Test
	public void testSession() {
		Session session = factory.openSession();
		System.out.println(session);
		session.close();
	}
	
	@Test
	public void testHibernateTemplate() {//hibernateTemplate��������session���󷽱�ܶ࣬���ÿ�������ȵȣ�ֱ�ӽӹ����������
		//HibernateTemplate����spring�ṩ�ģ��Ƕ�session�ķ�װ���ṩ�������API
		HibernateTemplate template=ctx.getBean("hibernateTemplate",HibernateTemplate.class);
		User user = new User("400","John","123","","J");
		template.save(user);
	}
	
	@Test
	public void testUserDao() {
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		User user = new User("500","Wang","123","","");
		dao.addUser(user);
	}
	
	@Test
	public void testDeleteUser() {
		UserService service = ctx.getBean("userService",UserService.class);
		service.deleteUsers("500","400","12");
	}
	
}
