<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/login" method="post">
		아이디 : <input type="text" name="username"/><br> <!-- login은 반드시 name을 username으로 지정해줘야 인식함 -->
		비밀번호 : <input type="password" name="password"/><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>