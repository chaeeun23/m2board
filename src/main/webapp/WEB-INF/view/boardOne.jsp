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
    <div>
      <a href="${pageContext.request.contextPath}/boardList">목록</a>
   </div>
		<table border="1">
		<c:forEach var="b" items="${list}">
			<tr>
				<th>번호</th>
				<td>${b.boardNo}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${b.title}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${b.writer}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${b.createDate}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${b.views}</td>
			</tr>
			<tr>
				<th>
					<a href="${pageContext.request.contextPath}/modifyNice?boardNo=${b.boardNo}&views=${b.views}">
						좋아요
					</a>
				</th>
				<td>${b.nice}</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>