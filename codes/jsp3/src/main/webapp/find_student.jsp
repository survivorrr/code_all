<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>EL和JSTL</title>
	</head>
	<body>
		<h1>JSTL</h1>
		<!-- 1.if -->
		<p>	
			<c:if test="${stu.sex=='M' }">男</c:if>
			<c:if test="${stu.sex=='F' }">女</c:if>
		</p>
		<!-- 2.choose -->
		<p>
			<c:choose>
				<c:when test="${stu.sex=='M' }">男</c:when>
				<c:otherwise>女</c:otherwise>
			</c:choose>
		</p>
		<!-- 3.forEach -->
		<!-- items：声明遍历的数据 
			var：给每次循环所获得的数据命名-->
		<p>
			<c:forEach items="${stu.interests }" var="i">${i }</c:forEach>
		</p>
		<h1>EL</h1>
		<!-- 1.获取Bean属性 -->
		<!-- ${stu.name }等价于request.getAttribute("stu").getName() -->
		<p>姓名:${stu.name }</p>
		<!-- ${stu["age"] }等价于request.getAttribute("stu").getAge() -->
		<p>年龄:${stu["age"] }</p>
		<!-- ${stu.course.id }等价于request.getAttribute("stu").course.getId() -->
		<p>课程:${stu.course.id }</p>
		<!-- EL的取值范围:
			1.EL默认从如下4个对象中依次取值
				page,request,session,application
				这4个隐含对象是EL默认的取值范围
			2.也可以指定取值范围
				requestScope.stu.name
				sessionScope.stu.name 
			3.设计默认取值的目的，是为了开发者不用经常写范围，是为了简化EL表达式-->
		<p>性别:${sessionScope.stu.sex }</p> <!--session中没有sex，所以无值  -->
		<p>性别:${requestScope.stu.sex }</p>
		<!-- 2.支持运算 -->
		<p>年龄+5:${stu.age+5 }</p>
		<p>20-30之间:${stu.age>20 && stu.age<30 }</p>
		<p>判空:${empty stu }</p>
		<!-- 3.获取请求参数 -->
		<p>参数:${param.user }</p>
	</body>
</html>
