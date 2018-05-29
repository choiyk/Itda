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
		<p class="text-center">회원가입</p>
		<div class="form">
			<form>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="text" name="studentNumber" class="form-control" placeholder="학번">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input name="password" type="password" class="form-control" placeholder="비밀번호">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input name="password2" type="password" class="form-control" placeholder="비밀번호 확인">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="text" name="name" class="form-control" placeholder="이름">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="text" name="nickname" class="form-control" placeholder="닉네임">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<select class="form-control" name="department">
							<option value="sw">소프트웨어공학과</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<select class="form-control" name="question">
							<option value="1">가장 기억에 남는 장소는?</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="text" name="answer" class="form-control" placeholder="답변">
					</div>
				</div>
				<div class="text-center">
					<button class="btn" type="submit" title="join">회원가입</button>
				</div>
			</form>
		</div>
	</div>
</section>
	
