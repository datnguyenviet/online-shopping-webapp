<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Login</title>
	
	<c:set var="root" value="${pageContext.request.contextPath}" />
	<link href="${pageContent.reuqest.contextPath}/css/moss-style.css" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" type="text/css" href="mos-css/mos-style.css">
	
	
	
</head>
<body>
	<div id="header">
		<div class="inHeaderLogin"></div>
	</div>

	<div id="loginForm">
		<div class="headLoginForm">Login Administrator</div>
		<div class="fieldLogin">
			<form method="POST" action="">
				<label>Username</label><br> <input type="text" class="login"><br>
				<label>Password</label><br> <input type="password"
					class="login"><br> <input type="submit" class="button"
					value="Login">
			</form>
		</div>
</body>
</html>