package cn.tedu.jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo02 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "update jdba_table_1 set name=? where id=?";
			PreparedStatement pstate = conn.prepareStatement(sql);
			pstate.setString(1, "Lao Wang");
			pstate.setInt(2, 1);
			int n = pstate.executeUpdate();
			System.out.println(n);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
		finally {
			DbUtils.close(conn);
		}
	}
}
