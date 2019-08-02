package web;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
/*
 * ģ�����ҳ
 * �൱��MainServlet�е�toIndex()����
 * */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet{

	protected void service(HttpServletRequest req, 
							HttpServletResponse resp) 
							throws ServletException, IOException {
		//�������������ҳ������(��)
		//��ȡcookie
		Cookie[] cs = req.getCookies();
		//������Ҳ����������
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
