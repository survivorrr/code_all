package cn.itcase.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCDemo_1 {
	public static void main(String[] args) throws Exception {
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.数据库连接
		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3.获得语句执行平台
		Statement stat =  con.createStatement();
		
		//4.执行sql语句
		String sql = "SELECT * FROM sort";
		ResultSet rs = stat.executeQuery(sql);
		
		//5.处理结果集
		System.out.println(rs.next());
		while(rs.next()){
			System.out.println(rs.getString("sid")+"    "+rs.getString("sname")+
					"    "+rs.getString("sprice")+"   "+rs.getString("sdesc"));
		}
		//6.释放资源
		con.close();
		stat.close();
		rs.close();
	}
}
