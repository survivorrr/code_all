package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/*
 * 改Servlet不负责处理具体的业务，只用来在tomcat启动时初始化数据
 * 一般WEB项目都有1-2个这样的Servlet
 * */
public class InitServlet extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		//tomcat启动时会优先创建context，然后再创建Servlet
		ServletContext ctx = getServletContext();
		//流量默认为0
		ctx.setAttribute("count", 0);
	}

}
