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
<script type="text/javascript">

	//이메일 폼 동작
	function SetEmailTail(emailValue) {
		var email = document.all("email")    // 사용자 입력
		var emailTail = document.all("email2") // Select box
		   
		if ( emailValue == "notSelected" )
			return;
		else if ( emailValue == "etc" ) {
			emailTail.readOnly = false;
			emailTail.value = "";
			emailTail.focus();
		} else {
			emailTail.readOnly = true;
			emailTail.value = emailValue;
		}
	}
	
	//비밀번호 6~16, 숫자, 문자 - 유효성 검사
	function isValidFormPassword(pw) {
		var check = /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,16}$/;
		if (!check.test(pw)) {
			$('font[name=pwd]').text('');
			$('font[name=pwd]').html("6 ~ 16자리의 숫자, 문자 조합이어야 합니다.");
		}else {
			$('font[name=pwd]').text('');
			$('font[name=pwd]').html("사용 가능한 비밀번호입니다.");
		}
	
	}
	$(document).on('keyup', '#user_pass', function(){
		isValidFormPassword($('#user_pass').val());
	});
	
	//비밀번호 확인
	$(function(){
		$('#user_pass').keyup(function(){
			$('font[name=pwd]').text('');
 		}); //#user_pass.keyup

		$('#chpass').keyup(function(){
			if($('#user_pass').val()!=$('#chpass').val()){
				$('font[name=pwcheck]').text('');
				$('font[name=pwcheck]').html("비밀번호가 일치하지 않습니다.");
			}else{
				$('font[name=pwcheck]').text('');
				$('font[name=pwcheck]').html("올바르게 적용하셨습니다.");
			}
		}); //#chpass.keyup
 	});
	
</script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>

    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
    
</script>
<link href="" rel="stylesheet">
</head>
<body>
<center>
	<hr width="500" color="red" size="3"/>
	<h3>개인정보변경</h3>
	<hr width="500" color="red" size="3"/>
	<br/><br/><br/>
	
	<table width="550" cellpadding="0" cellspacing="0">
		<form action="/mall1/member/modify" method="post">
			<tr>
				<td align="center">아이디</td>
				<td height="40"><input type="text" name="userid" size="30" value="${userid }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td height="40"><input type="text" name="username" value="${username }" readonly="readonly" size="30"/></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td height="40"><input type="password" name="userpw" id="user_pass" size="30" value="${userpw }"/></td>
			</tr>
			<tr>
				<td></td>
				<td><font name="pwd" size="2" color="red"></font></td>
			</tr>
			<tr>
				<td align="center">비번확인</td>
				<td height="40"><input type="password" name="userpwck" id="chpass" size="30" value="${userpw }"/></td>
			</tr>
			<tr>
				<td></td>
				<td><font name="pwcheck" size="2" color="red"></font></td>
			</tr>
			<tr>
				<td align="center">주소</td>
				<td height="40">
					<input type="text" name="zipcode" id="sample4_postcode" placeholder="우편번호" value="${zipcode }">
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
				</td>
			</tr>
			<tr>
				<td align="center">&nbsp;</td>
				<td height="40"><input type="text" name="addr" id="sample4_roadAddress" placeholder="도로명주소" value="${addr }"><input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소" value="${addr2 }"></td>
			</tr>
			<tr>
				<td align="center">전화번호</td>
				<td height="40"><input type="text" name="tel1" size="15" value="${tel1 }"/>-<input type="text" name="tel2" size="15" value="${tel2 }"/>-<input type="text" name="tel3" size="15" value="${tel3 }"/></td>
			</tr>
			<tr>
				<td align="center">이메일</td>
				<td height="40">
					<input type="text" name="email1" value="${email1 }"/>@<input type="text" name="email2" value="${email2 }" ReadOnly="true"/>
					<select name="emailCheck" onchange="SetEmailTail(emailCheck.options[this.selectedIndex].value)">
						<option value="notSelected" >::선택하세요::</option>
					    <option value="etc">직접입력</option>
					    <option value="naver.com">naver.com</option>
					    <option value="nate.com">nate.com</option>
					    <option value="empal.com">empal.com</option>
					    <option value="hotmail.com">hotmail.com</option>
					    <option value="lycos.co.kr">lycos.co.kr</option>
					    <option value="msn.com">msn.com</option>
					    <option value="hanmail.net">hanmail.net</option>
					    <option value="yahoo.com">yahoo.com</option>
					    <option value="korea.com">korea.com</option>
					    <option value="kornet.net">kornet.net</option>
					    <option value="yahoo.co.kr">yahoo.co.kr</option>
					    <option value="kebi.com">kebi.com</option>
					    <option value="orgio.net">orgio.net</option>
					    <option value="paran.com">paran.com</option>    
					    <option value="gmail.com">gmail.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="60"><input type="submit" value="수정"/><input type="reset" value="취소"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick=location.href="/mall1/member/leave?userid=${userid }" value="회원탈퇴" /></td>
			</tr>
		</form>
	</table>
</center>
</body>
</html>