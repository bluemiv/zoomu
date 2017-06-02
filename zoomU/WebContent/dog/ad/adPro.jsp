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
			alert("후원해주셔서 감사합니다!");
		</script>
	</c:if>
	<c:if test="${ requestScope.check == false || requestScope.check == null }">
		<script type="text/javascript">
			alert("Error : 다시 시도해주세요");
		</script>
	</c:if>
	<meta http-equiv="Refresh" content = "0; url='infoForm.do'"/>
</body>
</html>