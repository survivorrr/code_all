package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.Student;

public class FindStudentServlet extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws 
			ServletException, IOException {
		//1.��ȡ�������޲�����
		//2.����ҵ�񣨲飩
		Student stu = new Student();
		stu.setName("zhangsan");
		stu.setAge(23);
		stu.setSex("M");
		String[] interests = {"��","��","��","��"};
		stu.setInterests(interests);
		Course c = new Course();
		c.setId(1);
		c.setName("Java");
		c.setDays(80);
		stu.setCourse(c);
		//3.ת�����ض���ת��
		//��ǰ:/jsp3/findStudent
		//Ŀ��:/jsp3/find_student.jsp
		req.setAttribute("stu", stu);
		req.getRequestDispatcher("find_student.jsp").forward(req, resp);
	}
	
}
