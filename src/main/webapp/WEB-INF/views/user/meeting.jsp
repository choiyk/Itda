<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="R" value="/" />

<section id="content">
	<div class="container">
		<div class="form">
			<form>
				<div class="form-row">
				
					<div id="category" class="form-group">
						<form:select class="form-control" path="category">
							<!--  <option value="">전체</option>-->
							<form:options items="${category}" itemLabel="name" itemValue="id"/>
						</form:select>
					</div>
				 
					<div id="category-btn" class="form-group">
						<c:if test="${user.type == 3}">
							<p class="pull-right" data-url="#">모임 관리 <i class="ion-android-settings"></i></p>
						</c:if>
						<p class="pull-right" data-url="article_write?bd=${board.id }">글쓰기 <i class="ion-android-create"></i></p>
					</div>
				</div>
			</form>
		</div>
		<div id="more-features" class="row">
			<div class="col-lg-12">
				<div class="box" data-url="#">
					<p class="title"><span class="notice">공지</span>성공회대학교 소프트웨어공학과 캡스톤 디자인 프로젝트 모임 공지사항</p>
					<p class="description">최윤경 / 2018.05.23 10:30</p>
				</div>
			</div>
			
			<c:if test="${! empty articles }">
			
			<c:forEach var="article" items="${ articles }">
			<div class="col-lg-12">
				<div class="box" data-url="#">
					<p class="title">[${article.cateName}] ${article.articleTitle }</p>
					
					<c:if test="${article.userNickName == null }">
					<p class="description">${article.userName } / ${article.articleDate }</p>
					</c:if>
					
					<c:if test="${article.userNickName != null }">
					<p class="description">${article.userNickName } / ${article.articleDate }</p>
					</c:if>
				</div>
			</div>
			</c:forEach>
			
			</c:if>
			
			<c:if test="${empty articles }">
			
			<div class="col-lg-12">
				<div class="box">
					<p class="title">"${menu }"의 첫 글을 작성해주세요 !</p>
				</div>
			</div>
			
			</c:if>
		</div>
	</div>
</section>

<section>
<div class="container">
	<div class="form">
			<form>
				<div class="form-row">
					<div id="category" class="form-group col-10">
						<input type="text" class="form-control" placeholder="검색어를 입력하세요.">
					</div>
					<div id="category-btn" class="form-group col-2">
						<button type="submit" class="btn pull-right">검색</button>
					</div>
				</div>
			</form>
		</div>
</div>
</section>
