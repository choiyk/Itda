<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Itda</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<link href="${R}img/favicon.png" rel="icon">
<link href="${R}img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="${R}lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="${R}lib/animate/animate.min.css" rel="stylesheet">
<link href="${R}lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="${R}lib/ionicons/css/ionicons.min.css" rel="stylesheet">
<link href="${R}lib/magnific-popup/magnific-popup.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="${R}css/style.css" rel="stylesheet">

<!-- =======================================================
  Theme Name: Avilon
  Theme URL: https://bootstrapmade.com/avilon-bootstrap-landing-page-template/
  Author: BootstrapMade.com
  License: https://bootstrapmade.com/license/
======================================================= -->

<script src="${R}res/common.js"></script>
<link rel="stylesheet" href="${R}res/common.css">

</head>
<body>

<div id="body">

	<div class="margin"></div>
	
	<section>
		<div class="container text-center">
			<img id="main_logo_img" src="${R}img/favicon.png">
		</div>
	</section>
	
	<section>
		<div class="container">
			<p class="text-center">로그인</p>
			<div class="form">
				<form>
					<div class="form-row">
						<div class="form-group center col-lg-8">
							<input type="text" class="form-control" placeholder="학번">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group center col-lg-8">
							<input type="password" class="form-control" placeholder="비밀번호">
						</div>
					</div>
					<div class="text-center">
						<button class="btn" type="submit" title="login">로그인</button>
					</div>
				</form>
			</div>
		</div>
	</section>
	
	<div class="margin"></div>
	<div class="margin"></div>
	<div class="margin"></div>
	
	<section>
		<hr/>
		<p class="text-center"><span class="bar_text" data-url="#">회원가입</span></p>
	</section>
	
</div>

<!-- JavaScript Libraries -->
<script src="lib/jquery/jquery.min.js"></script>
<script src="lib/jquery/jquery-migrate.min.js"></script>
<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/superfish/hoverIntent.js"></script>
<script src="lib/superfish/superfish.min.js"></script>
<script src="lib/magnific-popup/magnific-popup.min.js"></script>

<!-- Contact Form JavaScript File -->
<script src="contactform/contactform.js"></script>

<!-- Template Main Javascript File -->
<script src="js/main.js"></script>

</body>
</html>
