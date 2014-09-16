<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>注册</title>
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
			<h1>欢迎来到FirstApple</h1>
			<p>注册</p>
			<form action="registerResult.htm" method="post">
				<p>用户名:<input type="text" id="username" name="userName"/></p>
				<p>性别:<input type="text" id="sex" name="sex"/></p>
				<p>密码:<input type="password" id="password" name="password"/></p>
				<p>确认密码:<input type="password" /></p>
				<p><input type="submit" /></p>
			</form>
		</div>
	</body>
</html>