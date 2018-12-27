<%@page import="cn.PApudding.Beans.SourceBeans.WebMediaSource"%>
<%@page import="cn.PApudding.Beans.SourceBeans.WebLink"%>
<%@page import="java.util.List"%>
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
<title><%=(String) request.getAttribute("dataField")%>数据源内容</title>
</head>
<body>
	<%
		//获取数据库名，根据数据库名来确认资源的对象类别
		String databaseName = (String) request.getAttribute("databaseName");
		switch (databaseName) {
		//资源对象为文章资源
		case "WebEssay": {
	%>
	<table>
		<tr>
			<td>文章标题</td>
			<td>操作</td>
		</tr>
		<%
			//装载文章资源
			List<WebEssay> webEssays = (List<WebEssay>) request.getAttribute("data");
			for (WebEssay essay : webEssays){
		%>
		<tr>
			<td><%=essay.getEssayTitle() %></td>
			<td>
				<a href="${pageContext.request.contextPath }/enterModifyData.action?databaseName=WebEssay&dataName=<%=java.net.URLEncoder.encode(essay.getEssayTitle(), "UTF-8") %>">修改文章</a>
				<a href="${pageContext.request.contextPath }/deleteData.action?databaseName=WebEssay&dataName=<%=java.net.URLEncoder.encode(essay.getEssayTitle(), "UTF-8") %>">删除文章</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="${pageContext.request.contextPath }/enterCreateData.action?databaseName=WebEssay">新建文章</a>
	<%
		break;
		}
		//资源对象是链接资源
		case "WebLink": {
	%>
	<table>
		<tr>
			<td>链接名称</td>
			<td>操作</td>
		</tr>
		<%
			//装载链接资源
			List<WebLink> webLinks = (List<WebLink>) request.getAttribute("data");
			for (WebLink link : webLinks){
		%>
		<tr>
			<td><%=link.getLinkName() %></td>
			<td>
				<a href="${pageContext.request.contextPath }/enterModifyData.action?databaseName=WebLink&dataName=<%=link.getLinkName() %>">修改链接</a>
				<a href="${pageContext.request.contextPath }/deleteData.action?databaseName=WebLink&dataName=<%=link.getLinkName() %>">删除链接</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="${pageContext.request.contextPath }/enterCreateData.action?databaseName=WebLink">新建链接</a>
	<%
			break;
		}
		//资源对象是媒体资源
		case "WebMediaSource": {
	%>
	<table>
		<tr>
			<td>媒体名称</td>
			<td>操作</td>
		</tr>
		<%
			//装载媒体资源
			List<WebMediaSource> webMediaSources = (List<WebMediaSource>) request.getAttribute("data");
			for (WebMediaSource webMediaSource : webMediaSources){
		%>
		<tr>
			<td><%=webMediaSource.getMediaName()%></td>
			<td>
				<a href="${pageContext.request.contextPath }/enterModifyData.action?databaseName=WebMediaSource&dataName=<%=webMediaSource.getMediaName()%>">修改媒体</a>
				<a href="${pageContext.request.contextPath }/deleteData.action?databaseName=WebMediaSource&dataName=<%=webMediaSource.getMediaName()%>">删除媒体</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="${pageContext.request.contextPath }/enterCreateData.action?databaseName=WebMediaSource">新建媒体</a>
	<%
			break;
		}
		default: {
	%>
	<p>该数据源为空或不存在</p>
	<%
			break;
		}
		}
	%>

</body>
</html>