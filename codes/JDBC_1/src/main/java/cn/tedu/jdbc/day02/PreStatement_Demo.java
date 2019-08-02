package cn.tedu.jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreStatement_Demo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			//������������SQL���
			String sql = "insert into jdba_table_1 (id,name) values(?,?)";
			//��sql���͵����ݿ⣬����ִ�мƻ�������ֵpstate�ʹ���ִ�мƻ�
			PreparedStatement pstate = conn.prepareStatement(sql);
			//�滻ִ�мƻ��еĲ�����2��������������ŷ��Ͳ���
			pstate.setInt(1, 8);
			pstate.setString(2, "John");
			//ִ�С�ִ�мƻ���
			int n = pstate.executeUpdate();
			System.out.println(n);
/*			//����ֱ����pstateֱ��ִ������һ��sql��䣬��Ϊ������ִ�мƻ��б䡣�������ǰ��ֱ��ִ��һ��sql
 * 			//��䲻һ�������PreparedStatement��Statement�����Ķ���ͬ����Ҫ����ˡ�
 * 			String sql1 = "select * from jdba_table_1";
			ResultSet set = pstate.executeQuery(sql1);
			while(set.next()) {
				System.out.println(set.getInt("id")+" "+
			                   set.getString("name"));
			}*/
			//�ٴ��ظ�ʹ��ִ�мƻ�
			pstate.setInt(1, 100);
			pstate.setString(2, "Wang");
			n = pstate.executeUpdate();
			System.out.println(n);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}finally {
			DbUtils.close(conn);
		}
	}
}
