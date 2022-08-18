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
	<h1>회원가입</h1>
	<div>
			아이디 중복검사 <input type="text" name="ckId" id="ckId">
			<button type="button" id="ckIdBtn">확인</button>
		</div>
	<form id="form" method="post" action="${pageContext.request.contextPath}/addMember">
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
			<button type="button" id="btn">회원가입</button>
			<a href="${pageContext.request.contextPath}/login">취소</a>
	</form>
</body>
<script>
   $('#btn').click(function(){
      if($('#id').val().length < 4) {
         alert('아이디는 4자이상 입력하세요');
      } else if($('#pw').val() == '') {
         alert('패스워드를 입력하세요');
      } else {
    	  form.submit();
      }
   });
 //아이디중복검사
	$('#ckIdBtn').click(function() {
		if($('#ckId').val().length < 4) {
			alert('ID는 4자 이상 입니다.');
		} else {
			$.ajax({
				url : '/m2board/idck',
				type : 'post',
				data : {ckId : $('#ckId').val()},
				success : function(json) {
					if(json == 'y') {
						alert('사용가능한 아이디 입니다.');
						$('#id').val($('#ckId').val());
					} else {
						alert('이미 사용중인 아이디 입니다.');
						$('#id').val('');
					}
				}
			});
		}
	});
</script>
</html>