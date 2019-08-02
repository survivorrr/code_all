package cn.itcase.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;

public class JDBCloginDemo_1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Scanner sc = new Scanner(System.in);
		String u = sc.nextLine();
		String p = sc.nextLine();
		
		String sql = "SELECT * FROM users WHERE username=? AND spassword=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setObject(1, u);//1代表第一个问号
		ps.setObject(2, p);//2代表第二个问号
		
		ResultSet sr =  ps.executeQuery();
		while(sr.next()){
			System.out.println(sr.getString("username")+" "+sr.getString("spassword"));
		}
		
		con.close();
		ps.close();
		sr.close();
	}
}
