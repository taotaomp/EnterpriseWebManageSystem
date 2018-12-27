<%@page import="java.util.List"%>
<%@page import="cn.PApudding.Beans.SourceBeans.WebMediaSource"%>
<%@page import="cn.PApudding.Beans.SourceBeans.WebLink"%>
<%@page import="cn.PApudding.Beans.SourceBeans.WebEssay"%>
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

table tr {
	border: 1px solid;
}

table tr td {
	border: 1px solid;
}
</style>
<script type="text/javascript">
	function newdataSourceWebEssay() {
		//删除下拉框
		document.getElementById("selectTd").removeChild(document.getElementById("select"));
		//添加文本框
		var inputNode = document.createElement("input");
		inputNode.setAttribute("name", "webEssay.essayField");
		document.getElementById("selectTd").appendChild(inputNode);
		//删除按钮
		document.getElementById("butTd").removeChild(document.getElementById("but"));
		
	}
	function newdataSourceWebLink() {
		//删除下拉框
		document.getElementById("selectTd").removeChild(document.getElementById("select"));
		//添加文本框
		var inputNode = document.createElement("input");
		inputNode.setAttribute("name", "webLink.linkField");
		document.getElementById("selectTd").appendChild(inputNode);
		//删除按钮
		document.getElementById("butTd").removeChild(document.getElementById("but"));
	}
	function newdataSourceWebMediaSource() {
		//删除下拉框
		document.getElementById("selectTd").removeChild(document.getElementById("select"));
		//添加文本框
		var inputNode = document.createElement("input");
		inputNode.setAttribute("name", "webMediaSource.mediaField");
		document.getElementById("selectTd").appendChild(inputNode);
		//删除按钮
		document.getElementById("butTd").removeChild(document.getElementById("but"));
	}
</script>
<title>新建数据</title>
</head>
<body>
	<%
		//获取数据库名，根据数据库名来确认资源的对象类别
		String databaseName = (String) request.getAttribute("databaseName");
		switch (databaseName) {
		//资源对象是文章对象
		case "WebEssay": {
			List<String> webEssayFields = (List<String>) request.getAttribute("webEssayFields");
	%>
	<form action="${pageContext.request.contextPath}/saveCreateData.action" method="post">
		<table>
			<tr>
				<td>文章标题</td>
				<td><input name="webEssay.essayTitle" type="text"></td>
			</tr>
			<tr>
				<td>使用数据源</td>
				<td id="selectTd">
					<select id="select" name="webEssay.essayField">
						<%
							for (String webEssayField : webEssayFields) {
						%>

						<option value="<%=webEssayField%>"><%=webEssayField%></option>
						<%
							}
						%>
					</select>
				</td>
				<td id="butTd">
					<input type="button" id="but" value="新建数据源" onclick="newdataSourceWebEssay()">
					<!--  <input id="ds" hidden="true" name="webEssay.essayField">-->
				</td>
			</tr>
			<tr>
				<td colspan="3">文章内容</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><textarea id="WebEssayContent"
						name="webEssay.essayContent" cols="60" rows="90"></textarea>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="提交"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
	<%
		break;
		}
		//资源对象是链接对象
		case "WebLink": {
			//装载链接源
			List<String> webLinkFields = (List<String>) request.getAttribute("webLinkFields");
	%>
	<form action="${pageContext.request.contextPath}/saveCreateData.action" method="post">
		<table>
			<tr>
				<td>链接名</td>
				<td><input name="webLink.linkName" type="text"></td>
			</tr>
			<tr>
				<td>链接内容</td>
				<td><input name="webLink.linkUrl" type="text"></td>
			</tr>
			<tr>
				<td>使用数据源</td>
				<td id="selectTd">
					<select id="select" name="webLink.linkField">
						<%
							for (String webLinkField : webLinkFields) {
						%>

						<option value="<%=webLinkField%>"><%=webLinkField%></option>
						<%
							}
						%>
					</select>
				</td>
				<td id="butTd">
					<input type="button" id="but" value="新建数据源" onclick="newdataSourceWebLink()">
					<!--  <input id="ds" hidden="true" name="webLink.linkField">-->
				</td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="提交"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
	<%
		break;
		}
		//资源对象是媒体对象
		case "WebMediaSource": {
			//装载媒体源
			List<String> webMediaSourceFields = (List<String>) request.getAttribute("webMediaSourceFields");
	%>
	<form action="${pageContext.request.contextPath}/saveCreateData.action" method="post">
		<table>
			<tr>
				<td>媒体名称</td>
				<td><input name="webMediaSource.mediaName" type="text"></td>
			</tr>
			<tr>
				<td>媒体位置</td>
				<td><input name="webMediaSource.Url" type="text"></td>
			</tr>
			<tr>
				<td>媒体类型</td>
				<td><input name="webMediaSource.mediaType" type="text"></td>
			</tr>
			<tr>
				<td>使用数据源</td>
				<td id="selectTd">
					<select id="select" name="webMediaSource.mediaField">
						<%
							for (String webMediaSourceField : webMediaSourceFields) {
						%>

						<option value="<%=webMediaSourceField%>"><%=webMediaSourceField%></option>
						<%
							}
						%>
					</select>
				</td>
				<td id="butTd">
					<input type="button" id="but" value="新建数据源" onclick="newdataSourceWebMediaSource()">
					<!-- <input id="ds" hidden="true" name="webMediaSource.mediaField"> -->
				</td>
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