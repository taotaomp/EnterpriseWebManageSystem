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
 * ���󡰱��洴����ҳ�桱ʱ��Action
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
		// ����webPage���󣬲�����ֶ�
		WebPage webPage = new WebPage();
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
					if(!randomNum.contains("modelName")) {
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
		// ���webPage��Set�ֶ�
		webPage.setWebPageToModelBindEntities(bindEntities);
		//PageCode����
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
		
		//��ȡȫ����  ģ�岿����ģ��  id
		for(String t2mBindEntityID : webTemplateToModelBindEntityId) {
			//ͨ��id��ȡ��Ӧ��  ģ�岿����ģ��
			WebTemplateToModelBindEntity bindEntity = (WebTemplateToModelBindEntity) HibernateUtils.getSingleObjectBySql("FROM WebTemplateToModelBindEntity WHERE id = '"+t2mBindEntityID+"'");
			//ͨ��  ģ�岿����ģ��  ��ȡģ��
			WebModel model = (WebModel) HibernateUtils.getSingleObjectBySql("FROM WebModel WHERE modelName = '"+bindEntity.getModelName()+"'");
			//ͨ��ģ���ȡ��CSS����
			String modelCssCode = model.getModeCssCode();
			if(modelCssCode != null) {
				//������װ��JSP����������
				pageCodeContainer.append(modelCssCode);
			}
		}
		
		pageCodeContainer.append("</style></head><body>");
		
		for(String t2mBindEntityID : webTemplateToModelBindEntityId) {
			//ͨ��id��ȡ��Ӧ��  ģ�岿����ģ��
			WebTemplateToModelBindEntity bindEntity = (WebTemplateToModelBindEntity) HibernateUtils.getSingleObjectBySql("FROM WebTemplateToModelBindEntity WHERE id = '"+t2mBindEntityID+"'");
			if(bindEntity.getModelName().equals("nav")) {
				Random random = new Random();
				String varName = "nav_"+random.nextInt(1000);
				String SourceName = Integer.toString((random.nextInt(10000)));
				ModelHtmlWaveIn.waveModelForNav(bindEntity.getModelStyleValue(), varName, SourceName);
			}
		}
		

		// �洢�������ݿ���
		Set<Object> ocToStore = new HashSet<Object>();
		for (Object objects : bindEntities) {
			ocToStore.add(objects);
		}
		ocToStore.add(webPage);
		HibernateUtils.saveObjects(ocToStore);
		return SUCCESS;
	}
	
}
