<%@page import="cn.PApudding.Beans.WebBeans.WebTemplate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>创建页面</title>
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
		<%for(WebTemplate webTemplate:webTemplates){ %>
			<tr>
				<td>
					<%=webTemplate.getTemplateName() %>
				</td>
				<td>
					<%=webTemplate.getTemplateType() %>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/enterCreatePageBindDataSource.action?webTemplateName=<%=webTemplate.getTemplateName() %>">使用该模板</a>
				</td>
			</tr>
		<%} %>
	</table>
</body>
</html>