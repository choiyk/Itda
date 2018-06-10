<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />

<header id="header">
	<div class="container menu">
		<div id="logo" data-url="${R}main">
			<h1>Itda</h1>
		</div>
		<div id="myInf" >
			<div class="myInf_icon" data-url="${R}mypage"><sec:authentication property="user.firstChar"/></div>
			<p class="myInf_text" data-url="${R}mypage"><sec:authentication property="user.name"/></p>
		</div>
		<div id="myInf" >
			<p class="myInf_text" data-url="${R}user/logout_processing">로그아웃</p>
		</div>
	</div>
</header>

<div class="margin"></div>

<section id="content">
	<div class="text-center">메뉴 이름</div>
</section>
