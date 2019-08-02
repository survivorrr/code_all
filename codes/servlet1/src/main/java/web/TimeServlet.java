package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
						HttpServletResponse resp) 
						throws ServletException, IOException {
		//1.ʹ��request��ȡ��������
		//1)������
			System.out.println("����ʽ��"+req.getMethod());
			System.out.println("����·����"+req.getServletPath());
			System.out.println("Э�����ͣ�"+req.getProtocol());
		// 2)��Ϣͷ(��ֵ��)
			//Enumeration���ϰ汾�ĵ����������ü��÷���Iteration����
			Enumeration<String> e = req.getHeaderNames();
			while(e.hasMoreElements()) {
				String key = e.nextElement();
				String value = req.getHeader(key);
				System.out.println(key+":"+value);
			} 		
		// 3)ʵ������  
			//������û�д��ݾ����ҵ�����ݣ�����ʵ������Ϊ�գ��Ժ�����ʾ
		//2.ʹ��response������Ӧ����
		//1)״̬��
			//�������з������Զ����
		//2)��Ϣͷ
			//��Ϣͷ�󲿷������ɷ�������䣬�����ص����ݸ�ʽ�ɳ���Աָ��������ġ�text/html��
		//3)ʵ������(����)

		//����������������͵���ҳ
		//��������ʽд���ˣ���������޷�ʶ����ֻ�����㱣������ļ���
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Date date = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
		//3)ʵ������
		//�����������ҳ����ʵ������
		//�˴�͵���ˣ�ʡ������ҳ�Ļ����ṹ���������иĽ��ķ���
		out.println("<p>"+now+"</p>");
		out.close();
	}
	
}
