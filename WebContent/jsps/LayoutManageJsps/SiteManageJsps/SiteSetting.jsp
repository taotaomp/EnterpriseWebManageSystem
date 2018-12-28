<%@page import="cn.PApudding.Beans.WebBeans.WebPage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>站点设置</title>
<script type="text/javascript">
	int i = 0;
	function addPage(){
		var container = document.getElementById("pageContainer");
		var pageTr = document.createElement("tr");
		var pageNameTd = document.createElement("td");
		
		var pageInput = document.createElement("input");
		pageInput.setAttribute("type","button");
		pageInput.setAttribute("value","确定");
		
	}
</script>
</head>
<body>
	<%
		List<WebPage> webPageList = (List<WebPage>)request.getAttribute("webPageList");
	%>
	<form action="saveSite.action">
		<table id="pageContainer">
			<tr>
				<td>主页选择</td>
				<td>
					<select id="select" name="index">
						<%
							for(WebPage wPage : webPageList){
						%>
						<option value="<%=wPage.getPageName()%>"><%=wPage.getPageName()%></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>第二页面选择</td>
				<td>
					<select id="select" name="secondPage">
						<%
							for(WebPage wPage : webPageList){
						%>
						<option value="<%=wPage.getPageName()%>"><%=wPage.getPageName()%></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>第三页面选择</td>
				<td>
					<select id="select" name="thirdPage">
						<%
							for(WebPage wPage : webPageList){
						%>
						<option value="<%=wPage.getPageName()%>"><%=wPage.getPageName()%></option>
						<%
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
</body>
</html>