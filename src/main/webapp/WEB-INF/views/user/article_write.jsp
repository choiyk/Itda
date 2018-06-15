<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<style> .error {color:red;} </style>

<section id="content">
	<div class="container">
		<div class="form">
			<form:form method="post" modelAttribute="articleRegistrationModel">
				<div class="form-row">
				
					<div id="category" class="form-group">
						<form:select class="form-control" path="category" name="category">
							<form:options items="${category }" itemLabel="name" itemValue="id"/>
						</form:select>
					</div>
					
				</div>
				<div class="form-row">
					<div class="form-group col-lg-12">
						<form:input path="title" type="text" class="form-control" placeholder="제목을 입력하세요."/>
						<form:errors path="title" class="error"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-lg-12">
						<textarea name="contents" class="form-control" rows="10">내용을 입력하세요.</textarea>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-lg-12">
						<input type="submit" class="btn pull-right" value="저장">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</section>