<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %> 
 
<!DOCTYPE html>
<html>
<head>
	<title>SOS-${ requestScope.vo.stitle }</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- 페이지 설정 -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
	<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<!-- 커스텀 CSS -->
	<link href="/dog/css/contentForm.css" rel="stylesheet" media="screen">
	<link href="/dog/css/custom-dog.css?ver=1.1" rel="stylesheet">
	<link href="/dog/css/mang_css.css?ver=1.1" rel="stylesheet">
</head>
<body>
	<!-- 메뉴 상단 -->
	<jsp:include page="/dog/headerMenu.jsp"/>
	<br><br><br><br><br><br>
	    <!-- 페이지 내용 -->
    <div class="container">
        <div class="row">
			<!-- 컨텐트 목록 -->
            <div class="col-lg-8">
                <!-- 제목 -->
                <h1 class = "font-nanum font-size-lg">${ countNum }번 글 :  ${ requestScope.vo.stitle }</h1>

                <!-- 작성자 -->
                <p class="lead font-nanum font-size-md">
                    by ${ requestScope.vo.swriter }
                </p>

				<p class = "font-nanum font-size-md"> 조회수:  ${ requestScope.vo.scount }</p>

                <hr>
                <!-- 글쓴 날짜-->
                <p><span class="glyphicon glyphicon-time"></span>
                <span class="lead font-nanum font-size-sm"> ${ requestScope.vo.sdate }</span></p>

                <hr>

                <!-- 광고 그림 넣을까? 
                <img class="img-responsive" src="" alt="그림 오류">
                <hr>-->

                <!-- 글 내용 -->
                <!-- 큰 글씨 -->
                <p class="lead lead font-nanum font-size-md"><strong>신고지역</strong></p>
                <!-- 작은 글씨 -->
                <p class = "font-hanna font-size-sm">${ requestScope.vo.sarea }</p>
                <br/>
                <p class="lead lead font-nanum font-size-md"><strong>제보자 연락처</strong></p>
                <p class = "font-hanna font-size-sm">${ requestScope.vo.stell }</p>
                <br/>
                <p class="lead lead font-nanum font-size-md"><strong>특이 사항</strong></p>
				<c:if test="${ requestScope.vo.setc == null }">
					<p class = "font-hanna font-size-sm">내용 없음</p>
				</c:if>
				<c:if test="${ requestScope.vo.setc != null }">
					<p class = "font-hanna font-size-sm">${ requestScope.vo.setc }</p>
				</c:if>

				<%-- <input type="button" value="글삭제" class = "btn btn_c"
				onclick="window.location='sosDeletePro.do?snum=${ requestScope.vo.snum }' " > --%>
				<a data-toggle="modal" data-target="#sosDelete" class="btn btn_c btn-default">글 삭제</a>
				<input type="button" value="글수정" class = "btn btn_c"
				onclick="document.location.href='sosUpdateForm.do?snum=${ vo.snum }' ">
				<input type="button" value="목록보기" class = "btn btn_c"
				onclick="document.location.href='sosListForm.do' ">
                <hr>
                <c:if test="${ sessionScope.id != null }">
	                <!-- 댓글 -->
	                <div class="well">
	                    <h4>댓글 쓰기</h4>
	                    <form action = "sosReplyPro.do" method = "post" >
	                    	<input type="hidden" value="${ requestScope.vo.snum }" name="snum">
	                    	<input type="hidden" value="${ requestScope.countNum }" name="countNum">
	                    	<input type="hidden" value="${ 0 }" name="checkCount">
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
	                            <c:if test="${ re_var.id == sessionScope.id }">
	                            	<a href = "sosReplyDelete.do?id=${ re_var.id }&rdate=${ re_var.rdate }">
	                            	x</a>
	                            </c:if>
	                        </h4>
	                        <!-- 댓글 내용 -->
	                        ${ re_var.content }
	                    </div>
	                </div>
                </c:forEach>
            </div>

            <!-- 페이지 우측 사이바  -->
            <div class="col-md-4">

            </div>

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; ZoomU 2017</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>
    </div>

<!-- 글삭제 -->
<div class="modal fade" id="sosDelete" tabindex="-1" role="dialog"
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
			<form action="sosDeletePro.do" method="post" >
				<input type="hidden" value="${requestScope.vo.snum}" name = "snum"/>
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