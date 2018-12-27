<%@page import="cn.PApudding.Beans.SourceBeans.WebMediaSource"%>
<%@page import="cn.PApudding.Beans.SourceBeans.WebLink"%>
<%@page import="cn.PApudding.Beans.SourceBeans.WebEssay"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>内容更改</title>
</head>
<body>
	<%
		//获取数据库名，根据数据库名来确认资源的对象类别
		String databaseName = (String) request.getAttribute("databaseName");
		switch (databaseName) {
		//资源对象是文章对象
		case "WebEssay": {
			WebEssay essay = (WebEssay) request.getAttribute("data");
	%>
		<form action="${pageContext.request.contextPath}/saveModifyData.action" method="post">
			<input hidden="true" name="webEssay.id" value="<%=essay.getId() %>">
			<input hidden="true" name="webEssay.essayField" value="<%=essay.getEssayField() %>">
			<table>
				<tr>
					<td>文章标题</td>
					<td><input name="webEssay.essayTitle" type="text" value="<%=essay.getEssayTitle() %>"></td>
				</tr>
				<tr>
					<td colspan="2">文章内容</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><textarea id="WebEssayContent" name="webEssay.essayContent" cols="60" rows="90" >
						<%=essay.getEssayContent() %>
					</textarea>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="提交更改"></td>
					<td></td>
				</tr>
			</table>
		</form>
	<%
		break;
		}
		//资源对象是链接对象
		case "WebLink": {
			WebLink link = (WebLink) request.getAttribute("data");
	%>
		<form action="${pageContext.request.contextPath}/saveModifyData.action" method="post">
			<input hidden="true" name="webLink.id" value="<%=link.getId() %>">
			<input hidden="true" name="webLink.linkField" value="<%=link.getLinkField() %>">
			<table>
				<tr>
					<td>链接名</td>
					<td><input name="webLink.linkName" type="text" value="<%=link.getLinkName() %>"></td>
				</tr>
				<tr>
					<td>链接内容</td>
					<td><input name="webLink.linkUrl" type="text" value="<%=link.getLinkUrl() %>"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="提交更改"></td>
					<td></td>
				</tr>
			</table>
		</form>
	<%
			break;
		}
		//资源对象是媒体对象
		case "WebMediaSource": {
			WebMediaSource mediaSource = (WebMediaSource) request.getAttribute("data");
	%>
		<form action="${pageContext.request.contextPath}/saveModifyData.action" method="post">
			<input hidden="true" name="webMediaSource.id" value="<%=mediaSource.getId() %>">
			<input hidden="true" name="webMediaSource.mediaField" value="<%=mediaSource.getMediaField() %>">
			<input hidden="true" name="webMediaSource.mediaType" value="<%=mediaSource.getMediaType() %>">
			<table>
				<tr>
					<td>媒体名称</td>
					<td><input name="webMediaSource.mediaName" type="text" value="<%=mediaSource.getMediaName() %>"></td>
				</tr>
				<tr>
					<td>媒体位置</td>
					<td><input name="webMediaSource.Url" type="text" value="<%=mediaSource.getMediaUrl() %>"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="提交更改"></td>
					<td></td>
				</tr>
			</table>
		</form>
	<%
			break;
		}
		}
	%>
</body>
</html>