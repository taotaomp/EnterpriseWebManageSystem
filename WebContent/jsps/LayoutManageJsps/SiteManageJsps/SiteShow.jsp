<%@page import="cn.PApudding.Beans.SourceBeans.WebLink"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>现有站点结构</title>
</head>
<body>
	<ul>
		<li>网站根结点
			<ul>
	<%
		List<WebLink> webLinks = (List<WebLink>) request.getAttribute("webLinks");
		if (webLinks != null) {
			for(WebLink link :webLinks){
	%>
				<li><%=link.getLinkName() %></li>
	<%
			}
		}
	%>
			</ul>
		</li>
		<li>网站内容页</li>
		<li>网站列表页</li>
	</ul>
	<p><a href="${pageContext.request.contextPath}/jsps/LayoutManageJsps/SiteManageJsps/SiteManageEntrance.jsp">返回</a></p>
</body>
</html>