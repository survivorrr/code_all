package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;

public class TestUserService {
	UserService service;
	@Before
	public void init() {
		String[] conf = {"conf/spring-mybatis.xml","conf/spring-mvc.xml","conf/spring-transaction.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		service = ctx.getBean("userService",UserService.class);
	}
	@Test
	public void test(){
		NoteResult<User> result = service.checkLogin("李大师", "123");
		
		System.out.println(service.getClass().getName());/////////////////////////////////动态代理
		
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	/*@Test
	public void test2(){}
	@Test
	public void test3(){}*/
	
	
	@Test
	public void testSave() {
		String[] conf = {"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		User user = new User();
		user.setCn_user_id("1234");
		user.setCn_user_name("张三丰");
		user.setCn_user_nick("君宝");
		user.setCn_user_password("123456");
		dao.save(user);
		System.out.println(user);
		
	}
	
	@Test
	public void test4() {
		String name="苍老师";
		String password="123456";
		String nick="二蛋";
		NoteResult<Object> result = service.addUser(name, password, nick);
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
}
