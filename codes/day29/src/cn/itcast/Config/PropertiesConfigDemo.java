package cn.itcast.Config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * 加载properties配置文件
 * IO读取文件，键值对存储到集合
 * 从集合中以键值对方式获取数据库的连接信息，完成数据库的连接
 * */
public class PropertiesConfigDemo {
	public static void main(String[] args) throws Exception{
		//使用类加载器
		InputStream in = PropertiesConfigDemo.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro = new Properties();
		pro.load(in);
		System.out.println(pro);
		
		//获取集合中的键值对
		String driverClass = pro.getProperty("driverClass");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println(con);
	}
}
