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
	//退出
	/*退出,其中是要销毁session，如果session不销毁的情况下，会有如下的现象发生：
	 *    当点击退出，会重定向到登录页面，当时不关闭浏览器，因为session在不用setMaxAge()方法设置存储位置的情况下是
	 * 默认存储在内存当中的，只要不关闭浏览器，session就没有销毁，然后我们继续的登录页面的网址上输入到toAddCost.do
	 * 或者toIndex.do，它是可以直接进去的，因为session没有销毁，过滤器判断请求是否继续的依据就是看session是否有值
	 * 有值则继续，无值则重定向到登录页面。
	 *    而使用session.invalidate()把session销毁，只要点击退出按钮，session就销毁，并退出到登录页面，尽管现在的
	 *浏览器在没有关闭的情况下，session也是销毁的了，再在网址上输入toAddCost.do或者toIndex.do都必须重新输入账号
	 *和密码才行。
	*/
	protected void logout(HttpServletRequest req,
						HttpServletResponse resp)
						throws ServletException, IOException{
		HttpSession session = req.getSession();
		session.invalidate();//销毁session
		resp.sendRedirect("/NETCTOSS/toLogin.do");
	}
	//生成验证码
	protected void createImg(HttpServletRequest req,
							HttpServletResponse resp)
							throws ServletException, IOException{
		//生成验证码及图片
		Object[] objs = ImageUtil.createImage();
		//将验证码存入session
		HttpSession session = req.getSession();
		session.setAttribute("imgcode", objs[0]);
		//将图片输出给浏览器(这张图片上包括了字符，即是一张包括了字符的图片)
		resp.setContentType("image/png");
		//获取输出流，该流由服务器自动创建，它所输出的目标就是当前访问的浏览器
		OutputStream os = resp.getOutputStream();
		BufferedImage img = (BufferedImage) objs[1];
		ImageIO.write(img, "png", os);
		os.close();
	}
	//登录(成功或失败)
	protected void login(HttpServletRequest req,
					HttpServletResponse resp)
					throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		//1.接收参数
		String adminCode = req.getParameter("adminCode");
		String password = req.getParameter("password");
		String code = req.getParameter("code");
		//检查验证码
		HttpSession session = req.getSession();
		String imgcode = (String)session.getAttribute("imgcode");
		if(code==null || !code.equalsIgnoreCase(imgcode)) {
			req.setAttribute("error", "验证码错误");
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, resp);
			return;
		}
		//2.检查账号密码
		AdminDao dao = new AdminDaoImpl();
		Admin a = dao.findByCode(adminCode);
		if(a == null) {
			//账号错误
			req.setAttribute("error", "账号错误");
			/*
			 * 这里可以用下面的代码，然后在login的jsp中用value=${adminCode}
			 * 和value=${password}代替value={param.adminCode}和value={param.password}
			 * */
/*			req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", password);*/
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, resp);
		}else if(!a.getPassword().equals(password)) {
			//密码错误
			req.setAttribute("error", "密码错误");
/*	    	req.setAttribute("adminCode", adminCode);
			req.setAttribute("password", password);*/
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, resp);
		}else {
			//将账号存入cookie，后面其他页面上要用
			Cookie c = new Cookie("adminCode",URLEncoder.encode(adminCode, "utf-8"));
			resp.addCookie(c);
			//将账号存入session，后面其他页面上要用
			session.setAttribute("adminCode", adminCode);
			//检查通过
			resp.sendRedirect("toIndex.do");
		}
	}
	
	//打开登录页
	protected void toLogin(HttpServletRequest req,
						HttpServletResponse resp)
						throws ServletException, IOException{
		req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, resp);
	}
	//打开主页
	protected void toIndex(HttpServletRequest req,
						HttpServletResponse resp)
						throws ServletException, IOException{
		req.getRequestDispatcher("WEB-INF/main/index.jsp").forward(req, resp);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	}
	//保存修改页面
	protected void updateCost(HttpServletRequest req,
			HttpServletResponse resp)
			throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		//接收参数
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String costType = req.getParameter("costType");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		//保存数据
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
		//重定向到查询页面
		resp.sendRedirect("findCost.do");
	}
	//打开资费修改页面
	protected void toUpdateCost(HttpServletRequest req,
							HttpServletResponse resp)
							throws ServletException, IOException{
		//接收参数
		String id = req.getParameter("id");
		//查询要修改的这条数据
		CostDao dao = new CostDaoImpl();
		Cost c = dao.findById(new Integer(id));
		//转发到jsp  第一步：把数据存到request;第二步:把request往jsp传
		req.setAttribute("cost",c);
		req.getRequestDispatcher("WEB-INF/cost/update.jsp").forward(req, resp);

	}
	
	//增加资费数据
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
		//保存这些数据
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
		//重定向到查询功能
		//当前:/NETCTOSS/addCost.do
		//目标:/NETCTOSS/findCost.so
		resp.sendRedirect("findCost.do");
	}
	//打开增加资费的页面
	protected void toAddCost(HttpServletRequest req,
							HttpServletResponse resp)
							throws ServletException, IOException{
		req.getRequestDispatcher("WEB-INF/cost/add.jsp").forward(req, resp);
	}
	
	
	
	//查询资费
	protected void findCost(HttpServletRequest req,
							HttpServletResponse resp)
							throws ServletException, IOException{
		//1.接收参数(没有)
		//2.处理业务(查询资费)
		CostDao dao = new CostDaoImpl();
		List<Cost> list = new ArrayList();
		list = dao.findAll();
		//3.转发到jsp
		req.setAttribute("cost_list", list);
		//当前:/NETCTOSS/findCost.do
		//目标:/NETCTOSS/WEB-INF/cost/find.jsp
		req.getRequestDispatcher("WEB-INF/cost/find.jsp").forward(req, resp);	
	}
}
