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
</head>
<body ng-controller="RegisterCtrl" ng-app="myApp">
<div class="container">
	<div id="signup">
		<div class="signup-screen col-sm-6 col-sm-offset-3">
			<div class="space-bot text-center">
				<h5> <link href="/dog/img/zoomu1.jpg" rel="stylesheet" media="screen">이메일 인증하기</h5>					
			</div>
		   	<form action="memberEmailPro.do" method="post">
		     	 <div class="input-field col s6">
					<input id="id" type="text" name="to" class="validate" required>
					<label for="id">email</label>
				</div>
				<div class="space-top text-center">
					<button ng-disabled="form-register.$invalid"
						class="waves-effect waves-light btn done" >
						<i class="material-icons left">done</i> 인증번호 발송
					</button>
				</div>              
		   	</form>
   		</div>
   	</div>
</div>
</body>
</html>