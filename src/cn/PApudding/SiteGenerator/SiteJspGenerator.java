package cn.PApudding.SiteGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 用于生成JSP页面
 * 
 * @author PApudding
 *
 */
public class SiteJspGenerator {
	/**
	 * 生成站点JSP文件的方法
	 * 
	 * @param ServletRealPath 服务器的真实路径
	 * @param jspName
	 * @param Content
	 * @throws IOException
	 */
	public static void generateJSP(String ServletRealPath, String jspName, String Content) throws IOException {
//		File file = new File(ServletRealPath+"\\jsps\\MainSiteJsp\\"+jspName);
		// 使用系统无关的File.separatorChar(路径分隔符)win:\\,linux:/
		File file = new File(ServletRealPath + File.separatorChar + "jsps" + File.separatorChar + "MainSiteJsp"
				+ File.separatorChar + jspName + ".jsp");
		// 判断文件是否存在，不存在则创建文件
		if (!file.exists()) {
			file.createNewFile();
		}
		// 文件字符输出流
		FileWriter fileWriter = new FileWriter(file);
		// 带缓冲的输出流
		BufferedWriter bw = new BufferedWriter(fileWriter);
		// 写入文件
		if(Content!=null) {
			bw.write(Content);
		}
		bw.close();
	}

}
