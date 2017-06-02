<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>개인 분양</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- 부트스트랩 -->
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<!-- 커스텀 CSS -->
	<link href="/dog/css/custom-dog.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/dog/headerMenu.jsp"></jsp:include>
<br/><br/><br/>
	<div class="container">
		<form action="HomewritePro.do" method="post" enctype="multipart/form-data">
			<h3 class="text-center">개인 분양 글쓰기</h3>
			<p class="text-center">
				<em>강아지 정보를 입력해주세요</em>
			</p>

			<div class="row">
				<div class="col-md-4">
					<p class="text-center">
						<em>Select your pet info.</em>
					</p>
					<p>
						<span class="glyphicon glyphicon-ok-sign"></span> 성별: <input
							type="radio" name="hGender" value="male">Male &nbsp; <input
							type="radio" name="hGender" value="female">Female &nbsp;
						<input type="radio" name="hGender" value="mf">중성화 &nbsp;
					</p>
					<p>
						<span class="glyphicon glyphicon-ok-sign"></span>분양유무: <input
							type="radio" name="hYn" value="yes">yes &nbsp; <input
							type="radio" name="hYn" value="no">no &nbsp;
					</p>
					<p>
						<span class="glyphicon glyphicon-pencil"></span>
						종류:<input type="text" name="hType" id="hType" class="form-control" required/>
							
					</p>
				</div>
				
				<div class="col-md-8">
					<div class="row">
						<div class="col-sm-6 form-group">						
							<input type="text" name="hName" id="hName" class="form-control" placeholder="제목">
						</div>
						<div class="col-sm-6 form-group"> 
							<button class="btn1_c">file upload</button>
							<input type="file" name="hPhoto" class="upload" onchange="javascript:document.getElementById('fileName').value=this.value">
							<input type="text" id="fileName" class="form-control">
						</div>
					</div>
					<textarea class="form-control" rows="10" name="hEtc" id="hEtc"
						placeholder="Comment" required></textarea>
					<div class="row">
						<div class="col-md-12 form-group">
							<input type="button" value="cancel" class="btn btn_c pull-right" onclick="javascript:window.location='HomelistForm.do'">&nbsp;&nbsp;
							<button class="btn btn_c pull-right" type="submit">write</button>								
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>