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
		//��ȡ�����ļ�
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		//����Seesion����
		factory = cfg.buildSessionFactory();
	}
	@Test
	public void testSession() {
	//session�ĵײ����JDBC Connection,���û���쳣����˵�����ݿ����ӳɹ�
	Session session = factory.openSession();
	System.out.println(session);
	session.close();
	}
	/*hibernate��session�ӿڣ�����������Ҫ�ģ�
	 mybatis��sqlSession������Ҫ�ģ�
	 spring��ApplicationContext������Ҫ��*/
	
	@Test
	public void testSaveObject() {
		User user = new User("100","Tom","123","OK","Cat");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);//saveִ�к�user����ת��Ϊ�־�״̬���޸ĳ־�״̬��������ԣ���Ӱ�����ݿ⣬���õ���session.updateҲ��������ݿ��е�����
		user.setNick("Andy");
		tx.commit();
		session.close();
	}
	
	@Test
	public void testUpdateObject() {
		Session session = null;
		Transaction tx = null;
		try {	//Transaction����ı�׼д��Ҫдtry..catch,���������spring��ܣ��Ͳ�����ôд�ˣ�spring��AOP������������һ���
			session = factory.openSession();//�������ݿ�
			tx = session.beginTransaction();//��������
			//���Ը��¹���
			//�ҵ����е��û���Ϣ����ѯ��
			User user = (User)session.get(User.class,"100");
			System.out.println(user);
			//�޸���Ϣ
			user.setName("jerry");
			session.update(user);
			//session.delete(user);//ɾ������
			tx.commit();//�ύ����ִ��update
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback(); //�ع�����
			}
		}finally {
			if(session!=null) {
				session.close();//�ͷ���Դ
			}
		}
	}
}
