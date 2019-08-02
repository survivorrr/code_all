<%@page pageEncoding="utf-8"%>
<!-- 由于menu.jsp被其他所有的jsp共用，因此无法预估目前
	是在哪个请求中调用它，所以此处适合写绝对路径 -->
<!-- 
	这里的链接路径其实写toIndex.do也是可以的，因为虽然不知道目前的路径
	例如：当前路径为   /NETCTOSS/???????
	               目标路径 /NETCTOSS/toIndex.do   所以他们的相对路径还是toIndex.do，下面的findCost.do
	               也是同样的道理，如果到时候在配置文件web.xml中路径设置为main/???和cost/??? 那就必须写成
	               绝对路径了。
	 -->
<ul id="menu">
	<li><a href="/NETCTOSS/toIndex.do" class="index_on"></a></li>
	<li><a href="" class="role_off"></a></li>
	<li><a href="" class="admin_off"></a></li>
	<li><a href="/NETCTOSS/findCost.do" class="fee_off"></a></li>
	<li><a href="" class="account_off"></a></li>
	<li><a href="" class="service_off"></a></li>
	<li><a href="" class="bill_off"></a></li>
	<li><a href="" class="report_off"></a></li>
	<li><a href="" class="information_off"></a></li>
	<li><a href="" class="password_off"></a></li>
</ul>