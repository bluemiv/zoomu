<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보호소 분양 글수정 페이지</title>
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
	
<c:if test="${check == false}">
	<script type="text/javascript">
		alert("관리자만 수정할 수 있습니다.");
	</script>
	<meta http-equiv="Refresh" content="0; url='centerListForm.do' "/>
</c:if>

<c:if test="${check == true}">	
	<div class="container">
		<h3 class="text-center">보호소 분양 글 수정</h3>
			<p class="text-center">
				<em>강아지 소개를 해주세요</em>
			</p>
		<form action="centerUpdatePro.do" method="post"
			enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-4">
					<p class="text-center">
						<em>Select your pet info.</em>
					<p>
						<span class="glyphicon glyphicon-ok-sign"></span> 성별:
						<c:if test="${vo.cGender=='male' }">
							<input type="radio" name="cGender" value="male" checked="checked">Male &nbsp;
                  			<input type="radio" name="cGender" value="female">Female &nbsp;
                  			<input type="radio" name="cGender" value="mf">중성화 &nbsp;
             			</c:if>

						<c:if test="${vo.cGender=='female' }">
							<input type="radio" name="cGender" value="male">Male &nbsp;
                  			<input type="radio" name="cGender" value="female" checked="checked">Female &nbsp;
                  			<input type="radio" name="cGender" value="mf">중성화 &nbsp;
             			</c:if>

						<c:if test="${vo.cGender=='mf' }">
							<input type="radio" name="cGender" value="male">Male &nbsp;
                 			<input type="radio" name="cGender" value="female">Female &nbsp;
                 			<input type="radio" name="cGender" value="mf" checked="checked">중성화 &nbsp;
             			</c:if>
					</p>
					<p>
						<span class="glyphicon glyphicon-ok-sign"></span>분양유무: 
						<c:if test="${vo.cYn == 'yes'}">
						<input type="radio" name="cYn" value="yes" checked="checked">yes &nbsp; 
						<input type="radio" name="cYn" value="no">no &nbsp;
						</c:if>
						<c:if test="${vo.cYn == 'no'}">
						<input type="radio" name="cYn" value="yes">yes &nbsp; 
						<input type="radio" name="cYn" value="no" checked="checked">no &nbsp;
						</c:if>
					</p>
					<p>
						<span class="glyphicon glyphicon-pencil"></span>
						종류: <input type="text" name="cType" id="cType" value="${vo.cType}" class="form-control"/>
					</p>
				</div>


				<div class="col-md-8">
					<div class="row">
						<div class="col-sm-6 form-group">
							* 강아지 이름 : <input type="text" name="cPetName" value="${vo.cPetName}"
							requiredclass="form-control" placeholder="강아지 이름">
						</div>
						<div class="col-sm-6 form-group">
							* 보호소 이름 : <input type="text" name="cName" value="${vo.cName }"
							required class="form-control" placeholder="보호소 이름">
						</div>
						<div class="col-sm-6 form-group">
							<button class="btn1_c">file upload</button>
							<input type="file" name="Cphoto" required class="upload"
								onchange="javascript:document.getElementById('fileName').value=this.value">
							<input type="text" id="fileName" class="file_input_button form-control">
						</div>
					</div>
					<textarea class="form-control" rows="10" name="cEtc" id="cEtc"
					required placeholder="Comment(특징)" > ${vo.cEtc }</textarea>
					<br>	
					<textarea class="form-control" rows="3" name="cArea" id="cArea"
					required placeholder="Comment(발견장소)" > ${vo.cArea }</textarea>
					
					<div class="row">
						<div class="col-md-12 form-group">
							<input type="button" value="cancel" class="btn btn_c pull-right"
								onclick=" window.location='centerListForm.do' ">&nbsp;&nbsp;
							<button class="btn btn_c pull-right" type="submit">write</button>
							<input type="hidden" name="cNum" value="${vo.cNum }" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</c:if>
</body>
</html>