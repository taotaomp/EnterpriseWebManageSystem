<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>创建一个新模板</title>
<link rel="stylesheet" type="text/css" href="jsps/LayoutManageJsps/TemplateManageJsps/css/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" href="jsps/LayoutManageJsps/TemplateManageJsps/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="jsps/LayoutManageJsps/TemplateManageJsps/css/index.css" />
<link rel="stylesheet" type="text/css" href="jsps/LayoutManageJsps/TemplateManageJsps/css/搜索框.css" />
<link rel="stylesheet" type="text/css" href="jsps/LayoutManageJsps/TemplateManageJsps/css/导航栏.css" />
<link rel="stylesheet" type="text/css" href="jsps/LayoutManageJsps/TemplateManageJsps/css/轮播图.css" />
<link rel="stylesheet" type="text/css" href="jsps/LayoutManageJsps/TemplateManageJsps/css/留言.css" />
</head>
<body>
	<div id="btnassemble">
		<button id="addScrollimg" class="ui-button ui-widget ui-corner-all">添加轮播图</button>
		<button id="addSinput" class="ui-button ui-widget ui-corner-all">添加搜索框</button>
		<button id="addNav" class="ui-button ui-widget ui-corner-all">添加导航栏</button>
		<button id="addImg" class="ui-button ui-widget ui-corner-all">添加图片</button>
		<button id="addMessage" class="ui-button ui-widget ui-corner-all">添加邮箱</button>
		<button id="addList1" class="ui-button ui-widget ui-corner-all">添加文章链接表</button>
		<button id="addList2" class="ui-button ui-widget ui-corner-all">添加网页链接表</button>
		<form id="actionValue" action="saveTemplate.action" method="post" style="border: 0px">
			<input type ="text" name="templateName" placeholder="模板名">
			<input type ="text" name="templateType" placeholder="模板类型">
			<input id="saveBut" type="button" onclick="getStyleValue()" value="保存网页模板" class="ui-button ui-widget ui-corner-all">
			<input type="submit" value="提交网页模板" class="ui-button ui-widget ui-corner-all">
		</form>
	</div>
	<div id="contain">
		<!--搜索框-->
		<div id="search">
			<input type="text" value="" placeholder="请输入搜索内容" /> <a href="">&#xe615;</a>
		</div>
		<!--导航栏的div-->
		<div id="nav">
			<ul>
				<li><a href="">首页</a></li>
				<li><a href="">页面</a></li>
				<li><a href="">页面</a></li>
				<li><a href="">页面</a></li>
				<li><a href="">页面</a></li>
			</ul>
		</div>
		<!--轮播图-->
		<div id="scrollPic" class="slider">
			<ul>
				<li><a href="#"><img src="jsps/LayoutManageJsps/TemplateManageJsps/img/1.jpg" alt=""></a></li>
				<li><a href="#"><img src="jsps/LayoutManageJsps/TemplateManageJsps/img/2.jpg" alt=""></a></li>
				<li><a href="#"><img src="jsps/LayoutManageJsps/TemplateManageJsps/img/3.jpg" alt=""></a></li>
				<li><a href="#"><img src="jsps/LayoutManageJsps/TemplateManageJsps/img/4.jpg" alt=""></a></li>
				<li><a href="#"><img src="jsps/LayoutManageJsps/TemplateManageJsps/img/5.jpg" alt=""></a></li>
				<li><a href="#"><img src="jsps/LayoutManageJsps/TemplateManageJsps/img/6.jpg" alt=""></a></li>
				<li><a href="#"><img src="jsps/LayoutManageJsps/TemplateManageJsps/img/7.jpg" alt=""></a></li>
				<li><a href="#"><img src="jsps/LayoutManageJsps/TemplateManageJsps/img/8.jpg" alt=""></a></li>
			</ul>
			<!--箭头-->
			<div class="arrow">
				<span class="arrow-left">&lt;</span> <span class="arrow-right">&gt;</span>
			</div>
		</div>
		<!--图片	-->
		<div id="image"></div>
		<!--邮箱-->
		<div id="message"></div>
		<div id="messagePage">
			<form action="" method="post">
				<p>请输入留言内容:</p>
				<textarea name="message"></textarea>
				<p>
					请输入联系方式:<input type="text" value="" placeholder="请输入联系方式" />
				</p>
				<input type="submit" value="提交" /> <input type="button" value="关闭" />
			</form>
		</div>
		<!--内容-->
		<div id="list1">
			<ul>
				<li><a href="">文章链接</a></li>
				<li><a href="">文章链接</a></li>
				<li><a href="">文章链接</a></li>
				<li><a href="">文章链接</a></li>
			</ul>
		</div>
		<div id="list2">
			<ul>
				<li><a href="">网页链接</a></li>
				<li><a href="">网页链接</a></li>
				<li><a href="">网页链接</a></li>
				<li><a href="">网页链接</a></li>
			</ul>
		</div>
	</div>
	<script src="jsps/LayoutManageJsps/TemplateManageJsps/js/jquery-2.1.0.js"></script>
	<script src="jsps/LayoutManageJsps/TemplateManageJsps/js/jquery-ui.js"></script>
	<script src="jsps/LayoutManageJsps/TemplateManageJsps/js/jquery-ui.min.js"></script>
	<script>
		$(function() {
			//添加搜索框
			$("#addSinput").click(function() {
				$("#contain").append($("#search"));
				$("#search").css("display", "block");
				$("#search").draggable();
			})
			//添加导航栏
			$("#addNav").click(function() {
				$("#contain").append($("#nav"));
				$("#nav").css("display", "block");
				$("#nav").draggable();
				$("#nav").resizable();
			})
			//添加轮播图
			var num = 0;
			var $li = $(".slider>ul>li");
			$(".arrow-left").click(function() {
				num--;
				if (num == -1) {
					num = $li.length - 1;
				}
				$li.eq(num).fadeIn(1000).siblings("li").fadeOut(1000);
			});
			$(".arrow-right").click(function() {
				num++;
				if (num == $li.length) {
					num = 0;
				}
				$li.eq(num).fadeIn(1000).siblings("li").fadeOut(1000);
			});
			function scroll() {
				num++;
				if (num == $li.length) {
					num = 0;
				}
				;
				$li.eq(num).fadeIn(1000).siblings("li").fadeOut(1000);
			}
			;
			var timeId = setInterval(scroll, 2000);
			$(".slider").mouseenter(function() {
				clearInterval(timeId);
			})
			$(".slider").mouseleave(function() {
				timeId = setInterval(scroll, 2000);
			})
			$("#addScrollimg").click(function() {
				$("#contain").append($(".slider"));
				$(".slider").css("display", "block");
				$(".slider").draggable();
				$(".slider").resizable();
			})

			//添加图片
			$("#addImg").click(function() {
				$("#contain").append($("#image"));
				$("#image").css("display", "block");
				$("#image").draggable();
				$("#image").resizable();
			})

			//添加邮箱
			$("#addMessage").click(function() {
				//					$("#contain").append($("#message"));
				$("#message").css("display", "block");
				$("#message").draggable();
				$("#message").resizable();
			})
			$("#message").click(function() {
				$("#messagePage").css("display", "block");
				$("#messagePage").draggable();
				//$("#messagePage").resizable();
			})
			var $mInput = $("#messagePage>form>input");
			$mInput.eq(1).click(function() {
				$("#messagePage").css("display", "none");
			})

			//添加内容
			$("#addList1").click(function() {
				$("#list1").css("display", "block");
				$("#list1").draggable();
				$("#list1").resizable();
			})
			$("#addList2").click(function() {
				$("#list2").css("display", "block");
				$("#list2").draggable();
				$("#list2").resizable();
			})
		})
		
		
		//保存网页按钮
		function getStyleValue(){
			
			//list1
			if(document.getElementById("list1").getAttribute("style")!=null){
				var inputNode = document.createElement("input");
				inputNode.setAttribute("name","list1");
				inputNode.setAttribute("value",document.getElementById("list1").getAttribute("style"));
				inputNode.setAttribute("hidden","true");
				document.getElementById("actionValue").appendChild(inputNode);
			}
			//list2
			if(document.getElementById("list2").getAttribute("style")!=null){
				var inputNode = document.createElement("input");
				inputNode.setAttribute("name","list2");
				inputNode.setAttribute("value",document.getElementById("list2").getAttribute("style"));
				inputNode.setAttribute("hidden","true");
				document.getElementById("actionValue").appendChild(inputNode);
			}
			//search
			if(document.getElementById("search").getAttribute("style")!=null){
				var inputNode = document.createElement("input");
				inputNode.setAttribute("name","search");
				inputNode.setAttribute("value",document.getElementById("search").getAttribute("style"));
				inputNode.setAttribute("hidden","true");
				document.getElementById("actionValue").appendChild(inputNode);
			}
			
			//nav
			if(document.getElementById("nav").getAttribute("style")!=null){
				var inputNode = document.createElement("input");
				inputNode.setAttribute("name","nav");
				inputNode.setAttribute("value",document.getElementById("nav").getAttribute("style"));
				inputNode.setAttribute("hidden","true");
				document.getElementById("actionValue").appendChild(inputNode);
			}
			//slider
			if(document.getElementById("scrollPic").getAttribute("style")!=null){
				var inputNode = document.createElement("input");
				inputNode.setAttribute("name","slider");
				inputNode.setAttribute("value",document.getElementById("scrollPic").getAttribute("style"));
				inputNode.setAttribute("hidden","true");
				document.getElementById("actionValue").appendChild(inputNode);
			}
			//img
			if(document.getElementById("image").getAttribute("style")!=null){
				var inputNode = document.createElement("input");
				inputNode.setAttribute("name","image");
				inputNode.setAttribute("value",document.getElementById("image").getAttribute("style"));
				inputNode.setAttribute("hidden","true");
				document.getElementById("actionValue").appendChild(inputNode);
			}
			//message
			if(document.getElementById("message").getAttribute("style")!=null){
				var inputNode = document.createElement("input");
				inputNode.setAttribute("name","message");
				inputNode.setAttribute("value",document.getElementById("message").getAttribute("style"));
				inputNode.setAttribute("hidden","true");
				document.getElementById("actionValue").appendChild(inputNode);
			}
			document.getElementById("saveBut").setAttribute("value","已保存");
			document.getElementById("saveBut").setAttribute("onclick","");
			
	
		}
	</script>
</body>
</html>