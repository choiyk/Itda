<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="R" value="/" />

<section id="content">
	<div class="container">
		<c:if test="${type == 1 }">
		<div class="row">
			<div class="col-lg-12" data-url="#">
				<p class="pull-right">공지 쓰기 <i class="ion-android-create"></i></p>
			</div>			
		</div>
		</c:if>
		<div id="more-features" class="row">
			<div class="col-lg-12">
				<div class="box" data-url="#">
					<p class="title"><span class="notice">공지</span>Welcome! Itda</p>
					<p class="description">관리자 / 2018.05.29 19:12</p>
				</div>
			</div>
			
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
					<button class="icon" data-url="#">관리</button>
					</c:if>
					
					<c:if test="${ meeting.mmType == 2 }">
					<p class="description">${meeting.userName} / 가입일: ${ meeting.mmDate }</p>
					</c:if>
				</div>
			</div>
			</c:forEach>
			
			</c:if>
			<c:if test="${empty meetings }">
			<div class="col-lg-12">
				<div class="box" data-url="#">
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
<!-- 
<section id="alarm">
	<div class="container">
		<p class="title">경스데이 알림!<i id="alarm_close" class="ion-close-round pull-right" data-url="#"></i></p>
		<p class="content">"성공회대학교 소프트웨어공학과 캡스톤 디자인 프로젝트 모임 일정 안내"<br/>새글이 올라왔습니다.</p>
	</div>
</section>
 -->