package cn.tedu.jdbc.day02;
/*
 * 这个程序可以防止注入，1' or '1'='1 是不能成为万能密码的
 * */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login_Update {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("username:");
		String username = sc.nextLine();
		System.out.println("password:");
		String password = sc.nextLine();
		boolean flag = login(username,password);
		if(flag==true) {
			System.out.println("登录成功!!!"+"Hello"+" "+username);
		}else {
			System.out.println("登录失败!!!");
		}	
	}
	
	public static boolean login(String name,String pwd) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "select count(*) as c from Login_user "
					    + "where name=? and pwd=?";
			System.out.println(sql);
			PreparedStatement pstate = conn.prepareStatement(sql);
			pstate.setString(1, name);
			pstate.setString(2, pwd);
			ResultSet set = pstate.executeQuery();
			while(set.next()) {
				int n = set.getInt("c");
				return n>=1;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}finally {
			DbUtils.close(conn);
		}
		return false;
	}
}
