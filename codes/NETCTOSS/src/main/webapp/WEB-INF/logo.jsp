<%@page pageEncoding="utf-8"%>
<img src="images/logo.png" alt="logo" class="left" />
<!-- 
	EL默认的取值范围是：page->request->session->application 
	EL也可以从cookie中取值，语法为：
	cookie.key.value
-->
<%--  <span>${cookie.adminCode.value }</span> --%>
<%--这个是cookie来保留数据 --%>
<span>${adminCode }</span>
<%--这个是session来保留数据，这里也可以写${sessionscope.adminCode} --%>
<a href="/NETCTOSS/logout.do">[退出]</a>
