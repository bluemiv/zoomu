<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
	<title>ZoomU</title>
	<!-- 페이지 설정 -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
	<link href="css/bootstrap.min.css?ver=1.1" rel="stylesheet" media="screen">
	<!-- 커스텀 CSS -->
	<link href="/dog/css/custom-dog.css?ver=1.1" rel="stylesheet">
</head>
<body>
	<!-- 메뉴 상단 -->
	<jsp:include page="/dog/headerMenu.jsp"/>
	<br/><br/><br/><br/>
	<!-- 컨텐트 -->
	
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<img src = "/dog/img/logo.jpg"/>
					<p class="lead section-lead font-nanum font-size-lg">유기견을 도와주세요</p>
					<p class="section-paragraph font-jeju font-size-sm">많은 유기견이 버려지고있습니다. 당신의 도움이 필요해요<br/>
					강아지는 당신을 원하고 있습니다. 어서 와주세요</p>
				</div>
			</div>
		</div>
	
	<!-- <aside class="image-bg-fixed-height"></aside> -->
	
	<div class = "row">
		<div class = "col-lg-12">
			<img src = "/dog/img/3.png" style = "max-width: 100%;"/>
		</div>
	</div>
	
	<!-- Footer -->
	<footer>
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-10 col-lg-offset-1 text-center">
					<h4>
						<span class = "font-jeju font-size-sm">ZoomU</span>
					</h4>
					<p>
						<span class = "font-jeju font-size-sm">경기도 성남시 분당구 삼평동<br>판교 테크노밸리 U-space</span>
					</p>
					<ul class="list-unstyled">
						<li>
							<span class = "font-jeju font-size-sm">℡ (031) 123-4567</span>
						</li>
						<li>
							<span class="glyphicon glyphicon-envelope"></span>
							<a href="mailto:goodBoy@naver.com">goodBoy@naver.com</a>
						</li>
					</ul>
					<br>
					<ul class="list-inline">
						
					</ul>
					<hr class="small">
					<p class="text-muted font-nanum font-size-sm">Copyright &copy; http://www.zoomu.com</p>
				</div>
			</div>
		</div>
		<a id="to-top" href="#top" class="btn btn-dark btn-lg"><i
			class="fa fa-chevron-up fa-fw fa-1x"></i></a>
	</footer>
</body>
</html>