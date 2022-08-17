<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>상세보기</h1>
		<table>
			<tr>
				<th>번호</th>
				<td>${board.boardNo}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.title}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.createDate}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.views}</td>
			</tr>
			<tr>
				<th>
					<a href="${pageContext.request.contextPath}/modifyNice?boardNo=${board.boardNo}">
						좋아요
					</a>
				</th>
				<td>${board.nice}</td>
			</tr>
		</table>
</body>
</html>