<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>达内－NetCTOSS</title>
<link type="text/css" rel="stylesheet" media="all"
	href="styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="styles/global_color.css" />
</head>
<body class="index">
	<!--导航区域开始-->
	<div id="index_navi">
		<!--     include file="../menu.jsp" 外面套一个百分号加@  -->
		<!-- 	不用这个include形式是因为可以用一个标签代替这个include,为什么要代替这个include-->
		<!-- 	是因为如果jsp页面给美工去改的话美工不方便，写成如下标签形式就可以了，但是要引入上面-->
		<!-- 	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->

		<c:import url="../menu.jsp"></c:import>
	</div>
</body>
</html>
