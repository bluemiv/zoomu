<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<c:if test="${ requestScope.check == true }">
			<script type="text/javascript">
				alert("입력완료");
			</script>
	</c:if>
	
	<c:if test="${ requestScope.check == false }">
			<script type="text/javascript">
				alert("로그인 후 댓글 작성이 가능합니다");
			</script>
	</c:if>
	<c:if test="${ requestScope.check == null }">
			<script type="text/javascript">
				alert("에러");
			</script>
	</c:if>
	<meta http-equiv="Refresh" content = "0; url = 'HomecontentForm.do?hnum=${ requestScope.vo.ref }'"/>		
</body>
</html>