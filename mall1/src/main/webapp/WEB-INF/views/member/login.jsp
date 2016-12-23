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
<script type="text/javascript">
</script>
<link href="" rel="stylesheet">
</head>
<body>
<center>
	<hr width="500" color="red" size="3"/>
	<h3>로그인</h3>
	<hr width="500" color="red" size="3"/>
	<br/><br/><br/>
	
	<table width="400" cellpadding="0" cellspacing="0">
		<form action="/mall1/member/login" method="post" name="form1">
			<tr>
				<td align="center">아이디</td>
				<td height="40" align="center"><input type="text" name="userid" id="userid" size="30"/></td>
				<td rowspan="2"><input type="submit" name="login" value="로그인" style="width:70px;height:70px;"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td height="40" align="center"><input type="password" name="userpw" id="userpw" size="30"/></td>
			</tr>
			<tr>
				<td colspan="3" height="70" align="center"><br/>
				<a href="/mall1/member/join">회원가입</a>&nbsp;&nbsp;<a href="/mall1/member/ipfind">아이디/비밀번호찾기</a>
			</tr>
		</form>
	</table>
</center>
</body>
</html>