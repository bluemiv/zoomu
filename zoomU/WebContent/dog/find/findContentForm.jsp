<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>${ requestScope.vo.fPetName }</title>
	<!-- 부트스트랩 -->
	<link href="/dog/css/bootstrap.min.css?ver=1.1" rel="stylesheet">
	<!-- 커스텀 CSS -->
	<link href="/dog/css/contentForm.css" rel="stylesheet" media="screen">
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
												src="/dog/img/find/${ requestScope.vo.fPhoto }"
												style="width: 250; height: 250;" />
											<br />
										</figure>
									</div>

									<div class="col-xs-12 col-sm-8">
										<ul class="list-group">
											<li class="list-group-item font-hanna font-size-sm">강아지 이름 : ${ requestScope.vo.fPetName }</li>
											<li class="list-group-item font-hanna font-size-sm">강아지 종류 : ${ requestScope.vo.fType }</li>
											<li class="list-group-item font-hanna font-size-sm">강아지 성별 : ${ requestScope.vo.fGender }</li>
											<li class="list-group-item font-hanna font-size-sm">잃어버린 날짜 : ${ requestScope.vo.fDate }</li>
											<li class="list-group-item font-hanna font-size-sm">잃어버린 지역 : ${ requestScope.vo.fArea }</li>
											<li class="list-group-item font-hanna font-size-sm">연락처 : ${ requestScope.vo.fTel }</li>
										</ul>
									</div>

								</div>
							</div>
						</div>

						<div class="bs-callout bs-callout-danger">
							<h4 class = "font-nanum font-size-md">특징</h4>
							<p class = "font-hanna font-size-sm">기타 특이사항 : ${ requestScope.vo.fEtc }</p>
						</div>
					</div>
					<c:if test="${ sessionScope.id != null }">
					<!-- 댓글 -->
	                <div class="well">
	                    <h4 class = "font-nanum font-size-md">댓글 쓰기</h4>
	                    <form action = "findReplyPro.do" method = "post" >
	                    	<input type="hidden" value="${ requestScope.vo.fNum }" name="fNum">
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
				</div>
			</div>
		</div>
	</div>
	<div align="center">
		<c:if test="${ sessionScope.id != null }">
			<%-- <input type="button" value="글 삭제" class="btn btn_c btn-default"
				onclick="javascript:window.location='findDeletePro.do?fNum=${requestScope.vo.fNum}'"> --%>
			<a data-toggle="modal" data-target="#findDelete" class="btn btn_c btn-default">글 삭제</a>
			<input type="button" value="글 수정" class="btn btn_c btn-default"
				onclick="javascript:window.location='findUpdateForm.do?fNum=${requestScope.vo.fNum}'">
		</c:if>
		<c:if test="${ sessionScope.id == null }">
			<h4>로그인을 해야 글을 수정 및 삭제 할 수 있습니다.</h4>
		</c:if>
		<input type="button" value="목록보기" class="btn btn_c btn-default"
			onclick="javascript:window.location='findListForm.do'">
	</div>
	<br/><br/><br/><br/><br/><br/><br/>
	<c:out value="${fnum}"></c:out>
	<br>
	
<!-- 글삭제 -->
<div class="modal fade" id="findDelete" tabindex="-1" role="dialog"
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
			<form action="findDeletePro.do" method="post" >
				<input type="hidden" value="${requestScope.vo.fNum}" name = "fNum"/>
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