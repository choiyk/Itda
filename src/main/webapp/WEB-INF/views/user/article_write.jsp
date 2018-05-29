<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />

<section id="content">
	<div class="container">
		<div class="form">
			<form>
				<div class="form-row">
					<div id="category" class="form-group">
						<select class="form-control" name="category">
							<option value="1">전체</option>
							<option value="2">일정</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-lg-12">
						<input type="text" class="form-control" placeholder="제목을 입력하세요.">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-lg-12">
						<textarea class="form-control" rows="10">내용을 입력하세요.</textarea>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-lg-12">
						<input type="submit" class="btn pull-right" value="저장">
					</div>
				</div>
			</form>
		</div>
	</div>
</section>