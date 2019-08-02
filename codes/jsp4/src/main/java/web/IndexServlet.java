package web;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
/*
 * 模拟打开主页
 * 相当于MainServlet中的toIndex()方法
 * */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet{

	protected void service(HttpServletRequest req, 
							HttpServletResponse resp) 
							throws ServletException, IOException {
		//向流浪器输出主页的内容(略)
		//获取cookie
		Cookie[] cs = req.getCookies();
		//将他们也输出给浏览器
		if(cs != null) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			for(Cookie c:cs) {
				out.println(c.getName()+":"+URLDecoder.
						decode(c.getValue(), "utf-8"));
			}
			out.close();
		}
	}
	

}
