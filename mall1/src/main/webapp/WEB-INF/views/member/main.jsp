<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h1>Main Page</h1>
<c:choose>
	<c:when test="${not empty sessionScope.userid}">
		${sessionScope.username} WELCOME
		<a href="/mall1/member/logout">로그아웃</a>
		<a href="/mall1/member/info">마이페이지</a>
	</c:when>
	<c:otherwise>
		<h2>로그인 해주세요</h2>
		<a href="/mall1/member/login">로그인</a>
	</c:otherwise>
</c:choose>
</body>
</html>