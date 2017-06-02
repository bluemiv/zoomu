<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>강아지를 찾아주세요</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<!-- 커스텀 CSS -->
	<link href="/dog/css/custom-dog.css?ver=1.1" rel="stylesheet">
	<link href="/dog/css/mang_css.css?ver=1.1" rel="stylesheet">
</head>
<body>

<!-- 메뉴 상단 -->
<jsp:include page="/dog/headerMenu.jsp"/>
<hr>
<br><br><br>
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
		강아지를 찾아주세요
	</h2>
	<p class = "font-hanna font-size-sm">강아지를 잃어버렸습니다. 도움이 필요합니다!</p>
	
	<div id="myCarousel" class="carousel slide" data-ride="false">
		<!-- 첫번쨰 슬라이드 - 4개   -->
		<div class="carousel-inner" role="listbox">
			<c:set var="count" value="${ 1 }" />
			<!-- 리스트 출력 -->
			<c:forEach items="${ requestScope.list }" var="var">
				<div class="item active">
					<li class="col-sm-4">
						<div class="fff">
							<div class="caption">
								<h4>${ count }번</h4>
							</div>
							<div class="thumbnail">
								<a href="findContentForm.do?fNum=${ var.fNum }">
									<img class="img-rounded img-size-c" src="/dog/img/find/${ var.fPhoto }"
									style="width: 350px; height:250px;">
								</a>
							</div>
							<div class="caption">
								<h4 class = "font-nanum font-size-md">
									강아지 이름 : <c:out value="${ var.fPetName }" />
								</h4>
								<p class = "font-nanum font-size-md">
									특징 : <c:out value="${ var.fEtc }" />
								</p>
								<p class = "font-nanum font-size-md">
									작성자 : <c:out value="${ var.fId }" />
								</p>
								<a class="btn btn-mini" href="findContentForm.do?fNum=${ var.fNum }">» Read More</a>
							</div>
						</div> <!-- END fff -->
					</li>
				</div>
				<c:set var="count" value="${ count + 1 }" />
			</c:forEach>
	<!-- END 리스트 출력 -->
	<div class="item"></div>
</div>

<br/>

<!-- 하단 버튼 -->
<div align ="center">
	<c:forEach var="i" begin="1" end="${cvo.getTotalPage() }">
		<a href="findListForm.do?curPage=${i}"><c:out value="[${i}]"/></a>
	</c:forEach>
</div>
<div class="container">
	<!-- 글쓰기 -->
	<div align="right">
		<c:if test="${ sessionScope.id == null }">
			글쓰기는 <a data-toggle="modal" data-target="#myModal">로그인</a> 후 사용 가능 합니다.<br/>
			혹시 회원이 아니시면 
			<a href="#" onclick="window.open('memberEmailForm.do', '회원가입', 'width=300, height=250')">회원가입</a>
			을 해주세요!
		</c:if>
		<c:if test="${ sessionScope.id != null }">
			<input type="button" value="글쓰기" class="btn btn_c btn-default"
				onclick="javascript:window.location='findWriteForm.do'">
		</c:if>
	</div>
</div>
		


	<!-- Footer -->
	<footer class="container-fluid text-center">
		<h2 class = "color-gry">ZoomU</h2>
	</footer>
</body>
</html>