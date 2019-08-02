package cn.tedu.jdbc.day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.tedu.jdbc.day02.DbUtils;

public class Demo06 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into r_keywords (id,word) "
					+ "values (k_seq.nextval,?)";
			//new String[] {"id"}�Զ�������ŵ��������ַ�������
			//��Ҫ
			PreparedStatement pstate = conn.prepareStatement(
								sql, new String[] {"id"});
			pstate.setString(1, "����");
			int n = pstate.executeUpdate();
			if(n!=1) {
				throw new Exception("�������ʧ��");
			}
			//��ȡ�Զ����ɵ�ID
			ResultSet rs = pstate.getGeneratedKeys();
			int id = -1;
			while(rs.next()) {
				id = rs.getInt(1);
//				System.out.println(id);
			}
			rs.close();
			pstate.close();
			sql = "insert into r_post (id,content,k_id) "
					+ "values (p_seq.nextval,?,?)";
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, "����������������������");
			pstate.setInt(2, id);
			n = pstate.executeUpdate();
			if(n!=1) {
				throw new Exception("��������ʧ��");
			}
			System.out.println("ok");
			conn.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			DbUtils.rollback(conn);
		}finally {
			DbUtils.close(conn);
		}
	}
}
