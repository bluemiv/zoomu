<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- 커스텀 폰트 -->
	<link href="/dog/fonts/custom_font.css?ver=1.1" rel="stylesheet">
<nav class="navbar-inverse navbar-fixed-top" >
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header top-fix">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/dog/index.jsp">ZoomU</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><!-- Info -->
					<a class = "font-nanum font-size-menu" href="infoForm.do">단체 소개</a>
				</li>
				<li class="dropdown"><!-- Member -->
					<a class="dropdown-toggle font-nanum font-size-menu" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">
					분양
					</a>
					<ul class="dropdown-menu font-nanum font-size-menu">
						<li><!-- Center -->
							<a href="centerListForm.do">보호소 분양</a>
						</li>
						<li><!-- Home -->
							<a href="HomelistForm.do">개인 분양</a>
						</li>
					</ul>
				</li>
				<li><!-- SOS -->
					<a class = "font-nanum font-size-menu" href="sosListForm.do">SOS</a>
				</li>
				<li><!-- Find -->
					<a class = "font-nanum font-size-menu" href="findListForm.do">강아지를 찾아주세요</a>
				</li>
				<li><!-- map -->
					<a class = "font-nanum font-size-menu" href="mapListForm.do">보호소 위치</a>
				</li>
				<c:if test="${ requestScope.ad.aEnterName != null }">
					<li><!-- ad -->
						<a href="#"  class = "font-nanum font-size-menu">
					${ requestScope.ad.aEnterName } 이(가) 후원하는 홈페이지 입니다.</a>
					</li>
				</c:if>
				<li class="dropdown"><!-- Member -->
					<a class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">
					<c:if test="${ sessionScope.id == null }">
						<span class = "font-nanum font-size-menu">♬ 회원관리</span>
					</c:if>
					<c:if test="${ sessionScope.id != null }">
						<span class="glyphicon glyphicon-user"></span> ${ sessionScope.id }
					</c:if>
						<span class="caret"></span>
					</a>
					<ul class="font-nanum font-size-menu dropdown-menu">
						<c:if test="${ sessionScope.id != null }">
							<li><a href="myPageForm.do">마이페이지</a></li>
							<li role="separator" class="divider"></li>
						</c:if>
						<c:if test="${ sessionScope.id == null }">
							<li><a data-toggle="modal" data-target="#myModal">로그인</a></li>
							<li><a href="#" onclick="window.open('memberEmailForm.do', '회원가입', 'width=300, height=250')">회원가입</a></li>
						</c:if>
						<c:if test="${ sessionScope.id != null }">
							<li><a href="logout.do"
							onclick = "javascript:window.location='logout.do'">
							로그아웃</a></li>
							<li role="separator" class="divider"></li>
							<li><a data-toggle="modal" data-target="#memberDelete">회원탈퇴</a></li>
						</c:if>
					</ul>
				</li>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>

<!-- 로그인 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">로그인</h4>
			</div>
			<form action="loginPro.do" method="post" >
				<div class="modal-body">
					ID <input name = "mid" type = "text" class="form-control" placeholder = "Username"><br/>
					Paswword<input name = "mpwd" type = "password" class="form-control" placeholder = "Password">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<input type="submit" class="btn btn-primary" value = "로그인"/>
				</div>
			</div>
		</form>
	</div>
</div>


<!-- 회원탈퇴 -->
<div class="modal fade" id="memberDelete" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">회원탈퇴</h4>
			</div>
			<form action="deletePro.do" method="post" >
				<div class="modal-body">
					Paswword<input name = "mpwd" type = "password" class="form-control" placeholder = "Password">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<input type="submit" class="btn btn-primary" value = "회원탈퇴"/>
				</div>
			</div>
		</form>
	</div>
</div>


	<!-- jQuery -->
	<script src="/dog/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="/dog/js/bootstrap.min.js"></script>