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
		<p class="text-center">비밀번호 찾기</p>
		<div class="form">
			<form:form method="post" modelAttribute="findPwModel">
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<form:input path="studentNumber" type="text" name="studentNumber" class="form-control" placeholder="가입한 학번을 입력하세요"/>
						<form:errors path="studentNumber" class="error"/>
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
						<form:input path="answer" type="text" name="answer" class="form-control" placeholder="답변"/>
						<form:errors path="answer" class="error"/>
					</div>
				</div>
				<div class="text-center">
					<button class="btn" type="submit">저장</button>
				</div>
			</form:form>
		</div>
	</div>
</section>