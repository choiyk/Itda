<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="R" value="/" />

<section id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<p class="pull-right">공지 쓰기 <i class="ion-android-create"></i></p>
			</div>
		</div>
		<div id="more-features" class="row">
			<div class="col-lg-12">
				<div class="box" data-url="#">
					<p class="title"><span class="notice">공지</span>Welcome! Itda</p>
					<p class="description">관리자 / 2018.05.29 19:12</p>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="box" data-url="#">
					<p class="title">성공회대학교 소프트웨어공학과 캡스톤 디자인 프로젝트 모임</p>
					<p class="description">모임 관리자: 최윤경 / 개설일: 2018.05.23</p>
					<button class="icon" data-url="#">관리</button>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="box">
					<p class="title">성공회대학교 소프트웨어공학과 캡스톤 디자인 프로젝트 모임</p>
					<p class="description">최윤경</p>
				</div>
			</div>
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
	<div class="container">
		<p class="title">경스데이 알림!<i id="alarm_close" class="ion-close-round pull-right" data-url="#"></i></p>
		<p class="content">"성공회대학교 소프트웨어공학과 캡스톤 디자인 프로젝트 모임 일정 안내"<br/>새글이 올라왔습니다.</p>
	</div>
</section>