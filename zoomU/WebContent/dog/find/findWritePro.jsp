<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<c:if test = "${ requestScope.check == ture }">
		<script type="text/javascript">
			alert("글 작성 완료되었습니다.");
		</script>
	</c:if>
	<c:if test = "${ requestScope.check != true }">
		<script type="text/javascript">
			alert("Error\n글 작성 실패하였습니다.");
		</script>
	</c:if>
	<meta http-equiv="Refresh" content = "0; url='findListForm.do'"/>
</body>
</html>