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
		 * ������super.service(req,resp)��ȥ���Ļ�����ô�������service������
		 * ��ȥ��ȡ����method��Ҫ��дdoget��dopost��ȥ���Ͳ�����д��
		 * */
		synchronized (this) {//����
			//ģ����н
			salary+=100.0;
			//�����ӳ�
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
