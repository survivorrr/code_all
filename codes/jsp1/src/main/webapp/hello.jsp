<%@page pageEncoding="utf-8"%>
<!-- 1.先写标签 -->
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>第一个jsp</title>
	</head>
	<body>
		<!-- 2.3 JSP声明(方法) -->
		<%!
			public double bb(double b){
				return b*100;
		}
		%>
		<ul> <!-- 无序列表 -->
			<!-- 2.在写Java -->
			<!-- 2.1 JSP脚本 -->
			<%
				for(int i=0;i<10;i++){
			%><!-- 2.2 JSP表达式(用来输出) -->
			<li><%=bb(Math.random())%></li>
			<%
				}
			%>
		</ul>
		<!-- 引入一个jsp，相当于将此jsp的内容复制到此处 -->
		<%@include file="time.jsp" %>
	</body>
</html>