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
		//1.���ղ�����û�У�
		//2.����ҵ��
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findAll();
		//ת��:��jsp��������������
		//1�������ݰ󶨵�request
		req.setAttribute("emps", list);
		//2���������ύ��jsp������������
		//ͬʱҪ��������Ĺ��߸�jsp����������ǣ�request+response
		//��ǰ��/jsp2/findEmp
		//Ŀ�꣺/jsp2/Emp_list.jsp
		req.getRequestDispatcher("Emp_list.jsp").forward(req, resp);
	}
	
}
