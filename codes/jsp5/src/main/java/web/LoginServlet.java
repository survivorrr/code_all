package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
							HttpServletResponse resp) 
							throws ServletException, IOException {
		//接收账号
		String code = req.getParameter("code");
		//得到session并把获得到的值存入session
		//session 是存储在服务器上的对象，它的内部可以存储任意类型的数据
		HttpSession session = req.getSession();
		session.setAttribute("code", code);
		//session不需要担心乱码问题,就算code是中文的，在浏览器上面也不会乱码
		//响应时服务器会自动创建cookie，将session的ID通过cookie发送给浏览器
		//Cookie c = new Cookie("JSESSIONID",session.getId());
		//resp.addcookie(c);不用我们写,自动的
		
	}
	
}
