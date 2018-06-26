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
						<form:select path="meetings" class="form-control" >
							<option value="">전체</option>
							<form:options path="meetings" items="${meetings}" itemLabel="name" itemValue="id"/>
						</form:select>
					</div>
 
				</div>
			</form>
		</div>
		<div id="more-features" class="row">
			<c:if test="${ !empty myArticles}">
			<c:forEach var="myArticle" items="${myArticles }">
			
			<div class="col-lg-12">
				<div class="box" data-url="article?bd=${myArticle.boardId }&at=${myArticle.articleId }">
				
					<c:if test="${myArticle.cateName eq '공지' }">
					<p class="title"><span class="notice">${myArticle.cateName}</span> ${myArticle.title }</p>
					</c:if>
					<c:if test="${myArticle.cateName ne '공지' }">
					<p class="title"><span class="category">${myArticle.cateName}</span> ${myArticle.title }</p>
					</c:if>
					
					<p class="description">${myArticle.name } / 작성일 : ${myArticle.articleDate }</p>
					
				</div>
			</div>
			</c:forEach>
			</c:if>
			<c:if test="${ empty myArticles}">
				<p class="description">등록된 글이 없습니다.</p>
			</c:if>
		</div>
	</div>
</section>
