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
		//���������һ�㲽����:
		//1.���ղ���
		String user = req.getParameter("userName");//getPaemeter()���еĲ�����Ӧ
								//register.html�б�ǩ�������õ�name��value����
		String pwd = req.getParameter("password");
		String sex = req.getParameter("sex");
		String[] interests = req.getParameterValues("interest");
		//������������,���ܵģ���get/post����¶�����ʹ�ã���һ�㲻ʹ�����ַ�ʽ�������
		//���������ַ���������ISO��ԭ��byte���ٽ�byte����UTF-8����Ϊ�ַ���
/*		byte[] bs = user.getBytes("ISO8859-1");
		user = new String(bs,"utf-8");*/
		
		//2.����ҵ��
		//�����ע��ҵ��Ӧ�ñ�����Щ���ݣ����������ص����ڴ��Σ���˾Ͳ�����
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests!=null) {
			for(String i : interests) {
				System.out.println(i);
			}
		}
		//3.������Ӧ
		resp.setContentType("text/html;charset=utf-8");
		//charset=utf-8���������������
		PrintWriter out = resp.getWriter();
		out.println("<p>"+"ע��ɹ�"+"</p>");
		out.close();
	}
}
