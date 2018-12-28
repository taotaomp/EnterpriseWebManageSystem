package cn.PApudding.Actions.PageActions;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Beans.WebBeans.WebPage;
import cn.PApudding.Dao.HibernateUtils;
import cn.PApudding.SiteGenerator.SiteJspGenerator;

/**
 * ���󱣴洴����վ��ʱ��Action
 * ----------------------------------
 * ���ܣ�
 * 	��������վ����.jsp�ļ�����ʽ��
 *  ���浽   %��վ��Ŀ¼·��%/jsps/MainSiteJsp  �ļ�����
 * ----------------------------------
 * ע�⣺
 *  ÿ����Eclipse�ж���Ŀ�������²��𣬽���ʹ������վ�㶪ʧ�� 
 *  
 * @author PApudding
 *
 */
public class SaveSiteAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		//��ȡHttp�������
		HttpServletRequest request = ServletActionContext.getRequest();
		//��ȡ��Ŀ�ڷ������ļ�ϵͳ�µ���ʵ·��
		String servletRealPath = ServletActionContext.getServletContext().getRealPath(".");
		//��ȡȫ������ļ��ֶ�
		Enumeration<String> sitePageNames = request.getParameterNames();
		//����WebPage�����WebLink��������
		WebPage webPage;
		WebLink webLink; 
		//��ʼ�����Ի�ȡ�������Ӧ��ֵ����ֵ�����ݸ�ʽ������վ��ҳ���� ֵ�����ݿ���ҳ����
		while (sitePageNames.hasMoreElements()) {
			//��ȡ��ǰ��
			String sitePageName = (String) sitePageNames.nextElement();
			//��ȡ��ǰֵ
			String pageNameInDB = request.getParameter(sitePageName);
			if(pageNameInDB!=null) {
				//���ݻ�ȡ����ֵ�������ݿ���ȡ��WebPage����
				webPage = (WebPage) HibernateUtils.getSingleObjectBySql("from WebPage where pageName = '"+pageNameInDB+"'");
				//���ɱ��ص�JSP�ļ�
				SiteJspGenerator.generateJSP(servletRealPath, sitePageName, webPage.getPageFileCode());
				
				//����WebLink����
				webLink = new WebLink();
				//���ø�WebLink�����Ӧ������Դ��������
				webLink.setLinkField("NavBarDefault");
				//����������
				webLink.setLinkName(sitePageName);
				//��������ָ���ַ
				webLink.setLinkUrl(ServletActionContext.getRequest().getContextPath()+"/enterMainSite_"+sitePageName+".action?pageId="+webPage.getId());
				//����WebLink���󱣴浽���ݿ���
				HibernateUtils.saveObject(webLink);
			}
		}
		return SUCCESS;
	}
}
