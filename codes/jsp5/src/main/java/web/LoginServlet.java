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
		//�����˺�
		String code = req.getParameter("code");
		//�õ�session���ѻ�õ���ֵ����session
		//session �Ǵ洢�ڷ������ϵĶ��������ڲ����Դ洢�������͵�����
		HttpSession session = req.getSession();
		session.setAttribute("code", code);
		//session����Ҫ������������,����code�����ĵģ������������Ҳ��������
		//��Ӧʱ���������Զ�����cookie����session��IDͨ��cookie���͸������
		//Cookie c = new Cookie("JSESSIONID",session.getId());
		//resp.addcookie(c);��������д,�Զ���
		
	}
	
}
