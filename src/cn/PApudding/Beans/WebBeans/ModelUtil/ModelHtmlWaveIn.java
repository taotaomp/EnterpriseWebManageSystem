package cn.PApudding.Beans.WebBeans.ModelUtil;
/**
 * ����model����֯�����
 * @author PApudding
 *
 */
public class ModelHtmlWaveIn {
	/**
	 * ֯�뵼��������
	 * @param layoutStyle ģ��Ĳ����ַ���
	 * @param varName �ڲ�����������
	 * @param SourceName ��Դ����һ��Ϊ�������
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
	 * ֯����������������
	 * @param layoutStyle ģ��Ĳ����ַ���
	 * @param varName �ڲ�����������
	 * @param SourceName ��Դ����һ��Ϊ�������
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
	 * ֯����ҳ����������
	 * @param layoutStyle ģ��Ĳ����ַ���
	 * @param varName �ڲ�����������
	 * @param SourceName ��Դ����һ��Ϊ�������
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
	 * ֯��ͼƬ�����
	 * @param layoutStyle ģ��Ĳ����ַ���
	 * @param varName �ڲ�����������
	 * @param SourceName ��Դ����һ��Ϊ�������
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
	 * ֯��ͼƬ���Բ�������
	 * @param layoutStyle ģ��Ĳ����ַ���
	 * @param varName �ڲ�����������
	 * @param SourceName ��Դ����һ��Ϊ�������
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
				"	  <!--��ͷ-->\r\n" + 
				"	  <div class=\"arrow\">\r\n" + 
				"	    <span class=\"arrow-left\">&lt;</span>\r\n" + 
				"	    <span class=\"arrow-right\">&gt;</span>\r\n" + 
				"	  </div>\r\n" + 
				"</div>";
	}
	
	
}
