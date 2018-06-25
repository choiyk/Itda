<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />

<section id="content">
	<div class="container">
		<div id="more-features" class="row">
			<c:if test="${!empty myMeetings }">
			<c:forEach var="myMeeting" items="${ myMeetings }">
			<div class="col-lg-12">
				<div class="box" data-url="meeting?id=${myMeeting.meetingId }">
					<p class="title">${myMeeting.meetingName }</p>
					<p class="description">개설일: ${myMeeting.meetingDate }</p>
					<button class="icon" data-url="meeting_setting?id=${myMeeting.meetingId}&st=0">관리</button>
				</div>
			</div>
			</c:forEach>
			</c:if>
			<c:if test="${empty myMeetings }">
			<div class="col-lg-12">
				<div class="box">
					<p class="title">개설한 모임이 없습니다.</p>
				</div>
			</div>
			</c:if>
		</div>
	</div>
</section>