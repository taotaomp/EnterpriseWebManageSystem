<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/saveSite.action" method="post">
		<input hidden="true" name="testSitePageName" value="Catalina">
		<input type="submit" value="提交"> 
	</form>
</body>
</html>