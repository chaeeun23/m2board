<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<h3>${loginMember.memberId}님 환영합니다</h3>
<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
<a href="${pageContext.request.contextPath}/boardList">글목록</a>
</div>
</body>
</html>