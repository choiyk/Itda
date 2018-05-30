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
							<option value="2">경스데이</option>
						</select>
					</div>
				</div>
			</form>
		</div>
		<div id="more-features" class="row">
			<div class="col-lg-12">
				<div class="box" data-url="#">
					<p class="title">[일정] 성공회대학교 소프트웨어공학과 캡스톤 디자인 프로젝트 모임 일정 안내</p>
					<p class="description">경스데이 / 2018.05.23 10:30</p>
				</div>
			</div>
		</div>
	</div>
</section>

<section>
<div class="container">
	<div class="form">
			<form>
				<div class="form-row">
					<div class="form-group col-10">
						<input type="text" class="form-control" placeholder="검색어를 입력하세요.">
					</div>
					<div class="form-group col-2">
						<button type="submit" class="btn pull-right">검색</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
