<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인 결과</title>
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
	<c:if test="${ requestScope.check == true }">
		<script type="text/javascript">
			alert("로그인 성공");
		</script>
	</c:if>
	<c:if test="${ requestScope.check != true }">
		<script type="text/javascript">
			alert("로그인 실패");
		</script>
	</c:if>
	<meta http-equiv="Refresh" content = "0; url='/dog/index.jsp'"/>
</body>
</html>