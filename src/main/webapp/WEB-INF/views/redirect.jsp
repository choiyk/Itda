<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<html> 
<body> 
	<script type="text/javascript"> 
		var message = '${msg}'; 
		var returnUrl = '${R}'+'${url}';
		document.location.href = returnUrl; 
		alert(message);
		
	</script>
</body>
</html> 