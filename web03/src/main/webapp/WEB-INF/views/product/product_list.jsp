<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h1>상품목록</h1>
	<table border="1">
		<tr>
			<th>상품ID</th>
			<th>&nbsp;</th>
			<th>상품명</th>
			<th>가격</th>			
		</tr>
		<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.product_id }</td>
				<td><img src="/web03/images/${row.picture_url}" width="100px" height="100px"></td>
				<td>
					<a href="/web03/product/detail/${row.product_id }">${row.product_name }</a>
					<!-- 하나만 설명하겠다 보통은 /web03/product/detail?product_id=? 식으로 파라미터 값을 넘긴다. 그래서 받을때 @RequestParam 을 써야한다.(안써도되고 ㅋㅋ생략하자) 그러나 지금 위에 사용된 방법은 restful 방식이다. /web03/product/detail/? 주소줄(url)에 값을 집어넣는것이다. 이경우 컴퓨터가 값을 파라미터로 인식 못하고 말 그대로 통째로 주소줄로 보기때문에 @PathVariable을 써야한다. -->
				</td>
				<td>
					<fmt:formatNumber value="${row.price }" pattern="#,###" />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>