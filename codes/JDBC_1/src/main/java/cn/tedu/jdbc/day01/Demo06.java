package cn.tedu.jdbc.day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo06 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			Statement stat = conn.createStatement();
			String sql = "select * from jdba_table_1";
			ResultSet set = stat.executeQuery(sql);
			while(set.next()) {
				System.out.println(set.getInt("id")+" "+
									set.getString("name"));
			}
			set.close();//释放查询结果
			stat.close();//释放语句对象
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DbUtils.close(conn);
		}
	}
}
