package cn.tedu.jdbc.day02;

/*���ӳص�DbUtils�࣬��������*/

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DbUtils {
	/*ֻ�����в��о�̬��������̬�����ı�����Ϊ���ö�������������������
	�����ж�������ͻ�����߼��ϵĴ���*/
	private static String driver;
	private static String url; 
	private static String username;
	private static String password;
	private static int initSize;
	private static int maxActive;
	private static BasicDataSource ds;
	
	static {
		ds = new BasicDataSource();
		Properties pro = new Properties();
		try {
			InputStream in = DbUtils.class.getClassLoader().
					getResourceAsStream("db.properties");
			pro.load(in);
			//��ʼ������
			driver = pro.getProperty("jdbc.driver");
			url = pro.getProperty("jdbc.url");
			username = pro.getProperty("jdbc.username");
			password = pro.getProperty("jdbc.password");
			initSize = Integer.parseInt(pro.getProperty("initSize"));
			maxActive = Integer.parseInt(pro.getProperty("maxActive"));
			in.close();
			//��ʼ�����ӳ�
			ds.setDriverClassName(driver);//��������û�й������ӳص�
			//����µ�������ʹ��Class.forName();
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setInitialSize(initSize);
			ds.setMaxActive(maxActive);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	public static Connection getConnection() {		
		try {//getConnection()�����ӳ��л�ȡ���õ����ӣ�������ӳ����ˣ�
			//��ȴ�����������ӹ黹�����ȡ���õ�����
			Connection conn = ds.getConnection();
//��û�й������ӳص������ʹ�õ���
//Connection conn = DriverManager.getConnectino(url,username,password)
			return conn;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}	
	}
	
	public static void close(Connection conn) {
		if(conn!=null) {
		try {
			//���ù������ӹ黹�����ӳ�
				conn.close();
			}catch(Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
	
	public static void rollback(Connection conn) {
		if(conn!=null) {
			try {
				conn.rollback();
			}catch(Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
}
