<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" href="./css/signup.css">
</head>
<body>
	<h1>理财记账系统</h1>
	<form action="SignupCont" method="POST">
		<h3>注册</h3>
		<a href="./login.jsp">已有账号 · 点击登录</a>
		<div>
			<input type="text" placeholder="电话/用户名" name="username" id="username"
				onblur="send()"> <span id="error">${msg1 }</span>
		</div>
		<input type="password" placeholder="密码" name="password" id="password">
		<div>
			<input type="password" placeholder="确认密码" name="idpassword" id="idpassword">
			 <span id="error1">${msg2 }</span>
		</div>
		<input class="button" type="submit" value="注册">
	</form>
</body>
<script  type="text/javascript" src="./js/signup.js"></script>
</html>