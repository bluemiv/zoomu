<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 수정</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 부트스트랩 -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- 커스텀 CSS -->
<link href="/dog/css/custom-dog.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/dog/headerMenu.jsp"></jsp:include>

	<!-- Container (Contact Section) -->
	<div class="container">
		<h3 class="text-center">개인 분양 글 수정</h3>
		<p class="text-center">
			<em>강아지 정보를 수정해주세요</em>
		</p>
		<form action="HomeupdatePro.do" method="post"
			enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-4">
					<p class="text-center">
						<em>Select your pet info.</em>
					</p>
					<p>
						<span class="glyphicon glyphicon-ok-sign"></span>성별 :
						<c:if test="${ vo.hgender=='male' }">
							<input type="radio" name="hGender" value="male" checked="checked">Male &nbsp;
                  <input type="radio" name="hGender" value="female">Female &nbsp;
                  <input type="radio" name="hGender" value="mf">중성화 &nbsp;
             </c:if>
						<c:if test="${ vo.hgender=='female' }">
							<input type="radio" name="hGender" value="male">Male &nbsp;
                  <input type="radio" name="hGender" value="female"
								checked="checked">Female &nbsp;
                  <input type="radio" name="hGender" value="mf">중성화 &nbsp;
             </c:if>
						<c:if test="${ vo.hgender=='mf' }">
							<input type="radio" name="hGender" value="male">Male &nbsp;
              		<input type="radio" name="hGender" value="female">Female &nbsp;
              		<input type="radio" name="hGender" value="mf"
								checked="checked">중성화 &nbsp;
             </c:if>
					</p>
					<p>
						<span class="glyphicon glyphicon-ok-sign"></span> 분양유무:
						<c:if test="${ vo.hyn=='yes' }">
							<input type="radio" name="hYn" value="yes" checked="checked">yes &nbsp;
                 		<input type="radio" name="hYn" value="no">no &nbsp;
               </c:if>
						<c:if test="${vo.hyn=='no' }">
							<input type="radio" name="hYn" value="yes">yes &nbsp;
                 		<input type="radio" name="hYn" value="no"
								checked="checked">no &nbsp;
               </c:if>
					</p>
					<p>
						<span class="glyphicon glyphicon-pencil"></span> 종류:<input
							type="text" name="hType" id="hType" value="${ vo.htype }"
							class="form-control" required />

					</p>
				</div>
				<div class="col-md-8">
					<div class="row">
						<div class="col-sm-6 form-group">
							<input type="text" name="hName" id="hName"
								value="${ vo.hpetname }" required class="form-control"
								placeholder="Name">
						</div>
						<div class="col-sm-6 form-group">
							<button class="btn1_c">file upload</button>
							<input type="file" name="hPhoto" class="upload" required="required"
								onchange="javascript:document.getElementById('fileName').value=this.value">
							<input type="text" id="fileName" class="form-control">
						</div>
					</div>
					<textarea rows="10" name="hEtc" id="hEtc" class="form-control"
						required placeholder="Comment">${ vo.hetc }</textarea>
					<br>
					<div class="row">
						<div class="col-md-12 form-group">
							<input type="button" value="cancel" class="btn btn_c pull-right"
								onclick="javascript:window.location='HomelistForm.do'">
							<button class="btn btn_c pull-right" type="submit">write</button>
						</div>
						<input type="hidden" name="hnum" value="${ vo.hnum }" />
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>