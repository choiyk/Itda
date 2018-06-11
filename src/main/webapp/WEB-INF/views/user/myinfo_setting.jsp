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
		<p class="text-center">내 정보 수정</p>
		<div class="form">
			<form:form method="post" modelAttribute="userModificationModel">
				<div class="form-row">
					<div class="form-group center col-lg-8">
					
						<label for="studentNumber">학번</label>
						<form:input path="studentNumber" type="text" name="studentNumber" class="form-control" readonly="true"/>						
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<label for="name">이름</label>
						<form:input path="name" type="text" name="name" class="form-control" readonly="true"/>
					</div>
				</div>
				
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<label for="nickname">닉네임</label>
						<form:input path="nickname" type="text" name="nickname" class="form-control" placeholder="닉네임" />
						<form:errors path="nickname" class="error"/>
					</div>
				</div>
				
				<div class="form-row">
					<div class="form-group center col-lg-8">
							<label for="gender">성별</label>
							
								<c:if test="${ userModificationModel.gender == 1 }">
									<input name="gender" type="text" class="form-control" id="female" placeholder="여성" readonly="true">
								</c:if>
								<c:if test="${userModificationModel.gender == 2 }">
									<input name="gender" type="text" class="form-control" id="male" placeholder="남성" readonly="true">
								</c:if>
					</div>
				</div>
				
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<label for="departments">학과</label>
						<form:select path="departmentId" class="form-control" 
							itemValue="id" itemLabel="departmentName" items="${departments }" />
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<label for="question">비밀번호 질문</label>
						<select class="form-control" name="question">
							<option value="1">가장 기억에 남는 장소는?</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<label for="answer">비밀번호 답변</label>
						<form:input path="answer" type="text" name="answer" class="form-control" placeholder="답변"/>
						<form:errors path="answer" class="error"/>
					</div>
				</div>
				<div class="text-center" data-url="${R}mypage">
					<button class="btn" type="submit">저장</button>
				</div>
			</form:form>
		</div>
	</div>
</section>