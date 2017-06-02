<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<title>SOS 게시판	</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- 페이지 설정 -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
	<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<!-- 커스텀 CSS -->
	<link href="/dog/css/custom-dog.css?ver=1.1" rel="stylesheet">
	<link href="/dog/css/mang_css.css?ver=1.1" rel="stylesheet">
</head>
<body>
<!-- 헤더 -->
<jsp:include page="/dog/headerMenu.jsp"/>
<br><br><br><br>
	<!-- 본문 -->
	<div class="container">
		<h2 class = "font-nanum font-size-lg">
			SOS 게시판
		</h2>
		<p class = "font-hanna font-size-sm">학대 받고있는 강아지를 구해주세요!</p>
		<p class="right">
			<!-- 로그인을 했을때만 글쓰기 사용 가능 -->
			<c:if test="${ sessionScope.id != null }">
					<button type="button" class="btn btn_c btn-info"
						onclick="window.location='sosWriteForm.do'">글쓰기</button>
			</c:if>
			<c:if test="${ sessionScope.id == null }">
				글쓰기는 <a data-toggle="modal" data-target="#myModal">로그인</a> 후 사용 가능 합니다.<br/>
				혹시 회원이 아니시면 
				<a href="#" onclick="window.open('memberEmailForm.do', '회원가입', 'width=300, height=250')">회원가입</a>
				을 해주세요!
			</c:if>
		</p>
		
		<!-- 게시판 출력 -->
		<c:if test="${ requestScope.list == null }"><!-- 게시물이 없다 -->
			<table class="table table-hover">
				<thead>
					<tr class = "font-nanum font-size-sm">
						<th width="10%">No.</th>
						<th width="40%">제목</th>
						<th width="20%">글쓴시간</th>
						<th width="20%">글쓴이</th>
						<th width="20%">조회수</th>
				</thead>
				<tbody class = "font-nanum font-size-md">
					<td align="center" colspan="3">게시판에 저장된 글이 없습니다</td>
				</tbody>
			</table>
		</c:if>
		<c:if test="${ requestScope.list != null }"><!-- 게시물이 있다 -->
			<table class="table table-hover">
				<thead class = "font-nanum font-size-sm">
					<tr>
						<th width="10%">No.</th>
						<th width="40%">제목</th>
						<th width="20%">글쓴시간</th>
						<th width="20%">글쓴이</th>
						<th width="20%">조회수</th>
					</tr>
				</thead>
				<tbody class = "font-nanum font-size-menu">
					<c:set var="countNum" value="${ 1 }"/> <!-- 장식 : 외부 글번호 -->
					<c:forEach var="var" items="${ requestScope.list }">
					
						<tr>
							<td>${ countNum }</td>
							<td>
								<a href="sosContentForm.do?countNum=${ countNum }&snum=${var.snum}&checkCount=${ 1 }">
									${ var.stitle }<font color="blue"> [${ var.recount }] </font>
								</a>
							</td>
							<td>${ var.sdate }</td>
							<td>${ var.swriter }</td>
							<td>${ var.scount }</td>
						</tr>
						<c:set var="countNum" value="${ countNum + 1 }" />
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<!-- 하단 버튼 -->
		<div align ="center">
			<p>글 목록(전체 글 : ${count})</p>
			<c:forEach var="i" begin="1" end="${cvo.getTotalPage() }">
				<a href="sosListForm.do?curPage=${i}"><c:out value="[${i}]"/></a>
			</c:forEach>
		</div>
		
		<br/>
		<form action = "sosListForm.do" method = "post" class="navbar-form navbar-right">
			<div class="form-group">
				<input type="text" name = "search" class="form-control" placeholder="게시글 리스트 검색">
			</div>
			<button type="submit" class="btn btn_c btn-default">검색</button>
		</form>
			
	</div>	<!-- 게시물 끝 -->
	
	<!-- Footer -->
	<footer class="container-fluid text-center">
		<h2 class = "color-gry">ZoomU</h2>
	</footer>
</body>
</html>