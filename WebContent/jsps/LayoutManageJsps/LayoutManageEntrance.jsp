<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网站布局管理中心</title>
</head>
<body>
	<p>模板管理</p>
		<ul>
			<li>
				<a href="${pageContext.request.contextPath}/enterCreateTemplate.action">创建模板</a>
			</li>
			<!-- <li>
				<a href="${pageContext.request.contextPath}/enterModifyTemplate.action">修改模板</a>
			</li> -->
			<li>
				<a href="${pageContext.request.contextPath}/enterDeleteTemplate.action">查看/删除模板</a>
			</li>
		</ul>
	<p>页面管理</p>
		<ul>
			<li>
				<a href="${pageContext.request.contextPath}/enterCreatePage.action">创建页面</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/enterDeletePage.action">查看/删除页面</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/enterSiteManagePage.action">站点管理</a>
			</li>
		</ul>
	<p><a href="${pageContext.request.contextPath }/jsps/ManageSystemEntrance.jsp">返回</a></p>
</body>
</html>