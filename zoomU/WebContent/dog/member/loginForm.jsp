<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<!-- 페이지 설정 -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 부트스트랩 -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- 커스텀 CSS -->
<link href="/dog/css/custom-dog.css?ver=1.1" rel="stylesheet">
</head>
<body>
<c:if test="${ sessionScope.id == null }">
	회원로그인<br/>
	<form action="loginPro.do" method="post" >
		아이디 : <input type="text" name="mid" ><br/>
		비밀번호 : <input type="password" name="mpwd"><br/>
	    <input type="submit" value="로그인">
	    <input type="button" value="회원가입" onclick="javascript:window.location='insertForm.do'"/>
	</form>
</c:if>
<c:if test="${ sessionScope.id != null }">
	${ sessionScope.id }님 환영합니다.<br/>
	<input type = "button" value = "로그아웃" onclick = "javascript:window.location='logout.do'"/><br/><br/>
	<input type = "button" value = "정보수정" onclick = "javascript:window.location='updateForm.do'"/>
	<input type = "button" value = "회원탈퇴" onclick = "javascript:window.location='deleteForm.do'"/>
</c:if>
</body>
</html>