<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="pageFileCode">
		<div class="scrollPicAll" id='scrollPicBox'>
			<div class="scrollPicScreen">
				<!--相框-->
				<ul>
					<li><img src="images/1.jpg" width="500" height="200" /></li>
					<li><img src="images/2.jpg" width="500" height="200" /></li>
					<li><img src="images/3.jpg" width="500" height="200" /></li>
					<li><img src="images/4.jpg" width="500" height="200" /></li>
					<li><img src="images/5.jpg" width="500" height="200" /></li>
				</ul>
				<ol>
				</ol>
			</div>
			<div id="scrollPicArr">
				<span id="scrollPicLeft">&lt;</span><span id="scrollPicRight">&gt;</span>
			</div>
		</div>
	</div>
	<form action="${pageContext.request.contextPath }/savePage.action"
		method="post">
		<input name="pageName" value="Catalina" hidden="true"> <input
			id="container" name="pageFileCode" value="" hidden="true"> <input
			name="51651351" value="WebEssay#field1" hidden="true"> <input
			name="651321" value="WebEssay#field1" hidden="true"> <input
			type="submit" value="提交" /> <input type="button" value="填充"
			onclick="contentInput()">
	</form>
</body>
<script type="text/javascript">
	function contentInput() {
		var pfc = document.getElementById("pageFileCode");
		var container = document.getElementById("container");
		container.setAttribute("value", pfc.innerHTML);
	}
</script>
</html>