package cn.tedu.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtils_Test {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			Statement stat = conn.createStatement();
			String sql = "select 'Hello' as a from dual";
			ResultSet set = stat.executeQuery(sql);
			while(set.next()) {
				System.out.println(set.getString("a"));
			}
			set.close();
			stat.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}finally {
			DbUtils.close(conn);
		}
	}
}
