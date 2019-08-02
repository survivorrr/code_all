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
		//tomcat启动时就会创建唯一的context，并且会调用它的方法加载web.xml中的
		//公用参数，context是全局的，任何Servlet都可以使用。
		ServletContext ctx = getServletContext();
		String size = ctx.getInitParameter("size");
		System.out.println(size);
		System.out.println("分页查询部门数据");
		//统计流量
		Integer count = (Integer) ctx.getAttribute("count");
		ctx.setAttribute("count", ++count);
		System.out.println(count);
	}

}
