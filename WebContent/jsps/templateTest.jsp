<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%	
		list1 = new ArrayList<String>(); 
		list1.add("ul{"+
				"list-style-type: none;"+
			"}"+
			"ul li{"+
				"float: left;"+
				"width: 100px;"+
			"}"+
			"ul li a{"+
				"text-underline-style: none;"+
			"}");
		list1.add("p{"+
				"background-color: #FF6666;"+
			"}");
		list2 = new ArrayList<String>();
		list2.add("<div id=\"navbar\">"+
					"<ul>"+
						"<li><a href=\"#\">test</a></li>"+
						"<li><a href=\"#\">test</a></li>"+
						"<li><a href=\"#\">test</a></li>"+
						"<li><a href=\"#\">test</a></li>"+
					"</ul>"+
				"</div>");
		list2.add("<div>"+
				"<p>我是段落</p>"+
				"</div>");
	%>
	
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	<%for(String css:list1){%>
		<%= css %>
	<%}%>
</style>
</head>
<body>
	<div id="models">
		<%for(String css:list2){%>
			<%= css %>
		<%}%>
	</div>
	
</body>
</html>
<%!
	List<String> list1;
	List<String> list2;
%>