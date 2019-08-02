package cn.itcast.Config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtilsConfig {
	private static Connection con;
	
	static{
		try{
			InputStream in = PropertiesConfigDemo.class.getClassLoader().getResourceAsStream("database.properties");
			Properties pro = new Properties();
			pro.load(in);
			System.out.println(pro);
			String driverClass = pro.getProperty("driverClass");
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception ex){
			throw new RuntimeException("数据库连接失败");
		}
	}
	
	
	public static Connection getConnection(){
		return con;
	}
}
