package cn.itcast.Config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * ����properties�����ļ�
 * IO��ȡ�ļ�����ֵ�Դ洢������
 * �Ӽ������Լ�ֵ�Է�ʽ��ȡ���ݿ��������Ϣ��������ݿ������
 * */
public class PropertiesConfigDemo {
	public static void main(String[] args) throws Exception{
		//ʹ���������
		InputStream in = PropertiesConfigDemo.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro = new Properties();
		pro.load(in);
		System.out.println(pro);
		
		//��ȡ�����еļ�ֵ��
		String driverClass = pro.getProperty("driverClass");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println(con);
	}
}
