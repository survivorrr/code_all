package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	public HiServlet() {
		System.out.println("实例化HiServlet");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		System.out.println("初始化HiServlet");
	}


	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
/*		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();*/
		System.out.println("调用HiServlet处理请求");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		
		super.destroy();
		System.out.println("销毁HiServlet");
	}
	
	
	
}
