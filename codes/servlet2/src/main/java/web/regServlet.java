package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class regServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//处理请求的一般步骤是:
		//1.接收参数
		String user = req.getParameter("userName");//getPaemeter()当中的参数对应
								//register.html中标签当中设置的name和value参数
		String pwd = req.getParameter("password");
		String sex = req.getParameter("sex");
		String[] interests = req.getParameterValues("interest");
		//处理请求乱码,万能的，在get/post情况下都可以使用，但一般不使用这种方式解决乱码
		//将乱码后的字符串，按照ISO还原成byte。再将byte按照UTF-8编码为字符串
/*		byte[] bs = user.getBytes("ISO8859-1");
		user = new String(bs,"utf-8");*/
		
		//2.处理业务
		//常规的注册业务应该保存这些数据，但本案例重点在于传参，因此就不存了
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests!=null) {
			for(String i : interests) {
				System.out.println(i);
			}
		}
		//3.发送响应
		resp.setContentType("text/html;charset=utf-8");
		//charset=utf-8解决发送乱码问题
		PrintWriter out = resp.getWriter();
		out.println("<p>"+"注册成功"+"</p>");
		out.close();
	}
}
