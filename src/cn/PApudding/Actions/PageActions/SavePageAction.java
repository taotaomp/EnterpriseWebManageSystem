package cn.PApudding.Actions.PageActions;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
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
 * -------------------------------------------------
 * 此Action维护：jsps
 * 			  	  ->LayoutManageJsps
 * 			        ->PageManageJsps
 * 				      ->CreatePageBindDataSource.jsp
 * 中表单的savePage.action
 * -------------------------------------------------
 * 由Struts2框架自动接收的表单的内容：					
 * 		name:pageName	value:用户输入的页面名称
 * 		name:webTemplateToModelBindEntityId_Random[index]  value:模板和控件绑定实体的ID#随机数
 * 
 * 使用ServletActionContext.getRequest()从请求中手动提取的表单内容：
 * 		name:随机数	value:数据库名#作用域名
 * 		name:随机数	value:数据库名#作用域名
 * 		......
 * 		name:随机数	value:数据库名#作用域名
 *---------------------------------------------------
 * 此Action功能：
 * 	创建一个WebPage对象，填充对象内容，将其固化到数据库中
 *---------------------------------------------------
 * @author PApudding
 *
 */
public class SavePageAction extends ActionSupport {
	private String pageName;
	//绑定实体ID#随机数
	private ArrayList<String> webTemplateToModelBindEntityId_Random = new ArrayList<String>();

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public ArrayList<String> getWebTemplateToModelBindEntityId_Random() {
		return webTemplateToModelBindEntityId_Random;
	}

	public void setWebTemplateToModelBindEntityId_Random(ArrayList<String> webTemplateToModelBindEntityId_Random) {
		this.webTemplateToModelBindEntityId_Random = webTemplateToModelBindEntityId_Random;
	}

	@Override
	public String execute() throws Exception { 
		/* 创建webPage对象，该对象为整个Web页面的容器
		 * -----------------------------------------
		 * 需要填充的字段：String pageName
		 * 				  String pageFileCode
		 * 				  Set<WebPageToModelBindEntity> webPageToModelBindEntities
		 * 由Hibernate框架自动填充的字段：
		 * 				  int id
		 * */
		WebPage webPage = new WebPage();
		
		/*以下为生成、获取并填充webPage对象的pageName和webPageToModelBindEntities字段的代码
		 *-----------------------------------------------------------------------
		 * */
		//填充webPage对象的pageName字段
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
					if(!randomNum.contains("webTemplateToModelBindEntityId_Random")) {
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
		// 填充webPage的webPageToModelBindEntities字段
		webPage.setWebPageToModelBindEntities(bindEntities);
		
		/* 以下为生成webPage对象的pageFileCode字段的代码
		 * ---------------------------------------------------------------------------------------
		 * */
		//PageCode容器
		StringBuilder pageCodeContainer = new StringBuilder();
		//为页面添加公共的头部
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
		//为页面添加标题：标题为pageName(页面名)
		pageCodeContainer.append("<title>"+pageName+"</title>");
		//为页面添加公共的样式表
		pageCodeContainer.append(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"jsps/MainSiteJsp/css/jquery-ui.min.css\" />\r\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"jsps/MainSiteJsp/css/jquery-ui.css\" />\r\n");
		
		//根据页面上存在的部件 为页面动态添加CSS样式
		pageCodeContainer.append("<style type=\"text/css\">\r\n");
		
		//获取全部的  模板部件绑定模型的  id	（webTemplateToModelBindEntityId_Random由Struts2框架自动获取）
		for(String t2mBindEntityID : webTemplateToModelBindEntityId_Random) {
			//获取模板部件绑定实体ID
			String bindEntityID = t2mBindEntityID.split("#")[0];
			//通过id从数据库中获取对应的  模板部件绑定实体
			/*
			 * 模板部件绑定实体 WebTemplateToModelBindEntity
			 * 内部字段：id
			 * 			modelName 部件名称
			 * 			modelStyleValue 部件Css布局代码
			 * */
			WebTemplateToModelBindEntity bindEntity = (WebTemplateToModelBindEntity) HibernateUtils.getSingleObjectBySql("FROM WebTemplateToModelBindEntity WHERE id = '"+bindEntityID+"'");
			//通过  模板部件绑定实体  获取部件
			WebModel model = (WebModel) HibernateUtils.getSingleObjectBySql("FROM WebModel WHERE modelName = '"+bindEntity.getModelName()+"'");
			//通过模板获取其CSS代码
			String modelCssCode = model.getModeCssCode();
			if(modelCssCode != null) {
				//将代码装入JSP代码容器中
				pageCodeContainer.append(modelCssCode);
			}
		}
		pageCodeContainer.append("</style></head><body>");
		
		//根据页面上存在的部件 为页面动态添加部件Html代码
		for(String t2mBindEntityID : webTemplateToModelBindEntityId_Random) {
			//获取模板部件绑定实体ID
			String bindEntityID = t2mBindEntityID.split("#")[0];
			String randomNum = t2mBindEntityID.split("#")[1];
			//通过id获取对应的  模板部件绑定实体
			WebTemplateToModelBindEntity bindEntity = (WebTemplateToModelBindEntity) HibernateUtils.getSingleObjectBySql("FROM WebTemplateToModelBindEntity WHERE id = '"+bindEntityID+"'");
			
			//判断部件类型，通过部件类型来确定要织入的部件Html代码
			//若存在nav部件，则将其代码织入
			if(bindEntity.getModelName().equals("nav")) {
				String varName = "nav_"+randomNum;
				String SourceName = "NavBarDefault";	//nav代表导航栏，导航栏固定绑定NavBarDefault资源
				String modelHtmlCode = ModelHtmlWaveIn.waveModelForNav(bindEntity.getModelStyleValue(), varName, SourceName);
				pageCodeContainer.append(modelHtmlCode);
			}
			//若存在list1部件，则将其代码织入
			if(bindEntity.getModelName().equals("list1")) {
				String varName = "list1_"+randomNum;
				String SourceName = randomNum;
				String modelHtmlCode = ModelHtmlWaveIn.waveModelForList1(bindEntity.getModelStyleValue(), varName, SourceName);
				pageCodeContainer.append(modelHtmlCode);
			}
			//若存在list2部件，则将其代码织入
			if(bindEntity.getModelName().equals("list2")) {
				String varName = "list2_"+randomNum;
				String SourceName = randomNum;
				String modelHtmlCode = ModelHtmlWaveIn.waveModelForList2(bindEntity.getModelStyleValue(), varName, SourceName);
				pageCodeContainer.append(modelHtmlCode);
			}
			//若存在image部件，则将其代码织入
			if(bindEntity.getModelName().equals("image")) {
				String varName = "image_"+randomNum;
				String SourceName = randomNum;
				String modelHtmlCode = ModelHtmlWaveIn.waveModelForImage(bindEntity.getModelStyleValue(), varName, SourceName);
				pageCodeContainer.append(modelHtmlCode);
			}
			//若存在slider部件，则将其代码织入
			if(bindEntity.getModelName().equals("slider")) {
				String varName = "slider_"+randomNum;
				String SourceName = randomNum;
				String modelHtmlCode = ModelHtmlWaveIn.waveModelForSlider(bindEntity.getModelStyleValue(), varName, SourceName);
				pageCodeContainer.append(modelHtmlCode);
			}
			//若存在search部件，则将其代码织入
			if(bindEntity.getModelName().equals("search")) {
//				String varName = "search_"+randomNum;
//				String SourceName = randomNum;
				WebModel model = (WebModel) HibernateUtils.getSingleObjectBySql("FROM WebModel WHERE modelName = '"+bindEntity.getModelName()+"'");
				String modelHtmlCode = model.getModelHtmlCode();
				pageCodeContainer.append(modelHtmlCode);
			}
			//若存在message部件，则将其代码织入
			if(bindEntity.getModelName().equals("message")) {
//				String varName = "message_"+randomNum;
//				String SourceName = randomNum;
				WebModel model = (WebModel) HibernateUtils.getSingleObjectBySql("FROM WebModel WHERE modelName = '"+bindEntity.getModelName()+"'");
				String modelHtmlCode = model.getModelHtmlCode();
				pageCodeContainer.append(modelHtmlCode);
			}
		}
		
		//根据页面上存在的部件 为页面动态添加部件Js代码
		pageCodeContainer.append(
				"	<script src=\"jsps/MainSiteJsp/js/jquery-2.1.0.js\"></script>\r\n" + 
				"	<script src=\"jsps/MainSiteJsp/js/jquery-ui.js\"></script>\r\n" + 
				"	<script src=\"jsps/MainSiteJsp/js/jquery-ui.min.js\"></script>\r\n" + 
				"	<script>\r\n");
		//获取全部的  模板部件绑定模型  id
		for(String t2mBindEntityID : webTemplateToModelBindEntityId_Random) {
			//获取绑定实体ID
			String bindEntityID = t2mBindEntityID.split("#")[0];
			//通过id获取对应的  模板部件绑定实体
			WebTemplateToModelBindEntity bindEntity = (WebTemplateToModelBindEntity) HibernateUtils.getSingleObjectBySql("FROM WebTemplateToModelBindEntity WHERE id = '"+bindEntityID+"'");
			//通过  模板部件绑定实体  获取模板
			WebModel model = (WebModel) HibernateUtils.getSingleObjectBySql("FROM WebModel WHERE modelName = '"+bindEntity.getModelName()+"'");
			//通过模板获取其Js代码
			String modelJsCode = model.getModelJs();
			if(modelJsCode != null) {
				//将代码装入JSP代码容器中
				pageCodeContainer.append(modelJsCode);
			}
		}
		pageCodeContainer.append(
				"	</script>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		//填充webPage的pageFileCode字段
		webPage.setPageFileCode(pageCodeContainer.toString());
		
		/* 
		 * 以下为将webPage对象固化到数据库的代码
		 * ---------------------------------------------------------------------------------------
		 * */
		
		/*WebPage的保存需要在一个事务内保存多个对象
		 * 包含WebPage对象
		 * 		其依赖的Set<WebPageToModelBindEntity>对象中的WebPageToModelBindEntity对象
		 * 实现：
		 * 	将所需的对象包装成一个Set<Object>集合
		 * 	传入HibernateUtils.saveObjects()方法完成多个对象的保存
		 * */
		Set<Object> ocToStore = new HashSet<Object>();
		for (Object objects : bindEntities) {
			ocToStore.add(objects);
		}
		ocToStore.add(webPage);
		HibernateUtils.saveObjects(ocToStore);
		
		return SUCCESS;
	}
	
}
