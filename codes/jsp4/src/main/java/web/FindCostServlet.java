package web;
/*
 * ģ���ѯ�ʷ�
 * �൱��NETCTOSS��MainServlet��findCost()����
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
		//ģ���ѯ�ʷ�
		//��ȡcookie�е��˺ţ����������
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
