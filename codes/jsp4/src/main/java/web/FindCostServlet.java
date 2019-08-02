package web;
/*
 * 模拟查询资费
 * 相当于NETCTOSS中MainServlet的findCost()方法
 * 
 * */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FindCostServlet extends HttpServlet{

	protected void service(HttpServletRequest req, 
							HttpServletResponse resp) 
							throws ServletException, IOException {
		//模拟查询资费
		//获取cookie中的账号，并将其输出
		Cookie[] cs = req.getCookies();
		if(cs!=null) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			for(Cookie c : cs) {
				out.println(c.getName()+":"+c.getValue());
				
			}
			out.close();
		}
	}	
}
