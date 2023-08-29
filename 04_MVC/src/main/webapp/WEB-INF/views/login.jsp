<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="signIn" method="post">
		아이디 : <input type="text" name="id" required><br>
		비밀번호 : <input	type="password" name="pwd" required><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>