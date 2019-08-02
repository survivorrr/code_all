package cn.tedu.jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo03 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from jdba_table_1 where name like ?";
			PreparedStatement pstate = conn.prepareStatement(sql);
			pstate.setString(1, "%W%");
			ResultSet set = pstate.executeQuery();
			while(set.next()) {
				System.out.println(set.getInt("id")+" "+
									set.getString("name"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}finally {
			DbUtils.close(conn);
		}
	}
}
