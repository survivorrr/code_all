package cn.tedu.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo01 {
	public static void main(String[] args) throws Exception{
		//注册驱动
		Class.forName("oracle.jdbc.OracleDriver");//到oracle.jdbc jar包中找
												//OracleDriver这个类
		//链接到数据库,orcl是oracle的实例名
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "system";
		String password = "123";
		//getConnection()方法查找并且尝试链接到数据库，如果不成功将出现异常
		Connection conn = DriverManager.
				getConnection(url, user, password);
		//下面这个输出语句,输出conn引用对象的实际类型
		//证明：驱动程序提供了connection接口的实现类
		System.out.println(conn.getClass());
		//获取执行平台
		Statement stat = conn.createStatement();
		//执行SQL
		String sql = "create table jdba_table_1 (id number(7),name varchar2(100))";
		boolean b = stat.execute(sql);
		//返回结果集 : true 表示有结果集
		//			false 没有结果集
		//			创建失败抛出异常
		System.out.println(b);
		conn.close();
	}
}
