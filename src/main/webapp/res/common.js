$(function() {
	$("#body").css("min-height", $(window).height()+"px");
	
	if($(window).width()<=768){
		$("#category").removeClass("col-lg-2");
		$("#category").addClass("col-4");
		$("#category-btn").removeClass("col-lg-10");
		$("#category-btn").addClass("col-8");
	}
	else{
		$("#category").removeClass("col-4");
		$("#category").addClass("col-lg-2");
		$("#category-btn").removeClass("col-8");
		$("#category-btn").addClass("col-lg-10");
	}
	
	$(window).resize(function(){
		$("#body").css("min-height", $(window).height()+"px");
		
		if($(window).width()<=768){
			$("#category").removeClass("col-lg-2");
			$("#category").addClass("col-4");
			$("#category-btn").removeClass("col-lg-10");
			$("#category-btn").addClass("col-8");
		}
		else{
			$("#category").removeClass("col-4");
			$("#category").addClass("col-lg-2");
			$("#category-btn").removeClass("col-8");
			$("#category-btn").addClass("col-lg-10");
		}
	});
	
	$("[data-url]").click(function() {
		var url = $(this).attr("data-url");
		location.href = url;
	})
	
	$("[data-confirm-delete]").click(function() {
		return confirm("삭제하시겠습니까?");
	})
	
	$("#withdraw").click(function(){
		if(confirm(
				"모든 자료가 삭제되며 복구할 수 없습니다.\n" +
				"정말 탈퇴하시겠습니까?")){
			alert("탈퇴되었습니다.");
		}
	});
	
	$("#alarm").slideDown();
	$("#alarm_close").click(function(){
		$("#alarm").slideUp();
	})

})
