package cn.PApudding.SiteGenerator;

import java.io.File;
import java.io.IOException;

/**
 * 用于删除JSP页面
 * 
 * @author PApudding
 *
 */
public class SiteJspDeleter {
	/**
	 *  删除站点JSP文件的方法
	 * @param ServletRealPath服务器的真实路径
	 * @param jspName
	 * @throws IOException
	 */
	public static void deleteJSP(String ServletRealPath, String jspName) throws IOException {
		File file = new File(ServletRealPath + File.separatorChar + "jsps" + File.separatorChar + "MainSiteJsp"
				+ File.separatorChar + jspName + ".jsp");
		if(!file.exists()) {
			return ;
		}
		file.delete();
	}
}
