<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<li><%=webEssayField%></li>
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
		<li><%=webLinkField%></li>
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
		<li><%=webMediaSourceField%></li>
		<%
			}
		%>
	</ul>
</body>
</html>