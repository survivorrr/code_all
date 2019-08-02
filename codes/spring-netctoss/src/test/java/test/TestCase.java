package test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.netctoss.dao.AdminDao;
import com.tarena.netctoss.entity.Admin;
import com.tarena.netctoss.service.LoginService;

public class TestCase {
	private ApplicationContext ac;
	@Before
	//@Before修饰的方法会在测试方法之前执行
	public void init() {
		ac = new ClassPathXmlApplicationContext("springmvc.xml");
	}
	@Test
	//测试连接池
	public void test1() throws SQLException {
		/*ClassPathXmlApplicationContext ac = 
				new ClassPathXmlApplicationContext("springmvc.xml");*/
		DataSource ds = ac.getBean("ds", DataSource.class);
		System.out.println(ds.getConnection());
	}
	
	
	@Test
	//测试持久层
	public void test2() {
		AdminDao dao = ac.getBean("adminDao", AdminDao.class);
		Admin admin = dao.findByAdminCode("liaozhaohui");
		System.out.println(admin);
	}
	
	@Test
	//测试业务层
	public void test3() {
		LoginService service = ac.getBean("loginService", LoginService.class);
		Admin admin = service.checkLogin("caocao", "123");
		System.out.println(admin);
	}
}
