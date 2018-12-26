<%@page import="cn.PApudding.Beans.SourceBeans.WebLink"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	list-style: none;
	border: 0;
}

.scrollPicAll {
	width: 500px;
	height: 200px;
	padding: 7px;
	border: 1px solid #ccc;
	margin: 100px auto;
	position: relative;
}

.scrollPicScreen {
	width: 500px;
	height: 200px;
	overflow: hidden;
	position: relative;
}

.scrollPicScreen li {
	width: 500px;
	height: 200px;
	overflow: hidden;
	float: left;
}

.scrollPicScreen ul {
	position: absolute;
	left: 0;
	top: 0px;
	width: 3000px;
}

.scrollPicAll ol {
	position: absolute;
	right: 10px;
	bottom: 10px;
	line-height: 20px;
	text-align: center;
}

.scrollPicAll ol li {
	float: left;
	width: 20px;
	height: 20px;
	background: #fff;
	border: 1px solid #ccc;
	margin-left: 10px;
	cursor: pointer;
}

.scrollPicAll ol li.current {
	background: #DB192A;
}

#scrollPicArr {
	display: none;
}

#scrollPicArr span {
	width: 40px;
	height: 40px;
	position: absolute;
	left: 5px;
	top: 50%;
	margin-top: -20px;
	background: #000;
	cursor: pointer;
	line-height: 40px;
	text-align: center;
	font-weight: bold;
	font-family: '黑体';
	font-size: 30px;
	color: #fff;
	opacity: 0.3;
	border: 1px solid #fff;
}

#scrollPicArr #scrollPicRight {
	right: 5px;
	left: auto;
}
</style>
</head>
<body>
	<div class="scrollPicAll" id='scrollPicBox'>
		<div class="scrollPicScreen">
			<!--相框-->
			<ul>
				<%List<WebLink> list = (List<WebLink>)request.getAttribute("test"); %>
				<%for(WebLink wl:list){ %>
				<li><img src="<%=wl.getLinkUrl() %>" width="500" height="200" /><%=wl.getLinkName() %></li>
				<%} %>
			</ul>
			<ol>
			</ol>
		</div>
		<div id="scrollPicArr">
			<span id="scrollPicLeft">&lt;</span><span id="scrollPicRight">&gt;</span>
		</div>
	</div>
	<!--<script src="common.js"></script>-->
	<script>
		//获取最外面的div
		var scrollPicBox = my$("scrollPicBox");
		//获取相框
		var scrollPicScreen = scrollPicBox.children[0];
		//获取相框的宽度
		var imgWidth = scrollPicScreen.offsetWidth;
		//获取ul
		var ulObj = scrollPicScreen.children[0];
		//获取ul中的所有的li
		var list = ulObj.children;
		//获取ol
		var olObj = scrollPicScreen.children[1];
		//焦点的div
		var scrollPicArr = my$("scrollPicArr");

		var pic = 0;//全局变量
		//创建小按钮----根据ul中的li个数
		for (var i = 0; i < list.length; i++) {
			//创建li标签,加入到ol中
			var liObj = document.createElement("li");
			olObj.appendChild(liObj);
			liObj.innerHTML = (i + 1);
			//在每个ol中的li标签上添加一个自定义属性,存储索引值
			liObj.setAttribute("index", i);
			//注册鼠标进入事件
			liObj.onmouseover = function() {
				//先干掉所有的ol中的li的背景颜色
				for (var j = 0; j < olObj.children.length; j++) {
					olObj.children[j].removeAttribute("class");
				}
				//设置当前鼠标进来的li的背景颜色
				this.className = "current";
				//获取鼠标进入的li的当前索引值
				pic = this.getAttribute("index");
				//移动ul
				animate(ulObj, -pic * imgWidth);
			};
		}
		//设置ol中第一个li有背景颜色
		olObj.children[0].className = "current";

		//克隆一个ul中第一个li,加入到ul中的最后=====克隆
		ulObj.appendChild(ulObj.children[0].cloneNode(true));

		//自动播放
		var timeId = setInterval(clickHandle, 1000);

		//鼠标进入到scrollPicBox的div显示左右焦点的div
		scrollPicBox.onmouseover = function() {
			scrollPicArr.style.display = "block";
			//鼠标进入废掉之前的定时器
			clearInterval(timeId);
		};
		//鼠标离开到scrollPicBox的div隐藏左右焦点的div
		scrollPicBox.onmouseout = function() {
			scrollPicArr.style.display = "none";
			//鼠标离开自动播放
			timeId = setInterval(clickHandle, 1000);
		};
		//右边按钮
		my$("scrollPicRight").onclick = clickHandle;
		function clickHandle() {
			//如果pic的值是5,恰巧是ul中li的个数-1的值,此时页面显示第六个图片,而用户会认为这是第一个图,
			//所以,如果用户再次点击按钮,用户应该看到第二个图片
			if (pic == list.length - 1) {
				//如何从第6个图,跳转到第一个图
				pic = 0;//先设置pic=0
				ulObj.style.left = 0 + "px";//把ul的位置还原成开始的默认位置
			}
			pic++;//立刻设置pic加1,那么此时用户就会看到第二个图片了
			animate(ulObj, -pic * imgWidth);//pic从0的值加1之后,pic的值是1,然后ul移动出去一个图片
			//如果pic==5说明,此时显示第6个图(内容是第一张图片),第一个小按钮有颜色,
			if (pic == list.length - 1) {
				//第五个按钮颜色干掉
				olObj.children[olObj.children.length - 1].className = "";
				//第一个按钮颜色设置上
				olObj.children[0].className = "current";
			} else {
				//干掉所有的小按钮的背景颜色
				for (var i = 0; i < olObj.children.length; i++) {
					olObj.children[i].removeAttribute("class");
				}
				olObj.children[pic].className = "current";
			}

		};
		//左边按钮
		my$("scrollPicLeft").onclick = function() {
			if (pic == 0) {
				pic = 5;
				ulObj.style.left = -pic * imgWidth + "px";
			}
			pic--;
			animate(ulObj, -pic * imgWidth);
			//设置小按钮的颜色---所有的小按钮干掉颜色
			for (var i = 0; i < olObj.children.length; i++) {
				olObj.children[i].removeAttribute("class");
			}
			//当前的pic索引对应的按钮设置颜色
			olObj.children[pic].className = "current";

		};

		//设置任意的一个元素,移动到指定的目标位置
		function animate(element, target) {
			clearInterval(element.timeId);
			//定时器的id值存储到对象的一个属性中
			element.timeId = setInterval(function() {
				//获取元素的当前的位置,数字类型
				var current = element.offsetLeft;
				//每次移动的距离
				var step = 10;
				step = current < target ? step : -step;
				//当前移动到位置
				current += step;
				if (Math.abs(current - target) > Math.abs(step)) {
					element.style.left = current + "px";
				} else {
					//清理定时器
					clearInterval(element.timeId);
					//直接到达目标
					element.style.left = target + "px";
				}
			}, 10);
		}

		//根据id获取元素对象
		function my$(id) {
			return document.getElementById(id);
		}
	</script>
</body>
</html>