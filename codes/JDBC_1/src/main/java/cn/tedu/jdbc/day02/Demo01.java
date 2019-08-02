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
		//���ñ���Ĳ���
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		//�������ӳصĹ�����Բ���
		ds.setInitialSize(2);
		ds.setMaxActive(100);
		//ʹ�����ӳ��е����ݿ�����
		Connection conn = ds.getConnection();
		//ִ��sql
		String sql = "select 'hello' as a from dual";
		Statement stat = conn.createStatement();
		ResultSet set = stat.executeQuery(sql);
		while(set.next()) {
			System.out.println(set.getString("a"));
		}
		//�黹���ӵ����ݿ����ӳ�
		conn.close();
	}
}
