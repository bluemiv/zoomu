<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html5>
<html>
<head>
	<title>보호소 위치</title>
	<!-- 페이지 설정 -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<!-- 커스텀 CSS -->
	<link href="/dog/css/custom-dog.css?ver=1.1" rel="stylesheet">
	<link href="css/simple-sidebar.css" rel="stylesheet">
	<!-- 구글맵 CSS -->
    <link rel="stylesheet" href="https://developers.google.com/maps/documentation/javascript/demos/demos.css">
</head>
<body>
	<!-- 상단 메뉴 -->
	<jsp:include page="/dog/headerMenu.jsp"/>
	<br><br>
	<!-- 우측 메뉴 -->
	<div id="wrapper">
		<!-- 사이드 바 -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> 보호소 위치 </a></li>
				<li><a href="mapListForm.do?mArea=서울특별시">서울특별시</a></li>
				<li><a href="mapListForm.do?mArea=경기도">경기도</a></li>
				<li><a href="mapListForm.do?mArea=부산광역시">부산광역시</a></li>
				<li><a href="mapListForm.do?mArea=대구광역시">대구광역시</a></li>
				<li><a href="mapListForm.do?mArea=인천광역시">인천광역시</a></li>
				<li><a href="mapListForm.do?mArea=광주광역시">광주광역시</a></li>
				<li><a href="mapListForm.do?mArea=대전광역시">대전광역시</a></li>
				<li><a href="mapListForm.do?mArea=울산광역시">울산광역시</a></li>
				<li><a href="mapListForm.do?mArea=충청북도">충청북도</a></li>
				<li><a href="mapListForm.do?mArea=충청남도">충청남도</a></li>
				<li><a href="mapListForm.do?mArea=전라북도">전라북도</a></li>
				<li><a href="mapListForm.do?mArea=전라남도">전라남도</a></li>
				<li><a href="mapListForm.do?mArea=경상북도">경상북도</a></li>
				<li><a href="mapListForm.do?mArea=경상남도">경상남도</a></li>
				<li><a href="mapListForm.do?mArea=제주특별자치도">제주특별자치도</a></li>
			</ul>
		</div>

		<!-- 페이지 내용 -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<a href="#menu-toggle" class="btn btn_c btn-default" id="menu-toggle">메뉴</a>
						<h1>보호소 위치</h1>
						<p>유기견을 보호하고 있는 가까운 보호소를 확인하세요!</p>
						<c:if test="${ requestScope.mArea != null }">
							<h3>${ requestScope.mArea }</h3>	
							<c:forEach var = "var" items = "${ requestScope.list }">
								<h4><a href="mapListForm.do?mArea=${ var.mArea }&mCenterName=${ var.mCenterName }">
								보호소 이름 : ${ var.mCenterName }</a><br/>
								${ var.mEtc }</h4>
								<c:if test="${ requestScope.check == true }">
									<input type = "hidden" value = "${ var.mMapX }" id = "mMapX"/>
									<input type = "hidden" value = "${ var.mMapY }" id = "mMapY"/>
									<script type="text/javascript">
										var mMapX = document.getElementById("mMapX");
										var mMapY = document.getElementById("mMapY");
										var myMap = {lat: parseFloat(mMapX.value), lng: parseFloat(mMapY.value)};
									</script>
									<a href = "mapListForm.do?mArea=${ var.mArea }">이전으로</a>
								</c:if>
							</c:forEach>
							<div id="map"></div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->
	  <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>
	
	<!-- 구글맵 -->
	<script type = "text/javascript">
		
		var marker;

		function initMap() {
			// Create a map object and specify the DOM element for display.
			var map = new google.maps.Map(document.getElementById('map'), {
				center : myMap,
				scrollwheel : true,
				zoom : 17
			});
			var myLatLng = myMap;// 좌표 설정
			marker = new google.maps.Marker({
				position : myLatLng, // 내가 설정한 위치에 마커 설정
				map : map,
				draggable : false, // 드래그 할수있게 or 못하게?
				animation : google.maps.Animation.DROP
			// 처음 마커 나올때 애니메이션 효과
			});
			marker.addListener('click', toggleBounce); // 클릭했을때 실행

			
		}
		// 토글 애니메이션 효과
		function toggleBounce() {
			if (marker.getAnimation() !== null) {
				marker.setAnimation(null);
			} else {
				marker.setAnimation(google.maps.Animation.BOUNCE);
			}
		}
	</script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBs7UXfxs30ztjr1sHuC1gas9I2HogfzE4&callback=initMap&language=ko"
    async defer></script>
</body>
</html>