package web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Dao.CostDao;
import Dao.CostDaoImpl;
import Utils.ImageUtil;
import entity.Admin;
import entity.Cost;

public class MainServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
						HttpServletResponse resp) 
						throws ServletException, IOException {
		String path = req.getServletPath();
		if("/findCost.do".equals(path)) {
			findCost(req,resp);
		}else if("/toAddCost.do".equals(path)){
			toAddCost(req,resp);
		}else if("/addCost.do".equals(path)){
			addCost(req,resp);
		}else if("/toUpdateCost.do".equals(path)){
			toUpdateCost(req,resp);
		}else if("/updateCost.do".equals(path)){
			updateCost(req,resp);
		}else if("/toLogin.do".equals(path)){
			toLogin(req,resp);
		}else if("/toIndex.do".equals(path)){
			toIndex(req,resp);
		}else if("/login.do".equals(path)){
			login(req,resp);
		}else if("/createImg.do".equals(path)){
			createImg(req,resp);
		}else if("/logout.do".equals(path)){
			logout(req,resp);
		}else {
			throw new RuntimeException();
		}
	}
	//�˳�
	/*�˳�,������Ҫ����session�����session�����ٵ�����£��������µ���������
	 *    ������˳������ض��򵽵�¼ҳ�棬��ʱ���ر����������Ϊsession�ڲ���setMaxAge()�������ô洢λ�õ��������
	 * Ĭ�ϴ洢���ڴ浱�еģ�ֻҪ���ر��������session��û�����٣�Ȼ�����Ǽ����ĵ�¼ҳ�����ַ�����뵽toAddCost.do
	 * ����toIndex.do�����ǿ���ֱ�ӽ�ȥ�ģ���Ϊsessionû�����٣��������ж������Ƿ���������ݾ��ǿ�session�Ƿ���ֵ
	 * ��ֵ���������ֵ���ض��򵽵�¼ҳ�档
	 *    ��ʹ��session.invalidate()��session���٣�ֻҪ����˳���ť��session�����٣����˳�����¼ҳ�棬�������ڵ�
	 *�������û�йرյ�����£�sessionҲ�����ٵ��ˣ�������ַ������toAddCost.do����toIndex.do���������������˺�
	 *��������С�
	*/
	protected void logout(HttpServletRequest req,
						HttpServletResponse resp)
						throws ServletException, IOException{
		HttpSession session = req.getSession();
		session.invalidate();//����session
		resp.sendRedirect("/NETCTOSS/toLogin.do");
	}
	//������֤��
	protected void createImg(HttpServletRequest req,
							HttpServletResponse resp)
							throws ServletException, IOException{
		//������֤�뼰ͼƬ
		Object[] objs = ImageUtil.createImage();
		//����֤�����session
		HttpSession session = req.getSession();
		session.setAttribute("imgcode", objs[0]);
		//��ͼƬ����������(����ͼƬ�ϰ������ַ�������һ�Ű������ַ���ͼƬ)
		resp.setContentType("image/png");
		//��ȡ������������ɷ������Զ����������������Ŀ����ǵ�ǰ���ʵ������
		OutputStream os = resp.getOutputStream();
		BufferedImage img = (BufferedImage) objs[1];
		ImageIO.write(img, "png", os);
		os.close();
	}
	//��¼(�ɹ���ʧ��)
	protected void login(HttpServletRequest req,
					HttpServletResponse resp)
					throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		//1.���ղ���
		String adminCode = req.getParameter("adminCode");
		String password = req.getParameter("password");
		String code = req.getParameter("code");
		//�����֤��
		HttpSession session = req.getSession();
		String imgcode = (String)session.getAttribute("imgcode");
		if(code==null || !code.equalsIgnoreCase(imgcode)) {
			req.setAttribute("error", "��֤�����");
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, resp);
			return;
		}
		//2.����˺�����
		AdminDao dao = new AdminDaoImpl();
		Admin a = dao.findByCode(adminCode);
		if(a == null) {
			//�˺Ŵ���
			req.setAttribute("error", "�˺Ŵ���");
			/*
			 * �������������Ĵ��룬Ȼ����login��jsp����value=${adminCode}
			 * ��value=${password}����value={param.adminCode}��value={param.password}
			 * */
/*			req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", password);*/
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, resp);
		}else if(!a.getPassword().equals(password)) {
			//�������
			req.setAttribute("error", "�������");
/*	    	req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", password);*/
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, resp);
		}else {
			//���˺Ŵ���cookie����������ҳ����Ҫ��
			Cookie c = new Cookie("adminCode",URLEncoder.encode(adminCode, "utf-8"));
			resp.addCookie(c);
			//���˺Ŵ���session����������ҳ����Ҫ��
			session.setAttribute("adminCode", adminCode);
			//���ͨ��
			resp.sendRedirect("toIndex.do");
		}
	}
	
	//�򿪵�¼ҳ
	protected void toLogin(HttpServletRequest req,
						HttpServletResponse resp)
						throws ServletException, IOException{
		req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, resp);
	}
	//����ҳ
	protected void toIndex(HttpServletRequest req,
						HttpServletResponse resp)
						throws ServletException, IOException{
		req.getRequestDispatcher("WEB-INF/main/index.jsp").forward(req, resp);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	}
	//�����޸�ҳ��
	protected void updateCost(HttpServletRequest req,
			HttpServletResponse resp)
			throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		//���ղ���
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String costType = req.getParameter("costType");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		//��������
		Cost c = new Cost();
		c.setCostId(new Integer(id));
		c.setName(name);
		c.setCostType(costType);
		if(baseDuration!=null && !baseDuration.equals("")) {
			c.setBaseDuration(new Integer(baseDuration));
		}
		if(baseCost!=null && !baseCost.equals("")) {
			c.setBaseCost(new Double(baseCost));
		}
		if(unitCost!=null && !unitCost.equals("")) {
			c.setUnitCost(new Double(unitCost));
		}
		c.setDescr(descr);
		CostDao dao = new CostDaoImpl();
		dao.update(c);
		//�ض��򵽲�ѯҳ��
		resp.sendRedirect("findCost.do");
	}
	//���ʷ��޸�ҳ��
	protected void toUpdateCost(HttpServletRequest req,
							HttpServletResponse resp)
							throws ServletException, IOException{
		//���ղ���
		String id = req.getParameter("id");
		//��ѯҪ�޸ĵ���������
		CostDao dao = new CostDaoImpl();
		Cost c = dao.findById(new Integer(id));
		//ת����jsp  ��һ���������ݴ浽request;�ڶ���:��request��jsp��
		req.setAttribute("cost",c);
		req.getRequestDispatcher("WEB-INF/cost/update.jsp").forward(req, resp);

	}
	
	//�����ʷ�����
	protected void addCost(HttpServletRequest req,
							HttpServletResponse resp)
							throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String costType = req.getParameter("costType");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		//������Щ����
		Cost c = new Cost();
		c.setName(name);
		c.setCostType(costType);
		if(baseDuration!=null && !baseDuration.equals("")) {
			c.setBaseDuration(new Integer(baseDuration));
		}
		if(baseCost!=null && !baseCost.equals("")) {
			c.setBaseCost(new Double(baseCost));
		}
		if(unitCost!=null && !unitCost.equals("")) {
			c.setUnitCost(new Double(unitCost));
		}
		c.setDescr(descr);
		CostDao dao = new CostDaoImpl();
		dao.save(c);
		//�ض��򵽲�ѯ����
		//��ǰ:/NETCTOSS/addCost.do
		//Ŀ��:/NETCTOSS/findCost.so
		resp.sendRedirect("findCost.do");
	}
	//�������ʷѵ�ҳ��
	protected void toAddCost(HttpServletRequest req,
							HttpServletResponse resp)
							throws ServletException, IOException{
		req.getRequestDispatcher("WEB-INF/cost/add.jsp").forward(req, resp);
	}
	
	
	
	//��ѯ�ʷ�
	protected void findCost(HttpServletRequest req,
							HttpServletResponse resp)
							throws ServletException, IOException{
		//1.���ղ���(û��)
		//2.����ҵ��(��ѯ�ʷ�)
		CostDao dao = new CostDaoImpl();
		List<Cost> list = new ArrayList();
		list = dao.findAll();
		//3.ת����jsp
		req.setAttribute("cost_list", list);
		//��ǰ:/NETCTOSS/findCost.do
		//Ŀ��:/NETCTOSS/WEB-INF/cost/find.jsp
		req.getRequestDispatcher("WEB-INF/cost/find.jsp").forward(req, resp);	
	}
}
