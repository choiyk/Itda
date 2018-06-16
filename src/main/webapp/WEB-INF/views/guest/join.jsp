<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<style> .error {color:red;} </style>

<div class="margin"></div>

<section>
	<div class="container text-center">
		<img id="main_logo_img" src="${R}img/logo2-1.png" data-url="${R}guest/login">
	</div>
</section>

<section>
	<div class="container">
		<p class="text-center">회원가입</p>
		<div class="form">
			<form:form method="post" modelAttribute="userRegistrationModel">
				<div class="form-row">
					<div class="col-8 center">
						<div class="form-group">
							<form:input path="studentNumber" type="text" name="studentNumber" class="form-control" placeholder="학번"/>
							<form:errors path="studentNumber" class="error"/>
						</div>
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
						<p class="sub">*실명 사용을 원하지 않을 경우 닉네임을 입력해주세요.</p>
						<form:errors path="nickname" class="error"/>
					</div>
				</div>
				<%-- <div class="form-row">
					<div class="form-group center col-lg-8">
						<form:input path="gender" type="number" name="gender" class="form-control" placeholder="성별"/>
						<form:errors path="gender" class="error"/>
					</div>
				</div> --%>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<div class="form-inline form-control col-12">
							<div class="col-4 form-group">
								<label>성별</label>
							</div>
							<div class="col-4 form-group">
								<input type="radio" name="gender" id="female" value="1" checked="checked"/>
								<label for="female">여성</label>
							</div>
							<div class="col-4 form-group">
								<input type="radio" name="gender" id="male" value="2"/>
								<label for="male">남성</label>
							</div>
						</div>
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
			
			<!-- <form>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="text" name="studentNumber" class="form-control" placeholder="학번"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input name="password1" type="password" class="form-control" placeholder="비밀번호"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input name="password2" type="password" class="form-control" placeholder="비밀번호 확인"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="text" name="name" class="form-control" placeholder="이름"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="text" name="nickname" class="form-control" placeholder="닉네임"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<div class="form-inline form-control col-12">
							<div class="col-4 form-group">
								<label>성별</label>
							</div>
							<div class="col-4 form-group">
								<input type="radio" name="gender" id="female" value="1"/>
								<label for="female">여성</label>
							</div>
							<div class="col-4 form-group">
								<input type="radio" name="gender" id="male" value="2"/>
								<label for="male">여성</label>
							</div>
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<select class="form-control" name="department">
							<option value="1">소프트웨어공학과</option>
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
						<input type="text" name="answer" class="form-control" placeholder="답변"/>
					</div>
				</div>
				<div class="text-center">
					<button class="btn" type="submit">회원가입</button>
				</div>
			</form> -->
		</div>
	</div>
</section>
	
