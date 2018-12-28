package cn.PApudding.SiteGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ��������JSPҳ��
 * 
 * @author PApudding
 *
 */
public class SiteJspGenerator {
	/**
	 * ����վ��JSP�ļ��ķ���
	 * 
	 * @param ServletRealPath ����������ʵ·��
	 * @param jspName
	 * @param Content
	 * @throws IOException
	 */
	public static void generateJSP(String ServletRealPath, String jspName, String Content) throws IOException {
//		File file = new File(ServletRealPath+"\\jsps\\MainSiteJsp\\"+jspName);
		// ʹ��ϵͳ�޹ص�File.separatorChar(·���ָ���)win:\\,linux:/
		File file = new File(ServletRealPath + File.separatorChar + "jsps" + File.separatorChar + "MainSiteJsp"
				+ File.separatorChar + jspName + ".jsp");
		// �ж��ļ��Ƿ���ڣ��������򴴽��ļ�
		if (!file.exists()) {
			file.createNewFile();
		}
		// �ļ��ַ������
		FileWriter fileWriter = new FileWriter(file);
		// ������������
		BufferedWriter bw = new BufferedWriter(fileWriter);
		// д���ļ�
		if(Content!=null) {
			bw.write(Content);
		}
		bw.close();
	}

}
