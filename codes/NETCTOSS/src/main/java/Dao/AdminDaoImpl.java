package Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Utils.DbUtils;
import entity.Admin;

public class AdminDaoImpl implements AdminDao, Serializable{
	public Admin findByCode(String code) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from admin_info_lzh where admin_code=?";
			PreparedStatement pstate = conn.prepareStatement(sql);
			pstate.setString(1, code);
			ResultSet rs = pstate.executeQuery();
			if(rs.next()) {
				Admin a = new Admin();	
				a.setAdminId(rs.getInt("id"));
				a.setAdminCode(rs.getString("admin_code"));
				a.setPassword(rs.getString("password"));
				a.setName(rs.getString("name"));
				a.setTelephone(rs.getString("telephone"));
				a.setEmail(rs.getString("email"));
				a.setEnrolldate(rs.getTimestamp("enrolldate"));
				return a;
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询管理员失败",e);
		}finally {
			DbUtils.close(conn);
		}
		return null;
	}
	
	public static void main(String[] args) {
		AdminDao dao = new AdminDaoImpl();
		Admin a = dao.findByCode("廖朝晖");
		System.out.println(a.getAdminCode());
		System.out.println(a.getAdminId());
		System.out.println(a.getTelephone());
	}
}
