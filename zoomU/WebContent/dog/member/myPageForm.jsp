<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
<link href="https://fonts.googleapis.com/css?family=Caveat:400,700" rel="stylesheet">
<script src='http://code.jquery.com/jquery-2.1.4.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js'></script>
<script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js'></script>
<!-- 페이지 설정 -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 커스텀 CSS -->
<link href="/dog/css/custom-dog.css" rel="stylesheet">
<title>마이페이지</title>
</head>
<body>
<div class="container">
		<div id="signup">
			<div class="signup-screen col-sm-6 col-sm-offset-3">
				<div class="space-bot text-center">
					<h5> <link href="/dog/img/zoomu1.jpg" rel="stylesheet" media="screen">마이페이지</h5>
					
					<div class="divider"></div>
				</div>
					
					<div class="input-field col s6">
						아이디
						<input id="id" type="text" name="mid" class="validate"
						value = "${ requestScope.vo.mid }" disabled="disabled">
					</div>
					<div class="input-field col s6">
						<p id="pwd_txt"></p>
					</div>
					<div class="input-field col s6">
						이름
						<input id="name" type="text"  name="mname" class="validate" disabled="disabled"
						value = "${ requestScope.vo.mname }">
					</div>
					
					<div class="input-field col s6">
						전화번호
						<input id="tel" type="text"  name="mtel" class="validate" disabled="disabled"
						value = "${ requestScope.vo.mtel }">
					</div>
					
					<div class="input-field col s6">
						이메일
						<input id="email" type="email" name="memail" readonly="readonly"
						disabled="disabled" class="validate" value="${requestScope.vo.memail}">
					</div>

					<div class="input-field col s6">
						주소
						<input type="text" disabled="disabled"
						 value = "${ requestScope.vo.maddr }">
					</div>
					<div class="space-top text-center">
						<button class="waves-effect waves-light btn done" 
						onclick = "window.location='/dog/updateForm.do'">
							<i class="material-icons left" >done</i> 정보수정하기
						</button>
						<button type="button" class="waves-effect waves-light btn cancel"
						onclick = "window.location='/dog/index.jsp'">
							<i class="material-icons left">clear</i>메인으로
						</button>
					</div>
			</div>
		</div>
	</div>
</body>
</html>