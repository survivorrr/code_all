package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
						HttpServletResponse resp) 
						throws ServletException, IOException {
		//1.使用request获取请求数据
		//1)请求行
			System.out.println("请求方式："+req.getMethod());
			System.out.println("访问路径："+req.getServletPath());
			System.out.println("协议类型："+req.getProtocol());
		// 2)消息头(键值对)
			//Enumeration是老版本的迭代器，作用及用法和Iteration类似
			Enumeration<String> e = req.getHeaderNames();
			while(e.hasMoreElements()) {
				String key = e.nextElement();
				String value = req.getHeader(key);
				System.out.println(key+":"+value);
			} 		
		// 3)实体内容  
			//本案例没有传递具体的业务数据，所以实体内容为空，以后再演示
		//2.使用response发送响应数据
		//1)状态行
			//该数据有服务器自动填充
		//2)消息头
			//消息头大部分数据由服务器填充，但返回的内容格式由程序员指定如下面的“text/html”
		//3)实体内容(如下)

		//告诉浏览器给它发送的网页
		//如果这个格式写错了，浏览器会无法识别，它只能让你保存这个文件。
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Date date = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
		//3)实体内容
		//我们输出的网页就是实体内容
		//此处偷懒了，省略了网页的基本结构，将来会有改进的方案
		out.println("<p>"+now+"</p>");
		out.close();
	}
	
}
