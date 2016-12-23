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
	function Close(){
		self.close();
	}
</script>
<link href="" rel="stylesheet">
</head>
<body>
<center>
	<br/>
	<tr style="color:red;">${message1 }</tr><br/><br/>
	<tr><input type = "button" name = "confirm_id" value = "확인" onclick = "Close()"></tr>
</center>
</body>
</html>