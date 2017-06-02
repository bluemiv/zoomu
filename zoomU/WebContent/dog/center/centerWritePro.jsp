<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:if test="${check == true }">
	<script type="text/javascript">
		alert("글 작성 완료");
	</script>
</c:if>
<c:if test="${check == false && check == null }">
	<script type="text/javascript">
		alert("글 작성 실패");
	</script>
</c:if>

<meta http-equiv="Refresh" content="0; url=centerListForm.do">