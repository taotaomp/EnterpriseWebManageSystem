<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<!-- 将请求转发到EnterMainSiteAction -->
	<%
		response.sendRedirect(request.getContextPath()+"/enterMainSite_index.action");
	%>
</body>
</html>