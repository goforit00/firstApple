<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
 <meta http-equiv="Content-Type; content=text/html" charset="UTF-8" />
<html>
	<head>
		<title>注册</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/login.js"></script>
		<link rel="stylesheet" type="text/css" href="css/register.css">
		<link rel="Shortcut Icon" href="favicon.ico" />
	</head>
	<body>
		<div class="out">
			<div class="login">
				<h1>FirstApple</h1>
				<div class="con">
					<div class="tit">
						<h2>注册</h2>
						<span class="log_tit"></span>
					</div>
					<div class="login_form">
						<form action="registerResult.htm" method="post">
							<div class="username">
								<span class="phone_tit">用户名:</span>
								<span class="input_left"></span>
								<input type="text" name="username"/>
								<span class="input_right"></span>
								<span class="name_empty">用户名不能为空！</span>
								<span class="name_illegal">用户名为4-9位字母！</span>
								<div class="empty"></div>
							</div>
							<div class="phone">
								<span class="phone_tit">手机号:</span>
								<span class="input_left"></span>
								<input type="text" name="phone"/>
								<span class="input_right"></span>
								<span class="phone_empty">手机号不能为空！</span>
								<span class="phone_illegal">手机号位11位数字！</span>
								<div class="empty"></div>
							</div>
							<div class="pwd">
								<span class="pwd_tit">密码:</span>
								<span class="input_left"></span>
								<input type="password" name="password"/>
								<span class="input_right"></span>
								<span class="pwd_empty">密码不能为空！</span>
								<div class="empty"></div>
							</div>
							<div class="repeat_pwd">
								<span class="pwd_tit">确认密码:</span>
								<span class="input_left"></span>
								<input type="password" />
								<span class="input_right"></span>
								<span class="pwd_diff">密码不一致！</span>
								<div class="empty"></div>
							</div>
							<div>
								<span>性别:</span>
							</div>
							<input class="submit" type="submit" value="注册" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>