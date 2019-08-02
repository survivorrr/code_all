package cn.itcase.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCDemo {
	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		//1.注册驱动，反射技术，将驱动类加入到内容
		Class.forName("com.mysql.jdbc.Driver");
		
		
		//2.获得数据库连接 DriverManager类中静态方法
		//url:数据库地址    jdbc:mysql://连接主机IP:端口号/数据库名字
		String url = "jdbc:mysql://localhost:3306/mybase";
		String username = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url,username,password);
		//System.out.println(con);
		
		//3.获得语句执行平台  通过数据库连接对象  获取到SQL语句的执行者对象
		Statement stat = con.createStatement();
		
		//4.执行sql语句
		int row = stat.executeUpdate
				("INSERT INTO sort(sname,sprice,sdesc) VALUES('汽车用品',50000,'疯狂涨价')");
		System.out.println(row);
		
		//5.
		
		
		//6.释放资源
		stat.close();
		con.close();
		
		
	}
}
