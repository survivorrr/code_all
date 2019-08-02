package cn.itcase.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBDloginDemo {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url, user, password);
		Statement sta = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		String u = sc.nextLine();
		String p = sc.nextLine();
		
		String sql = "SELECT * FROM users WHERE username='"+u+"' AND spassword='"+p+"'";
		System.out.println(sql);
		ResultSet sr =  sta.executeQuery(sql);
		while(sr.next()){
			System.out.println(sr.getString("username")+" "+sr.getString("spassword"));
		}
		
		con.close();
		sta.close();
		sr.close();
	}
}
