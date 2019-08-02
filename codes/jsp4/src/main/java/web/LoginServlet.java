package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	protected void service(HttpServletRequest req,
							HttpServletResponse resp)
							throws ServletException, IOException {
		//接收参数(账号密码)
		String code = req.getParameter("code");
		//检查账号密码
		//转发或重定向
		//检查通过后，将账号存入cookie
		//每个cookie对象只能存一条数据，包括key和value，都是字符串
		Cookie c1 = new Cookie("code",code);
	/*	//声明cookie的生存时间：
	 * 1.>0 cookie保存在客户端的硬盘上
	 * 2.=0 cookie被浏览器删除 就是创建就删除了  在其他页面看不到
	 * 3.<0 cookie保存在内存里
		*/
		c1.setMaxAge(-600);
		//设置cookie的有效路径
	//	c1.setPath("/jsp4");
		//将cookie发送给浏览器，浏览器接收到以后会自动保存
		resp.addCookie(c1);
		
		//再创建一个cookie，存中文
		Cookie c2 = new Cookie("city",URLEncoder.encode("北京","utf-8"));
		resp.addCookie(c2);
	}
	
}
