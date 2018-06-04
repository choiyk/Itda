<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
			<form:form method="post" modelAttribute="userRegistrationModel">
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<form:input path="studentNumber" type="text" name="studentNumber" class="form-control" placeholder="학번"/>
						<form:errors path="studentNumber" class="error"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<form:input path="password1" name="password1" type="password" class="form-control" placeholder="비밀번호"/>
						<form:errors path="password1" class="error"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<form:input path="password2" name="password2" type="password" class="form-control" placeholder="비밀번호 확인"/>
						<form:errors path="password2" class="error"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<form:input path="name" type="text" name="name" class="form-control" placeholder="이름"/>
						<form:errors path="name" class="error"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<form:input path="nickname" type="text" name="nickname" class="form-control" placeholder="닉네임"/>
						<form:errors path="nickname" class="error"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<form:input path="gender" type="number" name="gender" class="form-control" placeholder="성별"/>
						<form:errors path="gender" class="error"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<form:select path="departmentId" class="form-control" 
							itemValue="id" itemLabel="departmentName" items="${departments }" />
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
					<button class="btn" type="submit">회원가입</button>
				</div>
			</form:form>
		</div>
	</div>
</section>
	
