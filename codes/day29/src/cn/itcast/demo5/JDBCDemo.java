package cn.itcast.demo5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import cn.itcase.demo3.JDBCUtils;

public class JDBCDemo {
	public static void main(String[] args) throws Exception {
		Connection con = JDBCUtils.getConnection();
		String sql = "SELECT * FROM sort";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Sort> list = new ArrayList<Sort>();
		while(rs.next()){
			Sort s = new Sort(rs.getInt("sid"),rs.getString("sname"),
					 rs.getDouble("sprice"),rs.getString("sdesc"));
			list.add(s);
		}
		JDBCUtils.close(con, ps, rs);
		
	/*	for(Sort s : list){  //增强for遍历
			System.out.println(s);
		}*/
		
		Iterator<Sort> it = list.iterator();//迭代器遍历
		while(it.hasNext()){
			System.out.println(it.next());
		}	
	}
}
