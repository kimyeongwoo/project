<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link href="" rel="stylesheet">
</head>
<body>
	<h2>상품 정보</h2>
	<table>
		<tr>
			<td><img src="/web03/images/${vo.picture_url }" width="300px" height="300px"></td>
			<td align="center">
				<table>
					<tr>
						<td>상품명</td>
						<td>${vo.product_name }</td>
					</tr>
					<tr>
						<td>가격</td>
						<td>${vo.price }</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>${vo.description }</td>
					</tr>
					<tr>
						<td colspan="2">
							<form name="form1" method="post" action="/web03/cart/insert">
								<input type="hidden" name="product_id" value="${vo.product_id}">
								<select name="amount">
									<c:forEach begin="1" end="10" var="i">
										<option value="${i }">${i }</option><!-- ${i}=수량 -->
									</c:forEach>
								</select>&nbsp;개
								<input type="submit" value="장바구니에 담기" />
							</form>
							<a href="/web03/product/list">상품목록</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>