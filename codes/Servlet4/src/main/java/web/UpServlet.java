package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpServlet extends HttpServlet{
	double salary = 2000.0;
	protected void service(
			HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
		/*super.service(req, resp);
		 * 如果这个super.service(req,resp)不去掉的话，那么父类调用service方法，
		 * 就去获取方法method，要重写doget，dopost，去掉就不用重写了
		 * */
		synchronized (this) {//加锁
			//模拟涨薪
			salary+=100.0;
			//网络延迟
			try {
				Thread.sleep(8000);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println(salary);
			out.close();
		}

	}
}
