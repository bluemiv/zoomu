<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test = "${ requestScope.check == true }">
	<script>
		alert("정보수정 완료");
	</script>
</c:if>

<c:if test = "${ requestScope.check != true }">
	<script>
		alert("Error : 정보수정 실패");
	</script>
</c:if>

<meta http-equiv="Refresh" content= "0; url='/dog/index.jsp'"/>