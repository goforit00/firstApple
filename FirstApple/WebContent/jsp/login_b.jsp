<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>登录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<style type="text/css">
		p,body,div,h1,form{
			margin: 0 0;
			padding: 0 0;
		}
		.out{
			width: 500px;
			margin: 0 auto;
			padding-top: 200px;
		}
		</style>
	</head> 

	<body>
		<div class="out">
		<h1>登录</h1>
			<form action="loginResult.htm" method="post">
				<p>用户名:<input type="text" id="username" name="userName"/></p>
				<p>密码:<input type="password" id="password" name="password"/></p>
				<p><input type="submit" id="login" name="login" /></p>
			</form>
		</div>
	</body>
</html>