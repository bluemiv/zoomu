<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel='stylesheet prefetch'	href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css'>
<link rel='stylesheet prefetch'	href='https://fonts.googleapis.com/icon?family=Material+Icons'>
<link href="https://fonts.googleapis.com/css?family=Caveat:400,700"	rel="stylesheet">
		<script src='http://code.jquery.com/jquery-2.1.4.min.js'></script>
<script	src='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js'></script>
<script	src='https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js'></script>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function check_onclick(){
	var authority=document.getElementById("authority");
	var autho=document.getElementById("autho");
	if(authority.value==autho.value){
		alert("이메일 인증 성공");
		return true;
	}else{
		alert("인증번호 오류");
		return false;
	}
}
</script>
</head>
<body>
<div class="container">
	<div id="signup">
		<div class="signup-screen col-sm-6 col-sm-offset-3">
			<div class="space-bot text-center">
				<h5> <link href="/dog/img/zoomu1.jpg" rel="stylesheet" media="screen">인증번호 입력</h5>					
			</div>
		   	<form action="insertForm.do" method="post" name="form" id="form" onsubmit='return check_onclick()'>
		     	 <div class="input-field col s6">
					<input id="autho" type="text" name="autho" class="validate" required>
					<label for="id">인증번호</label>
					<input type="hidden" value="${authority}" id="authority" name="authority">
					<input type="hidden" value="${email}" id="email" name="email">
				</div>
				<div class="space-top text-center">
					<button ng-disabled="form-register.$invalid" class="waves-effect waves-light btn done" id="submit">
						<i class="material-icons left">done</i> 입력완료
					</button>
				</div>              
		   	</form>
		</div>
	</div>
</div>

</body>
</html>