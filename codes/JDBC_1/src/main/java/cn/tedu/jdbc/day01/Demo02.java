package cn.tedu.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo02 {
	public static void main(String[] args) throws Exception{
		//ע������
		Class.forName("oracle.jdbc.OracleDriver");
		//��������
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username="system";
		String password="123";
		Connection conn = DriverManager.getConnection(url, username, password);
		//���ִ��ƽ̨
		Statement state = conn.createStatement();
		//ִ��sql��䣬executeUpdateִ��DML���
	//	String dml = "insert into jdba_table_1 (id,name) values(1,'Tom')";
	//	int n = state.executeUpdate(dml);
	//	System.out.println(n);
		//��ѯ
		String dql = "select * from jdba_table_1";
		ResultSet rs = state.executeQuery(dql);
		while(rs.next()) {
			System.out.println(rs.getInt("id")+rs.getString("name"));
		}
		
		//�ر���Դ
		conn.close();

	}
}
