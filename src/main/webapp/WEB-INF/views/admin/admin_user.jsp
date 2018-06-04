<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />

<section>
	<div class="container">
		<div class="form">
			<div id="more-features" class="row">
				<div class="col-lg-12">
					<div class="box" data-url="#">
						<p class="title">최윤경 (닉네임)</p>
						<p class="description">201432036 / 소프트웨어공학과</p>
						<button class="icon" data-url="#">삭제</button>
					</div>
				</div>
			</div>
			<form>
				<div class="form-row">
					<div class="form-group col-10">
						<input type="text" class="form-control" placeholder="회원 이름으로 검색하세요.">
					</div>
					<div class="form-group col-2">
						<button type="submit" class="btn pull-right">검색</button>
					</div>
				</div>
			</form>
			<embed height="300" width="100%" src="${R}user_list_search">
		</div>
	</div>
</section>
