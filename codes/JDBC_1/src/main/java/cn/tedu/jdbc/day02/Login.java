package cn.tedu.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 注入演示
 * create table Login_user(
 * 	id number(6),
 * 	name varchar2(100),
 * 	pwd varchar2(100)
 * );
 * 
 * insert into Login_user (id,name,pwd) values(1,'Tom','123');
 * ....
 * */
public class Login {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("username:");
		String name = sc.nextLine();
		System.out.println("password:");
		String pwd = sc.nextLine();
		boolean flag = login(name,pwd);
		if(flag == false) {
			System.out.println("登录失败!!!");
		}else{
			System.out.println("登录成功!!!");
		}
	}
	
	public static boolean login(String name,String pwd) {
		
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			//在转义字符\'和分号"之间不能有空格，有空格就形式在name和pwd字符串加了空格
			//例如    where name=' zhangsan ' and pwd=' 123 ',实际中不能有空格的
			String sql = "select * from Login_user "
				 + "where name=\'"+name+"\' and pwd=\'"+pwd+"\'";
			/*这条sql语句就定死了为一行一列，所以在下面的int m = rsmd.getColumnCount();
			 * m的值等于1，在rs.getInt()括号只能填1，因为sql语句决定了只查询表中某行某列的
			 * 一个具体的结果
			 * */

			System.out.println(sql);
/*			//没有\'(转义单引号)其实也可以用
 * 			String sql = "select count(*) as c from Login_user "
					+ "where name= '"+name+"' and pwd= '"+pwd+"' ";*/
			Statement stat = conn.createStatement();
			ResultSet set = stat.executeQuery(sql);
			ResultSetMetaData rsmd = set.getMetaData();
			int m = rsmd.getColumnCount();
			System.out.println(m);
			for(int i=1;i<=m;i++) {
				System.out.println(rsmd.getColumnName(i));
			}
			while(set.next()) {
				System.out.println(set.getString(2));
/*				
				System.out.println(set.getString(2));
				没有第二列,根据sql语句选出来只有一列，因为sql语句查询的结果只是一个某行某列的
				的一个具体的结果，所以只有set.getInt(1)有值
*/
				int n = set.getInt("id");
				return n>=1;
			}	
			return false;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}finally {
			DbUtils.close(conn);
		}
	}
}
