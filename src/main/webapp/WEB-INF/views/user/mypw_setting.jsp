<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />

<section>
	<div class="container">
		<div class="form">
			<form>
				<div class="form-row">
					<div class="form-group center col-lg-8">
						<input type="password" class="form-control" placeholder="비밀번호">
					</div>
				</div>
				<div class="text-center">
					<button class="btn" type="submit">저장</button>
				</div>
			</form>
		</div>
	</div>
</section>