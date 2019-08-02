package cn.tedu.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class Demo01 {
	public static void main(String[] args) throws Exception{
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username="system";
		String password="123";
		BasicDataSource ds = new BasicDataSource();
		//设置必须的参数
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		//设置连接池的管理策略参数
		ds.setInitialSize(2);
		ds.setMaxActive(100);
		//使用连接池中的数据库连接
		Connection conn = ds.getConnection();
		//执行sql
		String sql = "select 'hello' as a from dual";
		Statement stat = conn.createStatement();
		ResultSet set = stat.executeQuery(sql);
		while(set.next()) {
			System.out.println(set.getString("a"));
		}
		//归还连接到数据库连接池
		conn.close();
	}
}
