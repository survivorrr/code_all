package cn.itcase.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class JDBCupdateDemo {
	public static void main (String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "UPDATE sort SET sname=?,sprice=? WHERE sid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setObject(1, "Æû³µÃÀÈÝ");
		ps.setObject(2, 48200);
		ps.setObject(3, 7);
		
		ps.executeUpdate();
		
		con.close();
		ps.close();
		
	}
}
