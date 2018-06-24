<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style> .error {color:red;} </style>
<c:url var="R" value="/" />

<section id="content">
	<div class="container">
		<div class="form">
			<form:form method="post" modelAttribute="meetingRegistrationModel">
				<div class="form-row">
					<div class="form-group center col-lg-12">
						<form:input path="meetingName" type="text" name="meetingName" class="form-control" placeholder="모임명"/>
						<form:errors path="meetingName" class="error"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group center col-lg-12">
						<textarea name="mexplain" class="form-control" rows="5">모임 설명</textarea>
					</div>
				</div>
				<div>
					<!-- <button class="btn pull-right" data-url="#">모임 폐쇄</button> -->
					<button class="btn pull-right">저장</button>
				</div>
			</form:form>
		</div>
	</div>
</section>

	
