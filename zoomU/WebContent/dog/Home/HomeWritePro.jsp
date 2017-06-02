<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${check == true}">
<script type="text/javascript">
alert("insert success");
</script>
<meta  http-equiv="Refresh"  content="0; url=HomelistForm.do" >
</c:if>
<c:if test="${ check == false }">
<script type="text/javascript">
alert("insert fail");
</script>
<meta  http-equiv="Refresh"  content="0; url=HomewriteForm.do" >
</c:if>
</body>
</html>