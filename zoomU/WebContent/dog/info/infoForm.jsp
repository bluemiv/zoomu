<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE>
<html>
<head>
<title>ZoomU 소개</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
	<link href="/dog/css/bootstrap.min.css?ver=1.1" rel="stylesheet">
	<!-- 커스텀 CSS -->
	<link href="/dog/css/custom-dog.css?ver=1.1" rel="stylesheet">
	<!-- 후원루트관련, 후원 방법 -->
	<link href="/dog/css/junho_css.css?ver=1.1" rel="stylesheet">
	<link href="/dog/fonts/custom_font.css?ver=1.1" rel="stylesheet">
	
</head>

<body>

	<jsp:include page="/dog/headerMenu.jsp"></jsp:include>
	<br><br><br><br><br><br>
<h3 class = "font-nanum font-size-lg">ZoomU 목적</h3>
<hr/>

<div class = "row">
	<div class = "col-lg-1"></div>
	<div class = "col-lg-5">
		<div class="youtubeWrap">
			<iframe src="https://www.youtube.com/embed/5KyN3yroLSs" frameborder="1"></iframe>
		</div>
	</div>
	<div class = "col-lg-6 font-nanum font-size-md">
		유기견을 따뜻한 마음으로 끝까지 책임져주세요<br/>
		반려동물을 제품으로 생각하지 말고 가족으로 생각해주세요.<br/>
		당신의 입양으로 인해<br/>한 생명의 세상이 달라질거에요
	</div>
</div>


<h3 class = "font-nanum font-size-lg">후원 경로</h3>
<hr>
<div class="container">	
	<div class="row">
		<section>
        <div class="wizard">
            
            <div class="wizard-inner">
                <div class="connecting-line"></div>
                <ul class="nav nav-tabs" role="tablist">

						<li role="presentation" class="active">
						<a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="Step 1"> 
							<span class="round-tab"> 
								<img src="/dog/icon/dog.png" class = "icon-size">
							</span>
						</a>
						</li>

						<li role="presentation" class="disabled">
						<a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Step 2"> 
							<span class="round-tab"> 
								<img src="/dog/icon/dog.png" class = "icon-size">
							</span>
						</a>
						</li>

						<li role="presentation" class="disabled">
						<a href="#step3" data-toggle="tab" aria-controls="step3" role="tab" title="Step 3"> 
							<span class="round-tab"> 
								<img src="/dog/icon/dog.png" class = "icon-size">
							</span>
						</a>
						</li>
						
						<li role="presentation" class="disabled">
						<a href="#complete" data-toggle="tab" aria-controls="complete" role="tab" title="Complete"> 
							<span class="round-tab"> 
								<img src="/dog/icon/dog.png" class = "icon-size">
							</span>
						</a>
						</li>
					</ul>
           		</div>
           		
           		
           <form action = "adPro.do" method = "post" role="form">
               <div class="tab-content">
                   <div class="tab-pane active" role="tabpanel" id="step1">
                       <h3 class = "font-nanum font-size-lg">후원해주세요</h3>
                       <p class = "font-jeju font-size-sm">불쌍한 강아지를 도와주세요! 당신의 따뜻한 관심을 원합니다.</p>
                       <ul class="list-inline pull-right">
                           <li><button type="button" class="btn btn-primary next-step">후원 하기</button></li>
                       </ul>
                   </div>
                   <div class="tab-pane" role="tabpanel" id="step2">
                       <h3 class = "font-nanum font-size-lg">꼭 읽어주세요</h3>
                       <p class = "font-jeju font-size-sm">ZoomU 는 비영리 단체로서, 후원금액의 30%는 오직 ZoomU 의 유지관리를 위해 사용됩니다.<br/>
                        	나머지 70% 의 금액은 유기견을 위해 사용됩니다.<br/>
                        	자세한 내용이 궁금하시면 <a href = "#info">
                        	후원안내 </a>를 눌러주세요.
                       </p>
                       <ul class="list-inline pull-right">
                           <li><button type="button" class="btn btn-default prev-step">이전 단계</button></li>
                           <li><button type="button" class="btn btn-primary next-step">후원 하기</button></li>
                       </ul>
                   </div>
                   <div class="tab-pane" role="tabpanel" id="step3">
                       <h3 class = "font-nanum font-size-lg">정보 입력</h3>
                       <p class = "font-jeju font-size-sm">정보를 입력해주세요</p>
                       <p>
                        <div class = "row">
	                       <div class = "col-lg-2">
	                       </div>
	                       <div class = "col-lg-4">
	                        	기업 이름 : <input type = "text" name = "aEnterName"
	                        	required = "required" class="form-control" placeholder = "기업 이름"/>
	                        	후원 금액 : <input type = "text" name = "aMoney"
	                        	required = "required" class="form-control" placeholder = "후원 금액"/>
	                        </div>
	                        <div class = "col-lg-6">
	                       </div>
                       	</div>
                       </p>
                       <ul class="list-inline pull-right">
                           <li><button type="button" class="btn btn-default prev-step">이전 단계</button></li>
                           <li><button type="button" class="btn btn-primary btn-info-full next-step">후원 하기</button></li>
                       </ul>
                   </div>
                   <div class="tab-pane" role="tabpanel" id="complete">
                  		<h3 class = "font-nanum font-size-lg">후원 완료</h3>
                       	<p class = "font-jeju font-size-sm">당신의 따뜻한 마음에 감사드리며, 정말로 후원을 원하시면 후원하기를 눌러주세요!</p>
                      		<div class = "row">
	                       <div class = "col-lg-2">
	                       </div>
	                       <div class = "col-lg-4">
	                        	남기고싶은말 : <textarea name = "aEtc" rows="10" required = "required"
	                        	class="form-control" placeholder = "남기고 싶은말"></textarea>
	                        </div>
	                        <div class = "col-lg-6">
	                       </div>
                       	</div>
						<ul class="list-inline pull-right">
							<li><input type="submit" value = "후원하기"
	                           class="btn btn-primary btn-info-full"/></li>
                        </ul>
                   	</div>
                   <div class="clearfix"></div>
               </div>
            </form>							
		</div>
    </section>
   </div>                
</div>

<h3 class = "font-nanum font-size-lg">후원 안내</h3>
<hr>


<div class="container" id = "info">
    <ul class="timeline">
        <li>
          <div class="timeline-badge"><span class="glyphicon glyphicon-pencil"></span></div>
          <div class="timeline-panel">
            <div class="timeline-heading">
              <h4 class="timeline-title font-nanum font-size-md">정기봉사활동 </h4>
            </div>
            <div class="timeline-body">
              <p class = "font-jeju font-size-sm">청소, 미용, 산책, 급식 등 모든 활동을 정기적으로 봉사하는 활동 입니다.<br> 
              	각 유기견 보호소에서는 정기봉사활동자를 모집하고 있습니다. 많은 참여 부탁드립니다. 
              </p>
            </div>
          </div>
        </li>
        
        <li>
          <div class="timeline-badge"><span class="glyphicon glyphicon-pencil"></span></div>
          <div class="timeline-panel">
            <div class="timeline-heading">
              <h4 class="timeline-title font-nanum font-size-md">후원품 기부</h4>
            </div>
            <div class="timeline-body">
              <p class = "font-jeju font-size-sm">후원품이란, 반려견이 사용한 물품들이 필요없거나,<br>
              	 지금은 사용하고 있지 않는 물품을 유기견 센터로 보내주시면 유기견 친구들이 따뜻하게 잘 사용할 수 있습니다. 
              </p>
            </div>
          </div>
        </li>
        
        <li>
          <div class="timeline-badge"><span class="glyphicon glyphicon-pencil"></span></div>
          <div class="timeline-panel">
            <div class="timeline-heading">
              <h4 class="timeline-title font-nanum font-size-md">임보/대모</h4>
            </div>
            <div class="timeline-body">
              <p class = "font-jeju font-size-sm">
              	▷임보(임시보호)최소 일주일~10일 정도 보호 해주는 것을 말합니다.<br>
              	데리고 있는 동안 아프거나,다칠경우 개인비용으로 책임을 주셔야 하기때문에 신중하게 생각해서 결정해주세요.<br><br>
              	▷대모(대리모) 유기견보호소에서 마음에드는 아이에게 특정 후원금을 지급하거나,<br> 
              	일주일에 1,2번씩 찾아가서 밥도주고, 산책도 같이나가고, 병원도 같이가서 검진도 받아주는 것을 말합니다.<br>
              	집으로 데려오지 못하지만 마음에 드는 아이가 있다면 대모 활동을 신청해주세요.
              </p>
            </div>
          </div>
        </li>
        
        <li>
          <div class="timeline-badge"><span class="glyphicon glyphicon-pencil"></span></div>
          <div class="timeline-panel">
            <div class="timeline-heading">
              <h4 class="timeline-title font-nanum font-size-md">기업/단체 사회공헌</h4>
            </div>
            <div class="timeline-body">
              <p class = "font-jeju font-size-sm">유기견에 대해 안타까운 마음이 있지만 일때문에 바쁘고 들릴 시간도 없을때, 
              	후원금을 기부하여 유기견 보호소에 도움을 주실 수 있습니다.</p>
            </div>
          </div>
        </li>
    </ul>
</div>

	<!-- 후원루트관련  -->
	<script type="text/javascript">
		$(document).ready(function() {
			//Initialize tooltips
			$('.nav-tabs > li a[title]').tooltip();

			//Wizard
			$('a[data-toggle="tab"]').on('show.bs.tab', function(e) {

				var $target = $(e.target);

				if ($target.parent().hasClass('disabled')) {
					return false;
				}
			});

			$(".next-step").click(function(e) {

				var $active = $('.wizard .nav-tabs li.active');
				$active.next().removeClass('disabled');
				nextTab($active);

			});
			$(".prev-step").click(function(e) {

				var $active = $('.wizard .nav-tabs li.active');
				prevTab($active);

			});
		});

		function nextTab(elem) {
			$(elem).next().find('a[data-toggle="tab"]').click();
		}
		function prevTab(elem) {
			$(elem).prev().find('a[data-toggle="tab"]').click();
		}
		
		// 스크롤 애니메이션
		$(function() {
			$(
			'a[href*=#]:not([href=#],[data-toggle],[data-target],[data-slide])')
			.click(
				function() {
					if (location.pathname.replace(/^\//, '') == this.pathname
							.replace(/^\//, '')
							|| location.hostname == this.hostname) {
						var target = $(this.hash);
						target = target.length ? target
								: $('[name=' + this.hash.slice(1)
										+ ']');
						if (target.length) {
							$('html,body').animate({
								scrollTop : target.offset().top
							}, 1000);
							return false;
						}
					}
				});
		});
		var fixed = false;
		$(document).scroll(function() {
			if ($(this).scrollTop() > 250) {
				if (!fixed) {
					fixed = true;
					// $('#to-top').css({position:'fixed', display:'block'});
					$('#to-top').show("slow", function() {
						$('#to-top').css({
							position : 'fixed',
							display : 'block'
						});
					});
				}
			} else {
				if (fixed) {
					fixed = false;
					$('#to-top').hide("slow", function() {
						$('#to-top').css({
							display : 'none'
						});
					});
				}
			}
		});
	</script>

</body>
</html>