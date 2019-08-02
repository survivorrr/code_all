package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

public class FindEmpServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, 
							HttpServletResponse resp)
							throws ServletException, IOException {
		//1.���ܲ���(û��)
		//2.����ҵ��(��ѯ)
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findAll();
		 
		//3.�����Ӧ(���)  
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<div>");
		out.println("<a href='add_emp.html'>����</a>");
		out.println("</div>");
		
		out.println("<div>");
		out.println("<table border='1' cellspacing='0' width=40%>");
		out.println("	<tr>");
		out.println("		<td>���</td>");
		out.println("		<td>����</td>");
		out.println("		<td>ְλ</td>");
		out.println("		<td>��н</td>");
		out.println("	</tr>");
		if(list != null) {
			for(Emp e:list) {
				out.println("<tr>");
				out.println("	<td>"+e.getEmpno()+"</td>");
				out.println("	<td>"+e.getEname()+"</td>");
				out.println("	<td>"+e.getJob()+"</td>");
				out.println("	<td>"+e.getSal()+"</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("</div>");
		out.close();
		
	}
	
}
