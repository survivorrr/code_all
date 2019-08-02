package cn.tedu.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo02 {
	public static void main(String[] args) throws Exception{
		//注册驱动
		Class.forName("oracle.jdbc.OracleDriver");
		//建立链接
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username="system";
		String password="123";
		Connection conn = DriverManager.getConnection(url, username, password);
		//获得执行平台
		Statement state = conn.createStatement();
		//执行sql语句，executeUpdate执行DML语句
	//	String dml = "insert into jdba_table_1 (id,name) values(1,'Tom')";
	//	int n = state.executeUpdate(dml);
	//	System.out.println(n);
		//查询
		String dql = "select * from jdba_table_1";
		ResultSet rs = state.executeQuery(dql);
		while(rs.next()) {
			System.out.println(rs.getInt("id")+rs.getString("name"));
		}
		
		//关闭资源
		conn.close();

	}
}
