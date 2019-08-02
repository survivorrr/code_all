package cn.tedu.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo01 {
	public static void main(String[] args) throws Exception{
		//ע������
		Class.forName("oracle.jdbc.OracleDriver");//��oracle.jdbc jar������
												//OracleDriver�����
		//���ӵ����ݿ�,orcl��oracle��ʵ����
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "system";
		String password = "123";
		//getConnection()�������Ҳ��ҳ������ӵ����ݿ⣬������ɹ��������쳣
		Connection conn = DriverManager.
				getConnection(url, user, password);
		//�������������,���conn���ö����ʵ������
		//֤�������������ṩ��connection�ӿڵ�ʵ����
		System.out.println(conn.getClass());
		//��ȡִ��ƽ̨
		Statement stat = conn.createStatement();
		//ִ��SQL
		String sql = "create table jdba_table_1 (id number(7),name varchar2(100))";
		boolean b = stat.execute(sql);
		//���ؽ���� : true ��ʾ�н����
		//			false û�н����
		//			����ʧ���׳��쳣
		System.out.println(b);
		conn.close();
	}
}
