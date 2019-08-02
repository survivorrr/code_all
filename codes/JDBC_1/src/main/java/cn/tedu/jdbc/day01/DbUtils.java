package cn.tedu.jdbc.day01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtils {
	/*��װ�������ݿ����ӵĹ���
	�����ݿ�����*/
	
	static String driver;
	static String url;
	static String username;
	static String password;
	
	//��ȡ�ļ��е����ݿ����Ӳ���
	static {
		//��ʼ����̬����
		//1.����Properties ��ȡ�����ļ�
		//2.�������ļ��в�����Ӧ����
		try {
			Properties pro = new Properties();
			InputStream in = DbUtils.class.getClassLoader().
					getResourceAsStream("db.properties");
			pro.load(in);
			//��ʼ��   ���Ӳ���
			driver = pro.getProperty("jdbc.driver");
			url = pro.getProperty("jdbc.url");
			username = pro.getProperty("jdbc.username");
			password = pro.getProperty("jdbc.password");
		//	System.out.println(pro);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			Connection conn=DriverManager.
					getConnection(url, username, password);
			return conn;
		}catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/*
	 * �ر����ݿ�����ӵķ�������װ���ӵĹرչ���
	 * 
	 * */
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
