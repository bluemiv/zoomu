<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>보호소 분양 리스트 페이지</title>
	<!-- Bootstrap Core CSS -->
	<link href="/dog/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom CSS -->
	<link href="/dog/css/stylish-portfolio.css" rel="stylesheet">
	<link href="/dog/css/custom-dog.css?ver=1.1" rel="stylesheet">
	<link href="/dog/css/mang_css.css?ver=1.1" rel="stylesheet">
	<!-- Custom Fonts -->
	<link href="/dog/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="/dog/headerMenu.jsp"></jsp:include>
<hr>
<br/><br/><br/>
<div class = "row">
	<div class = "col-lg-6"></div>
	<div class = "col-lg-5">
		<!-- 검색창 -->
		<c:if test="${ requestScope.vo == null}">
			<form class="navbar-form navbar-right">
				<div class="form-group">
					<input type="text" name = "search" class="form-control" placeholder="강아지 이름 검색">
				</div>
				<button type="submit" class="btn btn_c btn-default">검색</button>
			</form>
		</c:if>
	</div>
	<div class = "col-lg-1"></div>
</div>
<div class="container">
	<h2 class = "font-nanum font-size-lg">
		보호소 분양
	</h2>
	<p class = "font-hanna font-size-sm">아픔 있는 강아지를 가족같이 따뜻한 마음으로 함께 하실 분을 구합니다!</p>
 <div id="myCarousel" class="carousel slide" data-ride="false">
 
    <!-- Wrapper for slides -->
    <!-- 첫번쨰 슬라이드 - 4개   -->
    <div class="carousel-inner" role="listbox">
     
     <c:forEach var="center" items="${list}">
     <div class="item active">
		<li class="col-sm-4">
			<div class="fff">
				<div class="thumbnail">
					<a href="centerContentForm.do?cNum=${ center.cNum }">
					<img src="/dog/img/center/${center.cphoto}" class="img-rounded img-size-c" style="width: 350px; height:250px;"/></a>
				</div>
				<div class="caption">
					<h4 class = "font-nanum font-size-md"><c:out value="${center.cPetName}"/></h4>
					<p class = "font-nanum font-size-md"><c:out value="${center.cEtc}"/></p>
					<a class="btn btn-mini" href="centerContentForm.do?cNum=${ center.cNum }">» Read More</a>
				</div>
			</div>
		</li>
	</div>
	</c:forEach>
	
	<div class="item">
	</div>
</div>

<br>

<div align ="center">
	<c:forEach var="i" begin="1" end="${cvo.getTotalPage()}">
		<a href="centerListForm.do?curPage=${i}"><c:out value="[${i}]"/></a>
	</c:forEach>
</div>
	<div class="container">
	<div align="right">
		<c:if test="${ sessionScope.id == null }">
			글쓰기는 <a data-toggle="modal" data-target="#myModal">관리자</a>만 사용가능 합니다.<br/>
			관리자 외에는 사용 불가능합니다.
		</c:if>
		<c:if test="${ sessionScope.id == 'admin' && sessionScope.pwd == 'dogdog123'}">
			<input type="button" value="글쓰기" class="btn btn_c btn-default" onclick="window.location='centerWriteForm.do'"/>
		</c:if>
	</div>	
	</div>

	
	<!-- Footer -->
	<footer class="container-fluid text-center">
		<h2 class = "color-gry">ZoomU</h2>
	</footer>
</body>
</html>