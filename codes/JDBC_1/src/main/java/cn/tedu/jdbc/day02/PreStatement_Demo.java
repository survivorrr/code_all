package cn.tedu.jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreStatement_Demo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			//创建带参数的SQL语句
			String sql = "insert into jdba_table_1 (id,name) values(?,?)";
			//将sql发送到数据库，创建执行计划，返回值pstate就代表执行计划
			PreparedStatement pstate = conn.prepareStatement(sql);
			//替换执行计划中的参数，2个参数，按照序号发送参数
			pstate.setInt(1, 8);
			pstate.setString(2, "John");
			//执行“执行计划”
			int n = pstate.executeUpdate();
			System.out.println(n);
/*			//不能直接用pstate直接执行另外一种sql语句，因为现在是执行计划有变。这个和以前的直接执行一条sql
 * 			//语句不一样，这个PreparedStatement和Statement创建的对象不同，不要搞混了。
 * 			String sql1 = "select * from jdba_table_1";
			ResultSet set = pstate.executeQuery(sql1);
			while(set.next()) {
				System.out.println(set.getInt("id")+" "+
			                   set.getString("name"));
			}*/
			//再次重复使用执行计划
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
