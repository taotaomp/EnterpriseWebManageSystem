<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <a href="${pageContext.request.contextPath}/jsps/test.action">点我</a>
	<a href="${pageContext.request.contextPath}/enterMainSite_test.action">点我测试enterMainSite_test.action</a>
	<!--  
	<form style="width: 100%;height: 100%" action="${pageContext.request.contextPath}/test1.action">
		<input hidden="true" name="webEssay.essayTitle" value="安居啊啊吊袜带">
		<input type="text" height="900px" width="800px" name="webEssay.essayContent" value="安居啊啊吊袜带9191617151">
		<input name="webEssay.essayField" value="安">
		<input type="submit" value="fuck me">
	</form>
	-->
	<form action="${pageContext.request.contextPath}/test.action" method="post">
		<input hidden="true" name="testList[0]" value="安">
		<input hidden="true" name="testList[1]" value="2156s">
		<input hidden="true" name="testList[2]" value="234236a">
		<input type="submit" value="fuck me">
	</form>
</body>
</html>