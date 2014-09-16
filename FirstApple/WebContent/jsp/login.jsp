<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
	<head>
		<title>登陆</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/login.js"></script>
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<link rel="Shortcut Icon" href="favicon.ico" />
	</head>
	<body>
		<div class="out">
			<div class="login">
				<h1>FirstApple</h1>
				<div class="con">
					<div class="tit">
						<h2>登陆</h2>
						<span class="log_tit"></span>
					</div>
					<div class="login_form">
						<form action="loginResult.htm" method="post">
							<div class="phone">
								<span class="phone_tit">手机号:</span>
								<span class="input_left"></span>
								<input type="text" name="username"/>
								<span class="input_right"></span>
								<span class="phone_empty">手机号不能为空！</span>
								<div class="empty"></div>
							</div>
							<div class="pwd">
								<span class="pwd_tit">密码:</span>
								<span class="input_left"></span>
								<input type="password" name="password" />
								<span class="input_right"></span>
								<span class="pwd_empty">密码不能为空！</span>
								<div class="empty"></div>
							</div>
							<input class="submit" type="submit" value="登陆" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>