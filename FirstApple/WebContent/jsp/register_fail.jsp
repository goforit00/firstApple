<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>注册失败</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<style type="text/css">
		p,body,div,h1,form{
			margin: 0 0;
			padding: 0 0;
		}
		.out{
			width: 800px;
			margin: 0 auto;
		}
		.message{
			width: 200px;
			margin: 200px auto;
		}
		</style>
	</head>

	<body>
		<div class="out">
			<p class="message">sorry,<span>${userName} </span>注册失败！</p>
			<p>失败原因:<span>${error}</span></p>
			<p><a href="register.htm" class="action">返回注册</a></p>
		</div>
	</body>
</html>