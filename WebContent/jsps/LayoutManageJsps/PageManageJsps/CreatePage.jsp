<%@page import="cn.PApudding.Beans.WebBeans.WebTemplate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>创建页面</title>
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
	<h3>请选择要使用的模板</h3>
	<%List<WebTemplate> webTemplates = (List<WebTemplate>)request.getAttribute("listAllTemplateContainer"); %>
	<table>
		<tr>
			<td>模板名</td>
			<td>模板类型</td>
			<td>模板选择</td>
		</tr>
		<%if(webTemplates!=null) {%>
			<%for(WebTemplate webTemplate:webTemplates){ %>
			<tr>
				<td>
					<%=webTemplate.getTemplateName() %>
				</td>
				<td>
					<%=webTemplate.getTemplateType() %>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/enterCreatePageBindDataSource.action?id=<%=webTemplate.getId() %>">使用该模板</a>
				</td>
			</tr>
			<%} %>
		<%} %>
	</table>
	<p><a href="${pageContext.request.contextPath}/jsps/LayoutManageJsps/LayoutManageEntrance.jsp">返回</a></p>
</body>
</html>