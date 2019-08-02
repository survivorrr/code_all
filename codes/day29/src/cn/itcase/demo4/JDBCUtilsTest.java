package cn.itcase.demo4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.itcase.demo3.JDBCUtils;



public class JDBCUtilsTest {
	public static void main(String[] args) throws Exception{
		Connection con = JDBCUtils.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM sort");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("sname"));
		}
		
		JDBCUtils.close(con, ps, rs);
	}
}
