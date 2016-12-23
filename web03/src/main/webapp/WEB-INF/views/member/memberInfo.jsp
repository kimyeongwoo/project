<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	//수정버튼 모양
	$(document).ready(function(){
		$("#btnUpdate").click(function(){
			document.form1.action="/web03/member/memberUpdate";
			document.form1.submit();
		});
	});
	//삭제버튼모양
	//confirm() 확인버튼 누르면 true, 취소버튼 누르면 false
	$(document).ready(function(){
		$("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				document.form1.action="/web03/member/memberDelete";
				document.form1.submit();
			}
		});
	});
</script>
<link href="" rel="stylesheet">
</head>
<body>
<form name="form1" method="post">
이름 : <input name="username" value="${dto.username }"><br/>
아이디 : <input name="userid" value="${dto.userid }" readonly="readonly"><br/>
비번 : <input type="password" name="userpw"><br/>
이메일 : <input name="email" value="${dto.email }"><br/>
<input type="button" value="수정" id="btnUpdate" />
<input type="button" value="삭제" id="btnDelete" />
</form>
<!-- 컨트롤러에서 model에 저장한 값이 출력됨 -->
<span style="color:red;">${message }</span>
</body>
</html>