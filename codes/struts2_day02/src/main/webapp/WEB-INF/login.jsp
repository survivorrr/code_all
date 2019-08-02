<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
</head>
<body>
	<h1>登录</h1>
	<h2>${error}</h2>
	<form action="check.action"> 
		<div>
			<label>用户名：</label>
			<input type="text" name="username"/>
		</div>
		<div>
			<label>密码：</label>
			<input type="password" name="password"/>
		</div>
		<div>
			<input type="submit" value="登录"/>
		</div>
	</form>
</body>
</html>