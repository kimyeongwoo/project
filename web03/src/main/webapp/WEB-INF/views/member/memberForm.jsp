<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src=""></script>
<link href="" rel="stylesheet">
</head>
<body>
<form method="post" action="/web03/member/memberInsert">
이름 : <input name="username"><br/>
아이디 : <input name="userid"><br/>
비번 : <input name="userpw"><br/>
이메일 : <input name="email"><br/>
<input type="submit" value="확인"/>
</form>
<!-- 컨트롤러에서 model에 저장한 값이 출력됨 -->
<span style="color:red;">${message }</span>
</body>
</html>