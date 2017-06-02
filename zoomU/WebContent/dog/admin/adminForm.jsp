<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<link href="/dog/css/bootstrap.min.css" rel="stylesheet">
<title>관리자 페이지</title>
</head>
<body>
<!-- Page Content -->
<div class="container">

<div class="row">

	<div class="col-lg-12">
		<h1 class="page-header">보호소분양</h1>
	</div>
	<c:forEach var = "center" items="${ requestScope.center_list }">
		<div class="col-lg-3 col-md-4 col-xs-6 thumb">
			<p>DB번호 : ${ center.cNum }</p>
			<a class="thumbnail" href="#">
			<img class="img-responsive"  style="width: 300px; height : 250px;"
				src="/dog/img/center/${ center.cphoto }" alt="그림오류">
			</a>
			<p>${ center.cPetName }</p>
			<form action = "adminDelete.do" method = "post">
				<input type= "hidden" name = "board" class = "btn" value = "center"/>
				<input type= "hidden" name = "cNum" class = "btn" value = "${ center.cNum }"/>
				<input type = "submit" class = "btn" value = "글 삭제"/>
			</form>
		</div>
	</c:forEach>

	<div class="col-lg-12">
		<h1 class="page-header">개인분양</h1>
	</div>
	<c:forEach var = "home" items="${ requestScope.home_list }">
		<div class="col-lg-3 col-md-4 col-xs-6 thumb">
			<p>DB번호 : ${ home.hnum }</p>
			<a class="thumbnail" href="#">
				<img class="img-responsive" style="width: 300px; height : 250px;"
				src="/dog/img/home/${ home.hphoto }" alt="그림오류">
			</a>
			<p>${ home.hpetname }</p>
			<form action = "adminDelete.do" method = "post">
				<input type= "hidden" name = "board" class = "btn" value = "home"/>
				<input type= "hidden" name = "hnum" class = "btn" value = "${ home.hnum }"/>
				<input type = "submit" class = "btn" value = "글 삭제"/>
			</form>
		</div>
	</c:forEach>
	
	<div class="col-lg-12">
		<h1 class="page-header">강아지찾아요</h1>
	</div>
	<c:forEach var = "find" items="${ requestScope.find_list }">
		<div class="col-lg-3 col-md-4 col-xs-6 thumb">
			<p>DB번호 : ${ find.fNum }</p>
			<a class="thumbnail" href="#">
				<img class="img-responsive"  style="width: 300px; height : 250px;"
				src="/dog/img/find/${ find.fPhoto }" alt="그림오류">
			</a>
			<p>${ find.fPetName }</p>
			<form action = "adminDelete.do" method = "post">
				<input type= "hidden" name = "board" class = "btn" value = "find"/>
				<input type= "hidden" name = "fNum" class = "btn" value = "${ find.fNum }"/>
				<input type = "submit" class = "btn" value = "글 삭제"/>
			</form>
		</div>
	</c:forEach>

	<div class="col-lg-12">
		<h1 class="page-header">SOS</h1>
	</div>
	<c:forEach var = "sos" items="${ requestScope.sos_list }">
		<div class="col-lg-3 col-md-4 col-xs-6 thumb">		
			<p>DB번호 : ${ sos.snum }</p>
			<p>제목 : ${ sos.stitle }</p>
			<p>작성자 : ${ sos.swriter }</p>
			<br/>
			<form action = "adminDelete.do" method = "post">
				<input type= "hidden" name = "board" class = "btn" value = "sos"/>
				<input type= "hidden" name = "snum" class = "btn" value = "${ sos.snum }"/>
				<input type = "submit" class = "btn" value = "글 삭제"/>
			</form>
		</div>
	</c:forEach>
</div>
</body>
</html>