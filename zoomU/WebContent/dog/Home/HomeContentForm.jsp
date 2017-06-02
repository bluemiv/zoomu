<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE>
<html>
<head>
<title>개인분양 등록 글 보여주기 페이지</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link href="/dog/css/contentForm.css" rel="stylesheet" media="screen">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- 커스텀 CSS -->
<link href="/dog/css/custom-dog.css?ver=1.1" rel="stylesheet">

</head>
<body>
	<!-- 메뉴 상단 -->
	<jsp:include page="/dog/headerMenu.jsp" />

	<br><br><br><br><br><br>
	<div class="container">
		<div class="resume">
			<div class="row" style="margin-right: 500px;">
				<div
					class="col-xs-12 col-sm-12 col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8"
					style="width: 932px;">
					<div class="panel panel-default">

						<div class="panel-heading resume-heading" style="width: 900px;">
							<div class="row">
								<div class="col-lg-12">

									<!-- 이미지 -->
									<div class="col-xs-12 col-sm-4">
										<figure>
											<img class="img-circle img-responsive"
												src="/dog/img/home/${ vo.hphoto }"
												style="width: 250; height: 250;" />
											<br>
										</figure>
									</div>

									<div class="col-xs-12 col-sm-8">
										<ul class="list-group">
											<li class="list-group-item font-hanna font-size-sm">제목 : ${ vo.hpetname }</li>
											<li class="list-group-item font-hanna font-size-sm">작성자 : ${ vo.hid }</li>
											<li class="list-group-item font-hanna font-size-sm">성별 : ${ vo.hgender }</li>
											<li class="list-group-item font-hanna font-size-sm">종류 : ${ vo.htype }</li>
											<li class="list-group-item font-hanna font-size-sm">분양유무 : ${ vo.hyn }</li>
										</ul>
									</div>

								</div>
							</div>
						</div>

						<div class="bs-callout bs-callout-danger">
							<h4 class = "font-nanum font-size-md">특징</h4>
							<p class = "font-hanna font-size-sm">특징 : ${ vo.hetc }</p>
						</div>
					</div>
					<c:if test="${ sessionScope.id != null }">
						<!-- 댓글 -->
		                <div class="well">
		                    <h4 class = "font-nanum font-size-md">댓글 쓰기</h4>
		                    <form action = "homeReplyPro.do" method = "post" >
		                    	<input type="hidden" value="${ requestScope.vo.hnum }" name="hnum">
		                        <div class="form-group">
		                            <textarea class="form-control" name="content" rows="3"></textarea>
		                        </div>	
		                        <button type="submit" class="btn btn_c">등록</button>
		                    </form>
		                </div>
					</c:if>
		                <hr>
			
						<c:forEach var = "re_var" items = "${  requestScope.re_list }">
			                <!-- 댓글내용 -->
			                <div class="media">
			                    <div class="media-body">
			                        <h4 class="media-heading">${ re_var.id } <!-- 글쓴이 -->
			                            <small>${ re_var.rdate }</small> <!-- 시간 -->
			                        </h4>
			                        <!-- 댓글 내용 -->
			                        ${ re_var.content }
			                    </div>
			                </div>
		                </c:forEach>
						<hr/>
				</div>
			</div>
		</div>
	</div>

		<div align="center">
			<c:if test="${ sessionScope.id != null }">
				<c:if test="${checkid==true }">
					<input type="button" value="글 수정" class="btn btn_c btn-default"
					onclick="javascript:window.location='HomeupdateForm.do?hnum=${vo.hnum}'" />
				
				<%-- <input type="button" value="글 삭제" class="btn btn_c btn-default"
					onclick="javascript:window.location='HomedeleteForm.do?hnum=${vo.hnum}'" /> --%>
				<a data-toggle="modal" data-target="#homeDelete" class="btn btn_c btn-default">글 삭제</a>
				</c:if>
			</c:if>
			<c:if test="${ sessionScope.id == null }">
				<h4>로그인을 해야 글을 수정 및 삭제 할 수 있습니다.</h4>
			</c:if>
			<input type="button" value="목록보기" class="btn btn_c btn-default"
				onclick="javascript:window.location='HomelistForm.do'" />
		</div>
		<br />
		<c:out value="${hnum}"></c:out>
		<br>		
<!-- 글삭제 -->
<div class="modal fade" id="homeDelete" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">경고</h4>
				<p>글을 삭제 하시겠습니까?</p>
			</div>
			<form action="HomedeleteForm.do" method="post" >
				<input type="hidden" value="${requestScope.vo.hnum}" name = "hnum"/>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<input type="submit" class="btn btn-primary" value = "글삭제"/>
				</div>
			</div>
		</form>
	</div>
</div>

</body>
</html>