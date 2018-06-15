<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<c:url var="R" value="/" />

<section id="content">
	<div class="container">
		<c:if test="${type == 1 }">
			<form:form method="get" modelAttribute="pagination" class="form-inline mb5">
				<form:hidden path="pg" value="1" />
				<form:hidden path="bd" />
				<span>순서:</span>
				<form:select path="ob" class="form-control autosubmit"
							 itemValue="value" itemLabel="label" items="${ orderBy }" /> <form:select path="sb" class="form-control ml30"
																									  itemValue="value" itemLabel="label" items="${ searchBy }" /> <form:input path="st" class="form-control" placeholder="검색문자열" /> <button type="submit" class="btn btn-default">
				<i class="glyphicon glyphicon-search"></i> 검색</button> <c:if test="${ pagination.sb > 0 || pagination.ob > 0}">
				<a class="btn btn-default" href="list?bd=${board.id}&pg=1"> <i class="glyphicon glyphicon-ban-circle"></i> 검색취소</a>
			</c:if>
				<span class="ml30">페이지 크기:</span>
				<form:select path="sz" class="form-control autosubmit">
					<form:option value="10"/><form:option value="15"/><form:option value="30"/> </form:select>
				<div class="pull-right">
					<a class="btn btn-primary" href="create?${pagination.queryString}"> <i class="glyphicon glyphicon-plus"></i> 새글작성</a>
				</div>
			</form:form>

		<div class="row">
			<div class="col-lg-12">
				<p class="pull-right" data-url="${R}article_write?bd=1">공지 쓰기 <i class="ion-android-create"></i></p>
			</div>
		</div>
		</c:if>
		<div id="more-features" class="row">
			<c:if test="${!empty notices }">
				<c:forEach var="notice" items="${notices}">
					<div class="col-lg-12">
						<div class="box" data-url="${R}article?bd=1&at=${notice.id}&{pagination.queryString}">
							<p class="title"><span class="notice">공지</span>${notice.title }</p>
							<p class="description">관리자 / ${notice.date }</p>
						</div>
					</div>
				</c:forEach>
			</c:if>
			
			<c:if test="${!empty meetings }">
			<c:forEach var="meeting" items="${ meetings }">
			<div class="col-lg-12">
				<div class="box" data-url="meeting?id=${meeting.meetingId }">
					<p class="title">${ meeting.meetingName } </p>
					<c:if test="${ meeting.meetingExplain != null }">
						<p class="description">${ meeting.meetingExplain }</p>
					</c:if>
					
					<c:if test="${ meeting.mmType == 3 }">
					<p class="description">모임 관리자: ${meeting.userName} / 개설일: ${ meeting.meetingDate }</p>
					<button class="icon" data-url="meeting_setting?id=${meeting.meetingId }&st=0">관리</button>
					</c:if>
					
					<c:if test="${ meeting.mmType == 2 }">
					<p class="description">${meeting.userName} / 가입일: ${ meeting.mmDate }</p>
					</c:if>
				</div>
			</div>
				<my:pagination pageSize="${pagination.sz}" recordCount="pagination.recordCount" />

			</c:forEach>
			
			</c:if>
			<c:if test="${empty meetings }">
			<div class="col-lg-12">
				<div class="box">
					<p class="title">가입한 모임이 없습니다.</p>
				</div>
			</div>
			</c:if>
		</div>
	</div>
</section>



<section>
	<div class="container">
		<div class="add-icon">
			<i class="ion-ios-plus-outline" data-url="meeting_create"></i>
		</div>
	</div>
</section>

<section id="alarm">
</section>
<!-- 
<section id="alarm">
	<div class="container">
		<p class="title">경스데이 알림!<i id="alarm_close" class="ion-close-round pull-right" data-url="#"></i></p>
		<p class="content">"성공회대학교 소프트웨어공학과 캡스톤 디자인 프로젝트 모임 일정 안내"<br/>새글이 올라왔습니다.</p>
	</div>
</section>
 -->
 <script>
 	var meetings = ${jsonMeetings};
 	console.log(meetings);
 	
 	var sock = new SockJS("${R}itda-webSocket");
 	sock.onopen = function(){
 		console.log("sock \"/itda-webSocket\" Connected");
 		for(var i=0; i<meetings.length; i++){
 			sock.send(JSON.stringify({meetingId: parseInt(meetings[i].meetingId), type: 'JOIN', content: '로그인되었습니다.', meetingName: meetings[i].meetingName}));
 			console.log("sock.send(JSON.stringify({meetingId: "+parseInt(meetings[i].meetingId)+", type: 'JOIN', content: '로그인되었습니다.'', meetingName: "+meetings[i].meetingName+"}));");
 		}
 		
 		sock.onmessage = function(e){
 			var e = JSON.parse(e.data);
 			var meetingName = e.meetingName;
 			var content = e.content;
 			console.log(meetingName+"알림!"+content);
 			var text = '<div class="container">'+
 				'<p class="title">'+meetingName+' 알림!<i id="alarm_close" class="ion-close-round pull-right" data-url="#"></i></p>'+
 				'<p class="content">"'+content+'"<br/>새글이 올라왔습니다.</p></div>';
 			$("#alarm").append(text);
 		}
 	}
 </script>