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
 * ���󡰱��洴����ҳ�桱ʱ��Action
 * -------------------------------------------------
 * ��Actionά����jsps
 * 			  	  ->LayoutManageJsps
 * 			        ->PageManageJsps
 * 				      ->CreatePageBindDataSource.jsp
 * �б���savePage.action
 * -------------------------------------------------
 * ��Struts2����Զ����յı������ݣ�					
 * 		name:pageName	value:�û������ҳ������
 * 		name:webTemplateToModelBindEntityId_Random[index]  value:ģ��Ϳؼ���ʵ���ID#�����
 * 
 * ʹ��ServletActionContext.getRequest()���������ֶ���ȡ�ı����ݣ�
 * 		name:�����	value:���ݿ���#��������
 * 		name:�����	value:���ݿ���#��������
 * 		......
 * 		name:�����	value:���ݿ���#��������
 *---------------------------------------------------
 * ��Action���ܣ�
 * 	����һ��WebPage�������������ݣ�����̻������ݿ���
 *---------------------------------------------------
 * @author PApudding
 *
 */
public class SavePageAction extends ActionSupport {
	private String pageName;
	//��ʵ��ID#�����
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
		/* ����webPage���󣬸ö���Ϊ����Webҳ�������
		 * -----------------------------------------
		 * ��Ҫ�����ֶΣ�String pageName
		 * 				  String pageFileCode
		 * 				  Set<WebPageToModelBindEntity> webPageToModelBindEntities
		 * ��Hibernate����Զ������ֶΣ�
		 * 				  int id
		 * */
		WebPage webPage = new WebPage();
		
		/*����Ϊ���ɡ���ȡ�����webPage�����pageName��webPageToModelBindEntities�ֶεĴ���
		 *-----------------------------------------------------------------------
		 * */
		//���webPage�����pageName�ֶ�
		webPage.setPageName(pageName);
		//webPage.setPageFileCode(pageFileCode);

		// ����WebPageToModelBindEntity��Set��������������䵽Webpage���ֶ���
		Set<WebPageToModelBindEntity> bindEntities = new HashSet<WebPageToModelBindEntity>();

		// ����WebPageToModelBindEntity�Ķ������ã�����ѭ����ʹ�ã���Ϊ��ʱ����
		WebPageToModelBindEntity webPageToModelBindEntity;

		// ��ȡHttp�������
		HttpServletRequest request = ServletActionContext.getRequest();

		// ��ȡ��������е�ȫ����
		Enumeration<String> randomNums = request.getParameterNames();
		// ѭ�������õ��ļ�����ȡ��Ӧֵ
		while (randomNums.hasMoreElements()) {
			String randomNum = (String) randomNums.nextElement();
			// �жϼ���������ǡ�pageName����pageFileCode����ȡ��ֵ
			if (!randomNum.equals("pageName")) {
				if (!randomNum.equals("pageFileCode")) {
					if(!randomNum.contains("webTemplateToModelBindEntityId_Random")) {
						// ��ȡֵ��ֵ�ĸ�ʽΪ�������ݿ�����#������������
						String[] dbnameAndfield = request.getParameter(randomNum).split("#");
						// ���õ���ֵ���WebPageToModelBindEntity���󣬲���������ӵ�ר��������
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
		// ���webPage��webPageToModelBindEntities�ֶ�
		webPage.setWebPageToModelBindEntities(bindEntities);
		
		/* ����Ϊ����webPage�����pageFileCode�ֶεĴ���
		 * ---------------------------------------------------------------------------------------
		 * */
		//PageCode����
		StringBuilder pageCodeContainer = new StringBuilder();
		//Ϊҳ����ӹ�����ͷ��
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
		//Ϊҳ����ӱ��⣺����ΪpageName(ҳ����)
		pageCodeContainer.append("<title>"+pageName+"</title>");
		//Ϊҳ����ӹ�������ʽ��
		pageCodeContainer.append(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"jsps/MainSiteJsp/css/jquery-ui.min.css\" />\r\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"jsps/MainSiteJsp/css/jquery-ui.css\" />\r\n");
		
		//����ҳ���ϴ��ڵĲ��� Ϊҳ�涯̬���CSS��ʽ
		pageCodeContainer.append("<style type=\"text/css\">\r\n");
		
		//��ȡȫ����  ģ�岿����ģ�͵�  id	��webTemplateToModelBindEntityId_Random��Struts2����Զ���ȡ��
		for(String t2mBindEntityID : webTemplateToModelBindEntityId_Random) {
			//��ȡģ�岿����ʵ��ID
			String bindEntityID = t2mBindEntityID.split("#")[0];
			//ͨ��id�����ݿ��л�ȡ��Ӧ��  ģ�岿����ʵ��
			/*
			 * ģ�岿����ʵ�� WebTemplateToModelBindEntity
			 * �ڲ��ֶΣ�id
			 * 			modelName ��������
			 * 			modelStyleValue ����Css���ִ���
			 * */
			WebTemplateToModelBindEntity bindEntity = (WebTemplateToModelBindEntity) HibernateUtils.getSingleObjectBySql("FROM WebTemplateToModelBindEntity WHERE id = '"+bindEntityID+"'");
			//ͨ��  ģ�岿����ʵ��  ��ȡ����
			WebModel model = (WebModel) HibernateUtils.getSingleObjectBySql("FROM WebModel WHERE modelName = '"+bindEntity.getModelName()+"'");
			//ͨ��ģ���ȡ��CSS����
			String modelCssCode = model.getModeCssCode();
			if(modelCssCode != null) {
				//������װ��JSP����������
				pageCodeContainer.append(modelCssCode);
			}
		}
		pageCodeContainer.append("</style></head><body>");
		
		//����ҳ���ϴ��ڵĲ��� Ϊҳ�涯̬��Ӳ���Html����
		for(String t2mBindEntityID : webTemplateToModelBindEntityId_Random) {
			//��ȡģ�岿����ʵ��ID
			String bindEntityID = t2mBindEntityID.split("#")[0];
			String randomNum = t2mBindEntityID.split("#")[1];
			//ͨ��id��ȡ��Ӧ��  ģ�岿����ʵ��
			WebTemplateToModelBindEntity bindEntity = (WebTemplateToModelBindEntity) HibernateUtils.getSingleObjectBySql("FROM WebTemplateToModelBindEntity WHERE id = '"+bindEntityID+"'");
			
			//�жϲ������ͣ�ͨ������������ȷ��Ҫ֯��Ĳ���Html����
			//������nav�������������֯��
			if(bindEntity.getModelName().equals("nav")) {
				String varName = "nav_"+randomNum;
				String SourceName = "NavBarDefault";	//nav�����������������̶���NavBarDefault��Դ
				String modelHtmlCode = ModelHtmlWaveIn.waveModelForNav(bindEntity.getModelStyleValue(), varName, SourceName);
				pageCodeContainer.append(modelHtmlCode);
			}
			//������list1�������������֯��
			if(bindEntity.getModelName().equals("list1")) {
				String varName = "list1_"+randomNum;
				String SourceName = randomNum;
				String modelHtmlCode = ModelHtmlWaveIn.waveModelForList1(bindEntity.getModelStyleValue(), varName, SourceName);
				pageCodeContainer.append(modelHtmlCode);
			}
			//������list2�������������֯��
			if(bindEntity.getModelName().equals("list2")) {
				String varName = "list2_"+randomNum;
				String SourceName = randomNum;
				String modelHtmlCode = ModelHtmlWaveIn.waveModelForList2(bindEntity.getModelStyleValue(), varName, SourceName);
				pageCodeContainer.append(modelHtmlCode);
			}
			//������image�������������֯��
			if(bindEntity.getModelName().equals("image")) {
				String varName = "image_"+randomNum;
				String SourceName = randomNum;
				String modelHtmlCode = ModelHtmlWaveIn.waveModelForImage(bindEntity.getModelStyleValue(), varName, SourceName);
				pageCodeContainer.append(modelHtmlCode);
			}
			//������slider�������������֯��
			if(bindEntity.getModelName().equals("slider")) {
				String varName = "slider_"+randomNum;
				String SourceName = randomNum;
				String modelHtmlCode = ModelHtmlWaveIn.waveModelForSlider(bindEntity.getModelStyleValue(), varName, SourceName);
				pageCodeContainer.append(modelHtmlCode);
			}
			//������search�������������֯��
			if(bindEntity.getModelName().equals("search")) {
//				String varName = "search_"+randomNum;
//				String SourceName = randomNum;
				WebModel model = (WebModel) HibernateUtils.getSingleObjectBySql("FROM WebModel WHERE modelName = '"+bindEntity.getModelName()+"'");
				String modelHtmlCode = model.getModelHtmlCode();
				pageCodeContainer.append(modelHtmlCode);
			}
			//������message�������������֯��
			if(bindEntity.getModelName().equals("message")) {
//				String varName = "message_"+randomNum;
//				String SourceName = randomNum;
				WebModel model = (WebModel) HibernateUtils.getSingleObjectBySql("FROM WebModel WHERE modelName = '"+bindEntity.getModelName()+"'");
				String modelHtmlCode = model.getModelHtmlCode();
				pageCodeContainer.append(modelHtmlCode);
			}
		}
		
		//����ҳ���ϴ��ڵĲ��� Ϊҳ�涯̬��Ӳ���Js����
		pageCodeContainer.append(
				"	<script src=\"jsps/MainSiteJsp/js/jquery-2.1.0.js\"></script>\r\n" + 
				"	<script src=\"jsps/MainSiteJsp/js/jquery-ui.js\"></script>\r\n" + 
				"	<script src=\"jsps/MainSiteJsp/js/jquery-ui.min.js\"></script>\r\n" + 
				"	<script>\r\n");
		//��ȡȫ����  ģ�岿����ģ��  id
		for(String t2mBindEntityID : webTemplateToModelBindEntityId_Random) {
			//��ȡ��ʵ��ID
			String bindEntityID = t2mBindEntityID.split("#")[0];
			//ͨ��id��ȡ��Ӧ��  ģ�岿����ʵ��
			WebTemplateToModelBindEntity bindEntity = (WebTemplateToModelBindEntity) HibernateUtils.getSingleObjectBySql("FROM WebTemplateToModelBindEntity WHERE id = '"+bindEntityID+"'");
			//ͨ��  ģ�岿����ʵ��  ��ȡģ��
			WebModel model = (WebModel) HibernateUtils.getSingleObjectBySql("FROM WebModel WHERE modelName = '"+bindEntity.getModelName()+"'");
			//ͨ��ģ���ȡ��Js����
			String modelJsCode = model.getModelJs();
			if(modelJsCode != null) {
				//������װ��JSP����������
				pageCodeContainer.append(modelJsCode);
			}
		}
		pageCodeContainer.append(
				"	</script>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		//���webPage��pageFileCode�ֶ�
		webPage.setPageFileCode(pageCodeContainer.toString());
		
		/* 
		 * ����Ϊ��webPage����̻������ݿ�Ĵ���
		 * ---------------------------------------------------------------------------------------
		 * */
		
		/*WebPage�ı�����Ҫ��һ�������ڱ���������
		 * ����WebPage����
		 * 		��������Set<WebPageToModelBindEntity>�����е�WebPageToModelBindEntity����
		 * ʵ�֣�
		 * 	������Ķ����װ��һ��Set<Object>����
		 * 	����HibernateUtils.saveObjects()������ɶ������ı���
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
