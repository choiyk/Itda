<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />

<header id="header">
	<div class="container menu">
		<div id="logo">
			<h1 data-url="main">Itda</h1>
		</div>
		<div id="myInf" >
			<div class="myInf_icon" data-url="mypage"><sec:authentication property="user.firstChar"/></div>
			<p class="myInf_text" data-url="mypage"><sec:authentication property="user.name"/></p>
		</div>
	</div>
</header>

<div class="margin"></div>

<section id="content">
	<div class="text-center">메뉴 이름</div>
</section>
