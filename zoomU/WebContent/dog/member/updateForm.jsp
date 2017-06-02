<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>정보수정</title>
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

<script type="text/javascript">
	var myApp = angular.module("myApp", []);
		myApp.controller("RegisterCtrl", function($scope) {
	});
	function init() {
		var btn = document.getElementById("check_btn");
		btn.disabled = true;
	}
	function pwd_check() {
		var pwd = document.getElementById("password");
		var pwd_confirm = document.getElementById("password_confirm");
		var btn = document.getElementById("check_btn");
		btn.disabled = true;
		if (pwd_confirm == null) {
			document.getElementById("pwd_txt").innerHTML = ""
		} else if (pwd_confirm.value == pwd.value) {
			if (pwd.value.length < 8 || pwd_confirm.value.length < 8) {
				document.getElementById("pwd_txt").innerHTML = "<font color = 'red'>비밀번호는 8자 이상입니다.</font>"
			} else {
				document.getElementById("pwd_txt").innerHTML = "<font color = 'green'>비밀번호가 일치합니다.</font>";
				btn.disabled = false;
			}
		} else {
			document.getElementById("pwd_txt").innerHTML = "<font color = 'red'>비밀번호가 일치하지 않습니다.</font>";
		}
	}

	$(function() {
		$('#dupchkBtn').click(function() {
			var mid = $('#id').val();
			window.open('/dog/checkDuplicationId.do?mid=' + mid, "ID 중복체크" ,"width=100, height=100");
		});

		$('#id').change(function() {
			$('#idcheckYn').val("N");
		});
	});
</script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	// 우편번호 찾기 찾기 화면을 넣을 element
	var element_wrap = document.getElementById('wrap');

	function foldDaumPostcode() {
		// iframe을 넣은 element를 안보이게 한다.
		element_wrap.style.display = 'none';
	}

	function sample3_execDaumPostcode() {
		// 현재 scroll 위치를 저장해놓는다.
		var currentScroll = Math.max(document.body.scrollTop,
				document.documentElement.scrollTop);
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = data.address; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 기본 주소가 도로명 타입일때 조합한다.
						if (data.addressType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample3_postcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('sample3_address').value = fullAddr;

						// iframe을 넣은 element를 안보이게 한다.
						// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
						element_wrap.style.display = 'none';

						// 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
						document.body.scrollTop = currentScroll;
					},
					// 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
					onresize : function(size) {
						element_wrap.style.height = size.height + 'px';
					},
					width : '100%',
					height : '100%'
				}).embed(element_wrap);

		// iframe을 넣은 element를 보이게 한다.
		element_wrap.style.display = 'block';
	}
</script>
</head>
<body ng-controller="RegisterCtrl" ng-app="myApp" onkeyup="pwd_check()"
onkeyup="id_check()" onload = "init();window.resizeTo(600,600)">
	<div class="container">
		<div id="signup">
			<div class="signup-screen col-sm-6 col-sm-offset-3">
				<div class="space-bot text-center">
					<h5>정보수정</h5>
					
					<div class="divider"></div>
				</div>
				
				<form action="updatePro.do" method="post" class="form-register" method="post" name="register" novalidate>
					<input id="id" type="hidden" name="mid" class="validate"
					value = "${ requestScope.vo.mid }">
					<div class="input-field col s6">
						<input id="password" type="password" name="mpwd" value = "${ requestScope.vo.mpwd }"
							ng-model="password" class="validate">
						<label for="password">비밀번호</label>
					</div>
					
					<div class="input-field col s6">
						<input id="password_confirm" type="password" name="mpwd"
							ng-model="password_confirm" class="validate">
						<label for="password">비밀번호 확인</label>
					</div>
					<div class="input-field col s6">
						<p id="pwd_txt"></p>
					</div>
					<div class="input-field col s6">
						<input id="name" type="text"  name="mname" class="validate"
						value = "${ requestScope.vo.mname }">
						<label for="name">이름</label>
					</div>
					
					<div class="input-field col s6">
						<input id="tel" type="text"  name="mtel" class="validate"
						value = "${ requestScope.vo.mtel }">
						<label for="tel">전화번호</label>
					</div>
					
					<div class="input-field col s6">
						<input id="email" type="email" name="memail"
							class="validate" value="${requestScope.vo.memail}">
					</div>

					<input type="text" id="sample3_postcode" readonly="readonly"
					 placeholder="우편번호" class="validate">
					<button type="button" onclick="sample3_execDaumPostcode()"
						class="waves-effect waves-light btn done" value="우편번호 찾기">우편번호 찾기</button><br>
						
					<div id="wrap"
						style="display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative">
						<img
							src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
							id="btnFoldWrap"
							style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1"
							onclick="foldDaumPostcode()" alt="접기 버튼">
					</div>
					<input type="text" id="sample3_address" class="d_form large"
						placeholder="주소" name = "maddr" value = "${ requestScope.vo.maddr }">

					<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

					<div class="space-top text-center">
						<button ng-disabled="form-register.$invalid"
							class="waves-effect waves-light btn done" id = "check_btn">
							<i class="material-icons left" >done</i> 수정완료
						</button>
					</form>
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