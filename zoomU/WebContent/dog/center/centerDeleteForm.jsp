<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE>
<html>
<head>
<title>보호소 분양 삭제 페이지</title>
</head>
<body>
	<c:if test="${requestScope.check == true }">
		<script type="text/javascript">
			alert("글 삭제 성공~~");
		</script>
	</c:if>

	<c:if test="${requestScope.check == false}">
		<script type="text/javascript">
			alert("관리자만 글 삭제할 수 있습니다.");
		</script>
	</c:if>
	
	<%-- <c:if test="${requestScope.check != false || requestScope.check != true }">
		<script type="text/javascript">
			alert("글 삭제 실패~~");	
		</script>
	</c:if> --%>

	<meta http-equiv="Refresh" content="0; url='centerListForm.do'">
</body>
</html>