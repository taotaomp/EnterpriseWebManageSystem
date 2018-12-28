<%@page import="cn.PApudding.Beans.WebBeans.WebPage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除页面</title>
</head>
<body>
<h3>请选择您要删除的页面</h3>
	<table>
	<tr>
		<td>页面名</td>
		<td>选择</td>
	</tr>
	<%
		List<WebPage> webPageList = (List<WebPage>)request.getAttribute("pages");
		if(webPageList!=null){
			for(WebPage webPage:webPageList){
	%>
		<tr>
		<td><%=webPage.getPageName() %></td>
		<td><a href="${pageContext.request.contextPath}/deletePage.action?id=<%=webPage.getId() %>">删除</a></td>
		</tr>
	<%
			}
		}
	%>
	</table>
	<p><a href="${pageContext.request.contextPath}/jsps/LayoutManageJsps/LayoutManageEntrance.jsp">返回</a></p>

</body>
</html>