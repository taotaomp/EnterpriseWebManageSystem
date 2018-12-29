<%@page import="cn.PApudding.Beans.WebBeans.WebPage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>为站点添加一个页面</title>
<style type="text/css">
	table {
		border: 1px solid;	
	}
	table tr{
		border: 1px solid;	
	}
	table tr td{
		border: 1px solid;	
	}	
</style>
</head>
<body>
	<form action="saveSite.action" method="post">
		<table>
			<tr>
				<td>请输入站点页面名称</td>
				<td><input type="text" name="sitePageName"></td>
			</tr>
			<tr>
				<td>请选择该站点页面要使用的页面</td>
				<td>
					<select name="webPageId">
	<%
		List<WebPage> webPageList = (List<WebPage>) request.getAttribute("webPageList");
		if(webPageList != null){
			for(WebPage webPage:webPageList){
	%>
				<option value="<%=webPage.getId()%>"><%=webPage.getPageName()%></option>
	<%
			}
		}
	%>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
	<p><a href="${pageContext.request.contextPath}/jsps/LayoutManageJsps/SiteManageJsps/SiteManageEntrance.jsp">返回</a></p>
</body>
</html>