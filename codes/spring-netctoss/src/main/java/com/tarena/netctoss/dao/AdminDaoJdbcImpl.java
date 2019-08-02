package com.tarena.netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.tarena.netctoss.entity.Admin;

/**
 * 持久层
 * @author Administrator
 *
 */
@Repository("adminDao")
public class AdminDaoJdbcImpl implements AdminDao{
	//注入连接池
	@Resource(name="ds") private DataSource ds;
	public Admin findByAdminCode(String adminCode) {
		Admin admin = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from admin_info_lzh where admin_code=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getInt("id"));
				admin.setAdminCode(rs.getString("admin_code"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setEmail(rs.getString("email"));
				admin.setEnrolldate(rs.getTimestamp("enrolldate"));
			}
		}catch(SQLException e) {
			//记日志(保留现场)
			e.printStackTrace();
			/*
			 * 看异常能否恢复，如果能够恢复则立即恢复，如果不能恢复（发生了系统异常，
			 * 比如数据库停止服务），则提示用户稍后重试
			 * */
			throw new RuntimeException(e);
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
				
			}
			
		}
		return admin;
	}
}
