<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${check == true}">
		<script type="text/javascript">
			alert("delete success");
		</script>
	</c:if>
	<c:if test="${check == false}">
		<script type="text/javascript">
			alert("글쓴이만 지울수 있습니다");
		</script>
	</c:if>
	<meta http-equiv="Refresh" content="0; url=HomelistForm.do" >
</body>
</html>