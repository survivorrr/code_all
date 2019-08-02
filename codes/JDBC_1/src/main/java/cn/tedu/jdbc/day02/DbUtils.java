package cn.tedu.jdbc.day02;

/*连接池的DbUtils类，建立连接*/

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DbUtils {
	/*只有类中才有静态变量，静态变量的本意是为了让对象共享这个变量，如果在
	方法中定义变量就会出现逻辑上的错误*/
	private static String driver;
	private static String url; 
	private static String username;
	private static String password;
	private static int initSize;
	private static int maxActive;
	private static BasicDataSource ds;
	
	static {
		ds = new BasicDataSource();
		Properties pro = new Properties();
		try {
			InputStream in = DbUtils.class.getClassLoader().
					getResourceAsStream("db.properties");
			pro.load(in);
			//初始化参数
			driver = pro.getProperty("jdbc.driver");
			url = pro.getProperty("jdbc.url");
			username = pro.getProperty("jdbc.username");
			password = pro.getProperty("jdbc.password");
			initSize = Integer.parseInt(pro.getProperty("initSize"));
			maxActive = Integer.parseInt(pro.getProperty("maxActive"));
			in.close();
			//初始化连接池
			ds.setDriverClassName(driver);//驱动，在没有构建连接池的
			//情况下的驱动是使用Class.forName();
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setInitialSize(initSize);
			ds.setMaxActive(maxActive);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	public static Connection getConnection() {		
		try {//getConnection()从连接池中获取重用的连接，如果连接池满了，
			//则等待。如果有连接归还，则获取重用的连接
			Connection conn = ds.getConnection();
//在没有构建连接池的情况下使用的是
//Connection conn = DriverManager.getConnectino(url,username,password)
			return conn;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}	
	}
	
	public static void close(Connection conn) {
		if(conn!=null) {
		try {
			//将用过的连接归还给连接池
				conn.close();
			}catch(Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
	
	public static void rollback(Connection conn) {
		if(conn!=null) {
			try {
				conn.rollback();
			}catch(Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
}
