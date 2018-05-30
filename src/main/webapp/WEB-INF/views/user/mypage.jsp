<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />

<section>
	<div class="container">
		<div id="more-features" class="row">
			<div class="col-6">
				<div class="box" data-url="#">
					<p class="bigbutton">회원 정보 수정</p>
				</div>
			</div>
			<div class="col-6">
				<div class="box" data-url="#">
					<p class="bigbutton">내가 쓴 글</p>
				</div>
			</div>
			<div class="col-6">
				<div class="box" data-url="#">
					<p class="bigbutton">비밀번호 변경</p>
				</div>
			</div>
			<div class="col-6">
				<div class="box" data-url="#">
					<p class="bigbutton">내가 쓴 댓글</p>
				</div>
			</div>
			<div class="col-6">
				<div class="box" data-url="#">
					<p class="bigbutton">내 모임</p>
				</div>
			</div>
			<div class="col-6">
				<div id="withdraw" class="box">
					<p class="bigbutton">탈퇴</p>
				</div>
			</div>
		</div>
	</div>
</section>