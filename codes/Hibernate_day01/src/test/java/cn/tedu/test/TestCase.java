package cn.tedu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.entity.User;

public class TestCase {
	SessionFactory factory;
	@Before
	public void init() {
		//读取配置文件
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		//创建Seesion工厂
		factory = cfg.buildSessionFactory();
	}
	@Test
	public void testSession() {
	//session的底层就是JDBC Connection,如果没有异常，就说明数据库连接成功
	Session session = factory.openSession();
	System.out.println(session);
	session.close();
	}
	/*hibernate的session接口（对象）是最重要的，
	 mybatis的sqlSession是最重要的，
	 spring的ApplicationContext是最重要的*/
	
	@Test
	public void testSaveObject() {
		User user = new User("100","Tom","123","OK","Cat");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);//save执行后，user对象转化为持久状态，修改持久状态对象的属性，将影响数据库，不用调用session.update也会更改数据库中的数据
		user.setNick("Andy");
		tx.commit();
		session.close();
	}
	
	@Test
	public void testUpdateObject() {
		Session session = null;
		Transaction tx = null;
		try {	//Transaction事务的标准写法要写try..catch,但是如果用spring框架，就不用这么写了，spring的AOP帮我们做了这一项功能
			session = factory.openSession();//连接数据库
			tx = session.beginTransaction();//开启事务
			//测试更新功能
			//找到现有的用户信息（查询）
			User user = (User)session.get(User.class,"100");
			System.out.println(user);
			//修改信息
			user.setName("jerry");
			session.update(user);
			//session.delete(user);//删除数据
			tx.commit();//提交事务，执行update
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback(); //回滚事务
			}
		}finally {
			if(session!=null) {
				session.close();//释放资源
			}
		}
	}
}
