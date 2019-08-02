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
 * 路径规范：
 * 查询员工：/findEmp.do
 * 增加员工：/addEmp.do
 * */
//默认首次访问Servlet是tomcat会实例化MainServlet
//可以改为启动tomcat时就实例化Servlet
//当浏览器发出请求时会调用service()方法
public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
		//获取请求路径
		String path = req.getServletPath();
		//根据规范处理路径
		if("/findEmp.do".equals(path)) {
			findEmp(req, resp);
		}else if("/addEmp.do".equals(path)) {
			addEmp(req,resp);
		}else {
			//该异常抛给服务器，服务器可以统一处理异常
			throw new RuntimeException("查无此页");
		}
	}
	protected void findEmp(HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
		//1.接受参数(没有)
		//2.处理业务(查询)
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findAll();
		 
		//3.输出响应(表格)  
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<div>");
		out.println("<a href='add_emp.html'>增加</a>");
		out.println("</div>");
		
		out.println("<div>");
		out.println("<table border='1' cellspacing='0' width=40%>");
		out.println("	<tr>");
		out.println("		<td>编号</td>");
		out.println("		<td>姓名</td>");
		out.println("		<td>职位</td>");
		out.println("		<td>月薪</td>");
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
		//1.接收参数
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		//2.处理业务
		Emp e = new Emp();
		e.setEname(ename);
		e.setJob(job);
		if(sal!=null&&!sal.equals("")) {//非null非空
			e.setSal(new Double(sal));
		}
		EmpDao dao = new EmpDaoImpl();
		dao.save(e);
		//3.输出响应
/*		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<p>保存成功</p>");
		out.close();*/
		//重定向到查询页面，就是建议浏览器去访问查询页面
		//当前：/EmpManager/addEmp.do
		//目标：/EmpManager/findEmp.do
		resp.sendRedirect("findEmp.do");
	}
	
}
