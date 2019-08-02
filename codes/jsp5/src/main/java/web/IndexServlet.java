package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
							HttpServletResponse resp) 
							throws ServletException, IOException {
		//���ڱ������������������SID���������͸��ݴ�SID�ҵ����Ǹ��ɵ�session
		//���Դ��ж�ȡ֮ǰ�������
		HttpSession session = req.getSession();
		String code = (String)session.getAttribute("code");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(code);
		out.close();
	}
	
}
