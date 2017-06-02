<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:if test="${check == false }">
	<script type="text/javascript">
		alert("글을 수정 했습니다. ");
	</script>
</c:if>
<c:if test="${requestScope.check != false && requestScope.check != true }">
<script type="text/javascript">
	alert("글 수정 실패");
</script>
</c:if>

<meta http-equiv="Refresh" content="0; url=centerListForm.do">