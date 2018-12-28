<%@page import="java.util.Random"%>
<%@page import="cn.PApudding.Beans.WebBeans.WebTemplateToModelBindEntity"%>
<%@page import="java.util.Set"%>
<%@page import="cn.PApudding.Beans.WebBeans.WebTemplate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>为部件绑定数据源</title>
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
	<%
		//获取数据源
		List<String> webEssayFields = (List<String>) request.getAttribute("webEssayFields");
		List<String> webLinkFields = (List<String>) request.getAttribute("webLinkFields");
		List<String> webMediaSourceFields = (List<String>) request.getAttribute("webMediaSourceFields");
		//获取模板
		WebTemplate webTemplate = (WebTemplate) request.getAttribute("webTemplate");
		Set<WebTemplateToModelBindEntity> bindEntities = webTemplate.getTemplateToModelBindEntities();
		//随机数生成
		Random random = new Random();
		int i = 0;
	%>

	<form action="savePage.action" method="post">
		<table>
			<tr>
				<td>页面名称</td>
				<td><input name="pageName" type="text"></td>
			</tr>
			<tr>
				<td>部件名称</td>
				<td>数据源选择</td>
			</tr>
		<%
			for(WebTemplateToModelBindEntity bindEntity : bindEntities){
		%>
			<tr>
				<td>
					<%=bindEntity.getModelName() %>
					<%
						int randomNum = random.nextInt(1000);
					%>
					<input hidden="true" name="webTemplateToModelBindEntityId_Random[<%=i++ %>]" value="<%=bindEntity.getId() %>#<%=randomNum%>">
				</td>
				<td>
				<!-- 生成随机数作为模板的唯一标识 -->
					<select name="<%=randomNum%>">
						<%
							for(String string :webEssayFields){
								
						%>
							<option value="WebEssay#<%=string%>"><%=string%></option>
						<%
							}
						%>
						<%
							for(String string :webLinkFields){
								
						%>
							<option value="WebLink#<%=string%>"><%=string%></option>
						<%
							}
						%>
						<%
							for(String string :webMediaSourceFields){
								
						%>
							<option value="WebMediaSource#<%=string%>"><%=string%></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
		<%
			}
		%>		
			<tr>
				<td colspan="1"><input type="submit" value="提交"></td>
				<td></td>
			</tr>	
		</table>
	</form>

</body>
</html>