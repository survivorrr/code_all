package cn.itcase.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCexecuteQueryDemo {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "SELECT * FROM sort";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("sid")+"  "
					+rs.getString("sname")+"  "+rs.getString("sprice")+"  "+rs.getString("sdesc"));
		}
		
		rs.close();
		ps.close();
		con.close();
	}
}
