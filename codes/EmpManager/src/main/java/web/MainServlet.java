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

/*
 * ·���淶��
 * ��ѯԱ����/findEmp.do
 * ����Ա����/addEmp.do
 * */
//Ĭ���״η���Servlet��tomcat��ʵ����MainServlet
//���Ը�Ϊ����tomcatʱ��ʵ����Servlet
//���������������ʱ�����service()����
public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
		//��ȡ����·��
		String path = req.getServletPath();
		//���ݹ淶����·��
		if("/findEmp.do".equals(path)) {
			findEmp(req, resp);
		}else if("/addEmp.do".equals(path)) {
			addEmp(req,resp);
		}else {
			//���쳣�׸�������������������ͳһ�����쳣
			throw new RuntimeException("���޴�ҳ");
		}
	}
	protected void findEmp(HttpServletRequest req, 
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
	
	protected void addEmp(HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
		//1.���ղ���
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		//2.����ҵ��
		Emp e = new Emp();
		e.setEname(ename);
		e.setJob(job);
		if(sal!=null&&!sal.equals("")) {//��null�ǿ�
			e.setSal(new Double(sal));
		}
		EmpDao dao = new EmpDaoImpl();
		dao.save(e);
		//3.�����Ӧ
/*		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<p>����ɹ�</p>");
		out.close();*/
		//�ض��򵽲�ѯҳ�棬���ǽ��������ȥ���ʲ�ѯҳ��
		//��ǰ��/EmpManager/addEmp.do
		//Ŀ�꣺/EmpManager/findEmp.do
		resp.sendRedirect("findEmp.do");
	}
	
}
