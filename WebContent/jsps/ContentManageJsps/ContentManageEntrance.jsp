<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网站内容管理中心</title>
</head>
<body>
	<p>文章源</p>
	<ul>
		<%
			List<String> webEssayFields = (List<String>) request.getAttribute("webEssayFields");
		%>
		<%
			for (String webEssayField : webEssayFields) {
		%>
		<li><a href="${pageContext.request.contextPath}/enterDataSource.action?databaseName=WebEssay&dataField=<%=java.net.URLEncoder.encode(webEssayField, "UTF-8")%>"><%=webEssayField%></a></li>
		<%
			}
		%>
	</ul>
	<p>链接源</p>
	<ul>
		<%
			List<String> webLinkFields = (List<String>) request.getAttribute("webLinkFields");
		%>
		<%
			for (String webLinkField : webLinkFields) {
		%>
		<li><a href="${pageContext.request.contextPath}/enterDataSource.action?databaseName=WebLink&dataField=<%=java.net.URLEncoder.encode(webLinkField, "UTF-8")%>"><%=webLinkField%></a></li>
		<%
			}
		%>
	</ul>
	<p>媒体源</p>
	<ul>
		<%
			List<String> webMediaSourceFields = (List<String>) request.getAttribute("webMediaSourceFields");
		%>
		<%
			for (String webMediaSourceField : webMediaSourceFields) {
		%>
		<li><a href="${pageContext.request.contextPath}/enterDataSource.action?databaseName=WebMediaSource&dataField=<%=java.net.URLEncoder.encode(webMediaSourceField, "UTF-8")%>"><%=webMediaSourceField%></a></li>
		<%
			}
		%>
	</ul>
</body>
</html>