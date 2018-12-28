<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>企业网站管理后台系统</title>
</head>
<body>
<h2>欢迎使用企业网站管理系统</h2>
<h4>请选择您要进行的操作</h4>
	<a href="${pageContext.request.contextPath}/enterLayoutManage.action">网站布局管理</a><br>
	<a href="${pageContext.request.contextPath}/enterContentManagePage.action">网站内容管理</a><br>
	<a href="${pageContext.request.contextPath}/enterMainSite_index.action">回到主页</a>
</body>
</html>