package cn.tedu.jdbc.day01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtils {
	/*封装创建数据库连接的过程
	简化数据库连接*/
	
	static String driver;
	static String url;
	static String username;
	static String password;
	
	//读取文件中的数据库连接参数
	static {
		//初始化静态属性
		//1.利用Properties 读取配置文件
		//2.从配置文件中查找相应参数
		try {
			Properties pro = new Properties();
			InputStream in = DbUtils.class.getClassLoader().
					getResourceAsStream("db.properties");
			pro.load(in);
			//初始化   连接参数
			driver = pro.getProperty("jdbc.driver");
			url = pro.getProperty("jdbc.url");
			username = pro.getProperty("jdbc.username");
			password = pro.getProperty("jdbc.password");
		//	System.out.println(pro);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			Connection conn=DriverManager.
					getConnection(url, username, password);
			return conn;
		}catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/*
	 * 关闭数据库的连接的方法，封装复杂的关闭过程
	 * 
	 * */
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
