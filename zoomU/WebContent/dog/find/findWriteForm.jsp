<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>찾아줘 - 글쓰기</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<!-- 커스텀 CSS -->
	<link href="/dog/css/custom-dog.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/dog/headerMenu.jsp"></jsp:include>
<br/><br/><br/>
	<div class="container">
		<form action = "findWritePro.do" method = "post" enctype="multipart/form-data">
			<h3 class="text-center">강아지 찾아주세요 글쓰기</h3>
			<p class="text-center">
				<em>강아지 정보를 입력해주세요</em>
			</p>

			<div class="row">
				<div class="col-md-4">
					<p class="text-center">
						<em>Select your pet info.</em>
					</p>
					<p>
						<span class="glyphicon glyphicon-ok-sign"></span>*강아지 성별 : 
						<input type = "radio" name = "fGender" value = "man"/>수컷
						&nbsp;<input type = "radio" name = "fGender" value = "woman"/>암컷
					</p>
					<p>
						<span class="glyphicon glyphicon-pencil"></span>
							*강아지 종류 : <input type = "text" name = "fType" placeholder = "강아지 종류"
							required = "required" class="form-control" /><br/>
					</p>
				</div>
				
				<div class="col-md-8">
					<div class="row">
						<div class="col-sm-6 form-group">	
							*강아지 이름 : <input type = "text" name = "fPetName"
							placeholder = "강아지 이름을 입력해주세요" required = "required" class="form-control"/>
						</div>
						<div class="col-sm-6 form-group"> 
							<button class="btn1_c">file upload</button>
							<input type = "file" name = "fPhoto" class="upload"
							onchange="javascript:document.getElementById('fileName').value=this.value"/>
							<input type="text" id="fileName" class="form-control">
						</div>
					</div>
					*잃어버린 날짜 : <input type = "date" name = "fDate" required = "required"
					class="form-control"/><br/>
					*잃어버린 지역 : <input type = "text" name = "fArea" placeholder = "ex) 서울 동작구"
					required = "required" class="form-control"/><br/>
					*연락처 : <input type = "text" name = "fTel" placeholder = "연락처를 입력해주세요"
					required = "required" class="form-control"/><br/>
					기타 특이사항<textarea type = "text" name = "fEtc" placeholder = "강아지 특징을 넣어주세요"
					cols="50" rows="20" class="form-control"></textarea>
					
					<div class="row">
						<div class="col-md-12 form-group">
							<input type="button" value="cancel" class="btn btn_c pull-right" onclick="javascript:window.location='findListForm.do'">&nbsp;&nbsp;
							<input type = "submit" value = "글쓰기 완료" class="btn btn_c pull-right"/>								
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>