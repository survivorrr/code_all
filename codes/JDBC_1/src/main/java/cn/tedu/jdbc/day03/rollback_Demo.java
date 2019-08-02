package cn.tedu.jdbc.day03;

import java.sql.Connection;
import java.sql.Statement;

import cn.tedu.jdbc.day02.DbUtils;

public class rollback_Demo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			//ȡ���Զ��ύ�������ֶ��ύ
			conn.setAutoCommit(false);
			String sql = "update a_account set balance=balance+1000 where id=1";
			Statement state = conn.createStatement();
			state.executeUpdate(sql);
			//�ֶ��ύsql���
			conn.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			/*throw new RuntimeException();*/
			DbUtils.rollback(conn);
		}finally {
			DbUtils.close(conn);
		}
	}
}
