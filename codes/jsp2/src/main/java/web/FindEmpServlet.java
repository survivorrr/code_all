package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

public class FindEmpServlet extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws 
			ServletException, IOException {
		//1.接收参数（没有）
		//2.处理业务
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findAll();
		//转发:让jsp继续完成这个请求
		//1）将数据绑定到request
		req.setAttribute("emps", list);
		//2）将请求提交给jsp让它继续处理
		//同时要求处理请求的工具给jsp，这个工具是：request+response
		//当前：/jsp2/findEmp
		//目标：/jsp2/Emp_list.jsp
		req.getRequestDispatcher("Emp_list.jsp").forward(req, resp);
	}
	
}
