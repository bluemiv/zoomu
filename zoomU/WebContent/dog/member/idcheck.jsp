<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<script type="text/javascript">
	var result ='<%=request.getAttribute("result")%>';
	if(result == 'N'){
		window.close();
		alert("중복된 아이디가 있습니다.");
	}else{
		window.close();
		alert("사용가능한 아이디입니다.");
		opener.document.getElementById("idcheckYn").value = "Y";
 	}
	window.close();
</script>
</body>
</html>