<%@page import="cn.PApudding.Beans.WebBeans.WebTemplate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>删除模板</title>
</head>
<body>
<h3>请选择您要删除的模板</h3>
	<table>
	<tr>
		<td>模板名</td>
		<td>选择</td>
	</tr>
	<%
		List<WebTemplate> webTemplateList = (List<WebTemplate>)request.getAttribute("templates");
		if(webTemplateList!=null){
			for(WebTemplate template:webTemplateList){
	%>
		<tr>
		<td><%=template.getTemplateName() %></td>
		<td><a href="${pageContext.request.contextPath}/deleteTemplate.action?id=<%=template.getId() %>">删除</a></td>
		</tr>
		
	<%
			}
		}
	%>
	</table>
	<p><a href="${pageContext.request.contextPath}/jsps/LayoutManageJsps/LayoutManageEntrance.jsp">返回</a></p>
</body>
</html>