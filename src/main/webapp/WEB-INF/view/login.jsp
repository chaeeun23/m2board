<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>로그인</h1>
	<form id="form" method="post" action="${pageContext.request.contextPath}/login">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" id="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" id="pw"></td>
				</tr>
			</table>
			<button type="button" id="btn">로그인</button>
			<a href="${pageContext.request.contextPath}/addMember">회원가입</a>
	</form>
</body>
<script>
   $('#btn').click(function(){
      if($('#id').val() == '') {
         alert('고객 아이디를 입력하세요');
      } else if($('#pw').val() == '') {
         alert('고객 패스워드를 입력하세요');
      } else {
    	  form.submit();
      }
   });
  
</script>
</html>