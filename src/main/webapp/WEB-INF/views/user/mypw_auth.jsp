<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />

<div class="margin"></div>
<div class="margin"></div>

<section id="content">
	<div class="container">
		<p class="text-center">비밀번호 확인</p>
		<div class="form">
			<form>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="password" class="form-control" placeholder="비밀번호">
					</div>
				</div>
				<div class="text-center">
					<button class="btn" type="submit" title="login">확인</button>
				</div>
			</form>
		</div>
	</div>
</section>