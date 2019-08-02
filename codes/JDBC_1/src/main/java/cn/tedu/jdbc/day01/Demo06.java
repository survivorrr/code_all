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
			set.close();//�ͷŲ�ѯ���
			stat.close();//�ͷ�������
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DbUtils.close(conn);
		}
	}
}
