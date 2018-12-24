<%@page import="cn.PApudding.Beans.WebModel"%>
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
	<%
		List<WebModel> list = (List<WebModel>) request.getAttribute("listAllModelContainer");
		for (WebModel model : list) {
	%>
	<%=model.getModeCssCode()%>
	<%
		}
	%>
</body>
</html>