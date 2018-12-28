<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>站点管理</title>
</head>
<body>
	<h3>站点管理操作</h3>
	<a href="${pageContext.request.contextPath}/enterSiteShow.action">查看现有站点结构</a><br>
	<a href="${pageContext.request.contextPath}/enterSiteDelete.action">从站点中删除页面</a><br>
	<a href="${pageContext.request.contextPath}/enterSiteCreate.action">为站点指定新页面</a><br>
	<p><a href="${pageContext.request.contextPath}/jsps/LayoutManageJsps/LayoutManageEntrance.jsp">返回</a></p>
</body>
</html>