package cn.PApudding.Actions.PageActions;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebModel;
import cn.PApudding.Beans.WebBeans.WebPage;
import cn.PApudding.Beans.WebBeans.WebPageToModelBindEntity;
import cn.PApudding.Beans.WebBeans.WebTemplateToModelBindEntity;
import cn.PApudding.Beans.WebBeans.ModelUtil.ModelHtmlWaveIn;
import cn.PApudding.Dao.HibernateUtils;

/**
 * 请求“保存创建的页面”时的Action
 * 
 * @author PApudding
 *
 */
public class SavePageAction extends ActionSupport {
	private String pageName;
	private ArrayList<String> webTemplateToModelBindEntityId = new ArrayList<String>();

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public ArrayList<String> getWebTemplateToModelBindEntityId() {
		return webTemplateToModelBindEntityId;
	}

	public void setWebTemplateToModelBindEntityId(ArrayList<String> webTemplateToModelBindEntityId) {
		this.webTemplateToModelBindEntityId = webTemplateToModelBindEntityId;
	}

	@Override
	public String execute() throws Exception {
		// 创建webPage对象，并填充字段
		WebPage webPage = new WebPage();
		webPage.setPageName(pageName);
		//webPage.setPageFileCode(pageFileCode);

		// 创建WebPageToModelBindEntity的Set容器，后续会填充到Webpage的字段中
		Set<WebPageToModelBindEntity> bindEntities = new HashSet<WebPageToModelBindEntity>();

		// 创建WebPageToModelBindEntity的对象引用，后续循环会使用，作为临时变量
		WebPageToModelBindEntity webPageToModelBindEntity;

		// 获取Http请求对象
		HttpServletRequest request = ServletActionContext.getRequest();

		// 获取请求对象中的全部键
		Enumeration<String> randomNums = request.getParameterNames();
		// 循环遍历得到的键，获取对应值
		while (randomNums.hasMoreElements()) {
			String randomNum = (String) randomNums.nextElement();
			// 判断键名，如果是“pageName”或“pageFileCode”则不取其值
			if (!randomNum.equals("pageName")) {
				if (!randomNum.equals("pageFileCode")) {
					if(!randomNum.contains("modelName")) {
						// 获取值，值的格式为：“数据库名”#“作用域名”
						String[] dbnameAndfield = request.getParameter(randomNum).split("#");
						// 将得到的值填充WebPageToModelBindEntity对象，并将对象添加到专属容器中
						webPageToModelBindEntity = new WebPageToModelBindEntity();
						webPageToModelBindEntity.setModelRandomNumber(Integer.parseInt(randomNum));
						webPageToModelBindEntity.setDataTableName(dbnameAndfield[0]);
						webPageToModelBindEntity.setDataSourceField(dbnameAndfield[1]);
						webPageToModelBindEntity.setWebPage(webPage);
						bindEntities.add(webPageToModelBindEntity);
					}
				}
			}
		}
		// 填充webPage的Set字段
		webPage.setWebPageToModelBindEntities(bindEntities);
		//PageCode生成
		StringBuilder pageCodeContainer = new StringBuilder();
		String jspHead = 
				"<%@page import=\"cn.PApudding.Beans.SourceBeans.WebMediaSource\"%>\r\n" + 
				"<%@page import=\"cn.PApudding.Beans.SourceBeans.WebLink\"%>\r\n" + 
				"<%@page import=\"cn.PApudding.Beans.SourceBeans.WebEssay\"%>\r\n" +
				"<%@page import=\"java.util.List\"%>\r\n" + 
				"<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\r\n" + 
				"    pageEncoding=\"UTF-8\"%>\r\n" +
				"<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n";
		pageCodeContainer.append(jspHead);
		pageCodeContainer.append("<title>"+pageName+"</title>");
		pageCodeContainer.append("<style type=\"text/css\">");
		
		//获取全部的  模板部件绑定模型  id
		for(String t2mBindEntityID : webTemplateToModelBindEntityId) {
			//通过id获取对应的  模板部件绑定模型
			WebTemplateToModelBindEntity bindEntity = (WebTemplateToModelBindEntity) HibernateUtils.getSingleObjectBySql("FROM WebTemplateToModelBindEntity WHERE id = '"+t2mBindEntityID+"'");
			//通过  模板部件绑定模型  获取模板
			WebModel model = (WebModel) HibernateUtils.getSingleObjectBySql("FROM WebModel WHERE modelName = '"+bindEntity.getModelName()+"'");
			//通过模板获取其CSS代码
			String modelCssCode = model.getModeCssCode();
			if(modelCssCode != null) {
				//将代码装入JSP代码容器中
				pageCodeContainer.append(modelCssCode);
			}
		}
		
		pageCodeContainer.append("</style></head><body>");
		
		for(String t2mBindEntityID : webTemplateToModelBindEntityId) {
			//通过id获取对应的  模板部件绑定模型
			WebTemplateToModelBindEntity bindEntity = (WebTemplateToModelBindEntity) HibernateUtils.getSingleObjectBySql("FROM WebTemplateToModelBindEntity WHERE id = '"+t2mBindEntityID+"'");
			if(bindEntity.getModelName().equals("nav")) {
				Random random = new Random();
				String varName = "nav_"+random.nextInt(1000);
				String SourceName = Integer.toString((random.nextInt(10000)));
				ModelHtmlWaveIn.waveModelForNav(bindEntity.getModelStyleValue(), varName, SourceName);
			}
		}
		

		// 存储对象到数据库中
		Set<Object> ocToStore = new HashSet<Object>();
		for (Object objects : bindEntities) {
			ocToStore.add(objects);
		}
		ocToStore.add(webPage);
		HibernateUtils.saveObjects(ocToStore);
		return SUCCESS;
	}
	
}
