<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ok</title>
</head>
<body>
	<h1>Value Stack演示</h1>
	
	<div>
		<p>读取内容(content)的区域：</p>
		<p>使用el表达式读取valueStack中的数据:
			${message}
			${map.name}
			${map.age}
			${map['user.address']}
			${map['001']}
		</p>
		
		<p>读取内容(content)的区域：</p>
		<p>使用OGNL读取valueStack中的数据:
			<s:property value="message"/>
			<s:property value="map.name"/>
			<s:property value="map.age"/>
			<s:property value="map['user.address']"/>
			<s:property value="map['001']"/>
		</p>
		
		
		
		
		<p>访问上下文环境(Context)区域:</p>
		<p>request:</p>
		<s:property value="#request"/>
		<p>request的内容:</p>
		<s:property value="#request['struts.actionMapping']"/>
		
		<s:debug/>
	</div>
</body>
</html>