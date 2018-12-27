package cn.PApudding.Beans.WebBeans.ModelUtil;
/**
 * 根据model类型织入代码
 * @author PApudding
 *
 */
public class ModelHtmlWaveIn {
	/**
	 * 织入导航栏代码
	 * @param layoutStyle 模块的布局字符串
	 * @param varName 内部遍历变量名
	 * @param SourceName 资源名（一般为随机数）
	 * @return
	 */
	public static String waveModelForNav(String layoutStyle,String varName,String SourceName) {
		return  "<div id=\"nav\" style=\""+layoutStyle+"\">\r\n" + 
				"	<ul>\r\n" + 
				"		<%\r\n" + 
				"			List<WebLink> "+varName+" = (List<WebLink>) request.getAttribute(\""+SourceName+"\");\r\n" + 
				"			for(WebLink webLink :"+varName+"){\r\n" + 
				"		%>\r\n" + 
				"			<li>\r\n" + 
				"				<a href=\"${pageContext.request.contextPath}<%=webLink.getLinkUrl()%>\">\r\n" + 
				"					<%=webLink.getLinkName() %>\r\n" + 
				"				</a>\r\n" + 
				"			</li>\r\n" + 
				"		<%\r\n" + 
				"			}\r\n" + 
				"		%>\r\n" +
				"	</ul>\r\n" + 
				"</div>";
	}
	
	/**
	 * 织入文章链接栏代码
	 * @param layoutStyle 模块的布局字符串
	 * @param varName 内部遍历变量名
	 * @param SourceName 资源名（一般为随机数）
	 * @return
	 */
	public static String waveModelForList1(String layoutStyle,String varName,String SourceName) {
		return "<div id=\"list1\" style=\""+layoutStyle+"\">\r\n" + 
				"	<ul>\r\n" + 
				"		<%\r\n" + 
				"			List<WebLink> "+varName+" = (List<WebLink>)request.getAttribute(\""+SourceName+"\");\r\n" + 
				"			for(WebLink link : "+varName+"){\r\n" + 
				"		%>\r\n" + 
				"			<li><a href=\"<%=link.getLinkUrl()%>\"><%=link.getLinkName() %></a></li>\r\n" + 
				"		<%\r\n" + 
				"			}\r\n" + 
				"		%>\r\n" + 
				"	</ul>\r\n" + 
				"</div>";
	}
	
	/**
	 * 织入网页链接栏代码
	 * @param layoutStyle 模块的布局字符串
	 * @param varName 内部遍历变量名
	 * @param SourceName 资源名（一般为随机数）
	 * @return
	 */
	public static String waveModelForList2(String layoutStyle,String varName,String SourceName) {
		return "<div id=\"list2\" style=\""+layoutStyle+"\">\r\n" + 
				"	<ul>\r\n" + 
				"		<%\r\n" + 
				"			List<WebLink> "+varName+" = (List<WebLink>)request.getAttribute(\""+SourceName+"\");\r\n" + 
				"			for(WebLink link : "+varName+"){\r\n" + 
				"		%>\r\n" + 
				"			<li><a href=\"<%=link.getLinkUrl()%>\"><%=link.getLinkName() %></a></li>\r\n" + 
				"		<%\r\n" + 
				"			}\r\n" + 
				"		%>\r\n" + 
				"	</ul>\r\n" + 
				"</div>";
	}
	
	/**
	 * 织入图片框代码
	 * @param layoutStyle 模块的布局字符串
	 * @param varName 内部遍历变量名
	 * @param SourceName 资源名（一般为随机数）
	 * @return
	 */
	public static String waveModelForImage(String layoutStyle,String varName,String SourceName) {
		return "<div id=\"image\" style=\""+layoutStyle+"\">\r\n" + 
				"	<%\r\n" + 
				"		List<WebMediaSource> "+varName+" = (List<WebMediaSource>) request.getAttribute(\""+SourceName+"\");\r\n" + 
				"	%>\r\n" + 
				"	<img src=\"<%="+varName+".get(0)%>\">\r\n" + 
				"</div>";
	}
	
	/**
	 * 织入图片轮显部件代码
	 * @param layoutStyle 模块的布局字符串
	 * @param varName 内部遍历变量名
	 * @param SourceName 资源名（一般为随机数）
	 * @return
	 */
	public static String waveModelForSlider(String layoutStyle,String varName,String SourceName) {
		return "<div class=\"slider\" style=\""+layoutStyle+"\">\r\n" + 
				"	  <ul>\r\n" + 
				"	  <%\r\n" + 
				"	  	List<WebMediaSource> "+varName+" = (List<WebMediaSource>)request.getAttribute(\""+SourceName+"\");\r\n" + 
				"	  	for(WebMediaSource mediaSource :"+varName+"){\r\n" + 
				"	  %>\r\n" + 
				"	  	<li><img src=\"<%=mediaSource.getMediaUrl() %>\" alt=\"\"></li>\r\n" + 
				"	  <%\r\n" + 
				"	  	}\r\n" + 
				"	  %>\r\n" + 
				"	  </ul>\r\n" + 
				"	  <!--箭头-->\r\n" + 
				"	  <div class=\"arrow\">\r\n" + 
				"	    <span class=\"arrow-left\">&lt;</span>\r\n" + 
				"	    <span class=\"arrow-right\">&gt;</span>\r\n" + 
				"	  </div>\r\n" + 
				"</div>";
	}
	
	
}
