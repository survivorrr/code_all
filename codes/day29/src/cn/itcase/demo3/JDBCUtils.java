package cn.itcase.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {
	private JDBCUtils(){}
	private static Connection con;
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mybase";
			String user = "root";
			String password = "123";
			con = DriverManager.getConnection(url, user, password);
		}catch(Exception ex){
			throw new RuntimeException(ex+"数据库连接失败");
		}
	}
	
	public static Connection getConnection(){
		return con;
	}
	
	public static void close(Connection con,Statement ps,ResultSet rs){
		try{
			rs.close();
			ps.close();
			con.close();
		}catch(Exception ex){}

	}
}
