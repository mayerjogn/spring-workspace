<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test!="${empty loginMember}">
	>

		<h2>로그인 실패..!</h2>
			<a href="index.jsp">login 페이지로 이동</a>
	</c:if>
		
		
</body>
</html>