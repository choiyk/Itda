<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<div class="margin"></div>
	
<section>
	<div class="container text-center">
		<img id="main_logo_img" src="${R}img/favicon.png">
	</div>
</section>

<section>
	<div class="container">
		<p class="text-center">로그인</p>
		<div class="form">
			<form method="post" action="login_processing">
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="text" name="loginId" class="form-control" placeholder="학번">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="password" name="passwd" class="form-control" placeholder="비밀번호">
					</div>
				</div>
				<div class="text-center">
					<button class="btn" type="submit" title="login">로그인</button>
				</div>
			</form>
			<c:if test="${ param.error != null }">
				<div class="mt5">로그인 실패</div>
			</c:if>
		</div>
	</div>
</section>

<div class="margin"></div>
<div class="margin"></div>
<div class="margin"></div>

<section>
	<hr/>
	<p class="text-center"><span class="bar_text" data-url="join">회원가입</span></p>
</section>