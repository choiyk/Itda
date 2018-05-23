<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />

<section id="content">
	<div class="container">
		<p class="article-inf">최윤경 / 2018.05.23 10:30</p>
		<p class="article-category">일정</p>
		<div class="form">
			<div class="form-row">
				<div class="form-group col-lg-12">
					<div class="form-control">성공회대학교 소프트웨어공학과 캡스톤 디자인 프로젝트 모임 일정 안내</div>
				</div>
				<div class="form-group col-lg-12">
					<div class="form-control article-content">
						성공회대학교 소프트웨어공학과 캡스톤 디자인 프로젝트 모임 일정 안내입니다.<br/>
						5월 첫째주: 기능 정리<br/>
						5월 둘째주: DB 구현 및 UI 구상<br/>
						5월 셋째주: 개발 1주차<br/>
					</div>
				</div>
			</div>
		</div>
		<div>
			<button class="btn pull-right" data-url="#">삭제</button>
			<button class="btn pull-right" data-url="#">수정</button>
		</div>
	</div>
	<div class="margin"></div>
</section>

<section>
	<div class="container">
		<div id="more-features" class="row">
			<div class="col-lg-12">
				<div class="box">
					<div class="comment">
						<div>등록된 댓글이 없습니다.</div>
					</div>
					<div class="comment">
						<i class="ion-close-round pull-right" data-url="#"></i>
						<i class="ion-android-create pull-right" data-url="#"></i>
						<p class="description">최윤경 / 2018.05.23 14:30</p>
						<div>모임 일정 잘 보았습니다! 다음 모임 때 뵙겠습니다.</div>
					</div>	
					
					<div class="form">
						<form>
							<div class="form-row">
								<div class="form-group col-10">
									<input type="text" class="form-control" placeholder="댓글을 입력하세요.">
								</div>
								<div class="form-group col-2">
									<button type="submit" class="btn pull-right">등록</button>
								</div>
							</div>
						</form>
					</div>		
				</div>
			</div>
		</div>
	</div>
</section>
