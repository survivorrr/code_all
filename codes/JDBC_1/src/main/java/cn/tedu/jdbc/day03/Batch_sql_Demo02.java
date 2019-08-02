package cn.tedu.jdbc.day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

import cn.tedu.jdbc.day01.DbUtils;

public class Batch_sql_Demo02 {
	public static void main(String[] args) {
		String sql = "insert into jdba_table_1 (id,name)"
				+ " values(?,?)";
		Connection conn = null;
		try {
			conn = DbUtils.getConnection();
			PreparedStatement pstate = conn.prepareStatement(sql);
			for(int i=0;i<100;i++) {
				pstate.setInt(1, i);
				pstate.setString(2, "Jerry"+i);
				//将参数添加到pstate缓存区
				pstate.addBatch();
				if((i+1)%8==0) {//这样做是为了避免内存溢出
					int[] arry = pstate.executeBatch();
					pstate.clearBatch();
					System.out.println(Arrays.toString(arry));
				}
			}

			//批量执行sql
			int[] arry = pstate.executeBatch();
			System.out.println(Arrays.toString(arry));
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DbUtils.close(conn);
		}
	}
}
