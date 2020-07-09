<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet" href="./css/login.css">
</head>
<body>
	<h1>理财记账系统</h1>
	<div class="main">
		<div class="top">
			<img src="./images/201.png" alt="">
		</div>
		<div class="bottom">
			<form action="LoginCont">
				<span>账 号</span> <input class="inputid" type="text" placeholder="请输入账号" name="username"> <br>
				<div>
					<span>密 码</span> <input class="inputpwd" type="password" placeholder="请输入密码" name="password">
					<label id="msg" style="line-height: 10px;
						 display: block;
						 font-size:15px;
						 color: red;
						 margin-left:-60px;
						 padding: -10px 0;">${msg }</label>
				</div>
				<input class="submit" type="submit" value="登录"> <a href="./signup.jsp">没有账号 · 点击注册</a>
			</form>
		</div>
	</div>
</body>
</html>