<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보호소 분양 글쓰기 페이지</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- 커스텀 CSS -->
	<link href="/dog/css/custom-dog.css" rel="stylesheet">
</style>
</head>
<body>
	<jsp:include page="/dog/headerMenu.jsp"></jsp:include>
	<br/><br/><br/>
	<div class="container">
		<form action="centerWritePro.do" method="post"
			enctype="multipart/form-data">
			<h3 class="text-center">보호소 분양 글 작성</h3>
			<p class="text-center">
				<em>강아지 소개를 해주세요!</em>
			</p>

			<div class="row">
				<div class="col-md-4">
					<p class="text-center">
						<em>Select your pet info.</em>
					</p>
					<p>
						<span class="glyphicon glyphicon-ok-sign"></span> 성별: <input
							type="radio" name="cGender" value="male">Male &nbsp; <input
							type="radio" name="cGender" value="female">Female &nbsp;
						<input type="radio" name="cGender" value="mf">중성화 &nbsp;
					</p>
					<p>
						<span class="glyphicon glyphicon-ok-sign"></span>분양유무: <input
							type="radio" name="cYn" value="yes">yes &nbsp; <input
							type="radio" name="cYn" value="no">no &nbsp;
					</p>
					<p>
						<span class="glyphicon glyphicon-pencil"></span>
						종류: <input type="text" name="cType" id="cType" class="form-control"/>
					</p>
				</div>


				<div class="col-md-8">
					<div class="row">
						<div class="col-sm-6 form-group">
							* 강아지 이름<br/><input type="text" name="cPetName"
								required = "required" class="form-control" placeholder="강아지 이름">
						</div>
						<div class="col-sm-6 form-group">
							* 보호소 이름<br/><input type="text" name="cName"
								required = "required" class="form-control" placeholder="보호소이름">
						</div>
						<div class="col-sm-6 form-group">
							<button class="btn1_c">file upload</button>
							<input type="file" name="Cphoto" required = "required" class="upload"
								onchange="javascript:document.getElementById('fileName').value=this.value">
							<input type="text" id="fileName" class="form-control">
						</div>
						
					</div>
					특징<br/>
					<textarea class="form-control" rows="10" name="cEtc" id="cEtc"
						placeholder="Comment(특징)" required = "required"></textarea>
					* 발견장소<br/>	
					<textarea class="form-control" rows="3" name="cArea" id="cArea"
						placeholder="Comment(발견장소)" required = "required"></textarea>
					
					<div class="row">
						<div class="col-md-12 form-group">
							<input type="button" value="cancel" class="btn btn_c pull-right"
								onclick=" window.location='centerListForm.do' ">&nbsp;&nbsp;
							<button class="btn btn_c pull-right" type="submit">글쓰기</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>