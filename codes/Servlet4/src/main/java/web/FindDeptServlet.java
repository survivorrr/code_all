package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindDeptServlet extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
		//tomcat����ʱ�ͻᴴ��Ψһ��context�����һ�������ķ�������web.xml�е�
		//���ò�����context��ȫ�ֵģ��κ�Servlet������ʹ�á�
		ServletContext ctx = getServletContext();
		String size = ctx.getInitParameter("size");
		System.out.println(size);
		System.out.println("��ҳ��ѯ��������");
		//ͳ������
		Integer count = (Integer) ctx.getAttribute("count");
		ctx.setAttribute("count", ++count);
		System.out.println(count);
	}

}
