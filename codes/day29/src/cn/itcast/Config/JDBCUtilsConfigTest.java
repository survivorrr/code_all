package cn.itcast.Config;

import java.sql.Connection;

public class JDBCUtilsConfigTest {
	public static void main(String[] args) {
		Connection con = JDBCUtilsConfig.getConnection();
		System.out.println(con);
	}
}
