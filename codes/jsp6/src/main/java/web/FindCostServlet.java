package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCostServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
							HttpServletResponse resp) 
							throws ServletException, IOException {
		System.out.println("��ѯ�ʷ�...");
/*		
 *      ����һ��req.setAttribute("c", "hello")���ܴ���
		MyListener��attributeAdded()����
*/
		req.setAttribute("c", "hello");

	}
	
}
