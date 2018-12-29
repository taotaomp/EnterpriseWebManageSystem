package cn.PApudding.SiteGenerator;

import java.io.File;
import java.io.IOException;

/**
 * ����ɾ��JSPҳ��
 * 
 * @author PApudding
 *
 */
public class SiteJspDeleter {
	/**
	 *  ɾ��վ��JSP�ļ��ķ���
	 * @param ServletRealPath����������ʵ·��
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
