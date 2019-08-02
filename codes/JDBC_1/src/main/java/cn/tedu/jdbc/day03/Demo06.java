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
			//new String[] {"id"}自动生产序号的列名，字符串数组
			//想要
			PreparedStatement pstate = conn.prepareStatement(
								sql, new String[] {"id"});
			pstate.setString(1, "雾霾");
			int n = pstate.executeUpdate();
			if(n!=1) {
				throw new Exception("话题添加失败");
			}
			//获取自动生成的ID
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
			pstate.setString(1, "今天天气不错，晚上有雾霾");
			pstate.setInt(2, id);
			n = pstate.executeUpdate();
			if(n!=1) {
				throw new Exception("插入内容失败");
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
