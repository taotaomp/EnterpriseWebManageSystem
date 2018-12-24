package cn.PApudding.SiteGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 用于生成JSP页面
 * @author PApudding
 *
 */
public class SiteJspGenerator {
	private static String beyongHTML = "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\r\n" + 
			"    pageEncoding=\"UTF-8\"%>\r\n" + 
			"<!DOCTYPE html>";
	public static void generateJSP(String ServletRealPath,String jspName,String Content) throws IOException {
		File file = new File(ServletRealPath+"\\jsps\\MainSiteJsp\\"+jspName);
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		bw.write(beyongHTML);
		bw.newLine();
		bw.write(Content);
		bw.close();
	}
	
	
}
