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
		//���ղ���(�˺�����)
		String code = req.getParameter("code");
		//����˺�����
		//ת�����ض���
		//���ͨ���󣬽��˺Ŵ���cookie
		//ÿ��cookie����ֻ�ܴ�һ�����ݣ�����key��value�������ַ���
		Cookie c1 = new Cookie("code",code);
	/*	//����cookie������ʱ�䣺
	 * 1.>0 cookie�����ڿͻ��˵�Ӳ����
	 * 2.=0 cookie�������ɾ�� ���Ǵ�����ɾ����  ������ҳ�濴����
	 * 3.<0 cookie�������ڴ���
		*/
		c1.setMaxAge(-600);
		//����cookie����Ч·��
	//	c1.setPath("/jsp4");
		//��cookie���͸����������������յ��Ժ���Զ�����
		resp.addCookie(c1);
		
		//�ٴ���һ��cookie��������
		Cookie c2 = new Cookie("city",URLEncoder.encode("����","utf-8"));
		resp.addCookie(c2);
	}
	
}
