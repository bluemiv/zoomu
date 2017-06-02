<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<c:if test="${ requestScope.check == true }">
		<script type="text/javascript">
			alert("글을 수정 했습니다.");
		</script>
	</c:if>
	<c:if test="${ requestScope.check == false }">
		<script type="text/javascript">
			alert("작성자만 글을 수정 할 수 있습니다.");
		</script>
	</c:if>
	<c:if test="${ requestScope.check != true && requestScope.check != false }">
		<script type="text/javascript">
			alert("Error : 수정 실패");
		</script>
	</c:if>
	<meta http-equiv="Refresh" content = "0; url='findListForm.do'"/>
</body>
</html>