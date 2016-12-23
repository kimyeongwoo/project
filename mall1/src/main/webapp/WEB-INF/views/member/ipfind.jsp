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
<center>
	<hr width="500" color="red" size="3"/>
	<h3>ID / PW 찾기</h3>
	<hr width="500" color="red" size="3"/>
	<br/><br/><br/>
	
	<table width="400" cellpadding="0" cellspacing="0">
		<form action="/mall1/member/ipfind" method="post">
			<tr>
				<td align="center">이름</td>
				<td height="40" align="center"><input type="text" name="username" size="36"/></td>
				<td rowspan="2"><input type="submit" name="login" value="찾기" style="width:70px;height:70px;"></td>
			</tr>
			<tr>
				<td align="center">E-Mail</td>
				<td height="40" align="center"><input type="text" name="email1" size="15"/>@<input type="text" name="email2" size="15"/></td>
			</tr>
		</form>
	</table>
</center>
</body>
</html>