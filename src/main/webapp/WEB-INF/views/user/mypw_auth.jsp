<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style> .error {color:red;} </style>
<c:url var="R" value="/" />

<div class="margin"></div>
<div class="margin"></div>

<section id="content">
	<div class="container">
		<p class="text-center">비밀번호 확인</p>
		<div class="form">
			<form:form method="post" modelAttribute="userPasswordCheckModel">
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<form:input path="password" name="password" type="password" class="form-control" placeholder="비밀번호 확인"/>
						<form:errors path="password" class="error"/>
					</div>
				</div>
				<div class="text-center">
					<button class="btn" type="submit" data-url="${R}mypw_setting" >확인</button>
				</div>
			</form:form>
		</div>
	</div>
</section>