package cn.itcase.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCDemo {
	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		//1.ע�����������似��������������뵽����
		Class.forName("com.mysql.jdbc.Driver");
		
		
		//2.������ݿ����� DriverManager���о�̬����
		//url:���ݿ��ַ    jdbc:mysql://��������IP:�˿ں�/���ݿ�����
		String url = "jdbc:mysql://localhost:3306/mybase";
		String username = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url,username,password);
		//System.out.println(con);
		
		//3.������ִ��ƽ̨  ͨ�����ݿ����Ӷ���  ��ȡ��SQL����ִ���߶���
		Statement stat = con.createStatement();
		
		//4.ִ��sql���
		int row = stat.executeUpdate
				("INSERT INTO sort(sname,sprice,sdesc) VALUES('������Ʒ',50000,'����Ǽ�')");
		System.out.println(row);
		
		//5.
		
		
		//6.�ͷ���Դ
		stat.close();
		con.close();
		
		
	}
}
