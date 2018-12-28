package cn.PApudding.Actions.MainSiteActions;

import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebEssay;
import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Beans.WebBeans.WebPage;
import cn.PApudding.Beans.WebBeans.WebPageToModelBindEntity;
import cn.PApudding.Dao.HibernateUtils;

/**
 * ������վ�����Action��������վ���������ӳ��
 * 
 * @author PApudding
 *
 */
public class EnterMainSiteAction extends ActionSupport {
	private String pageId;

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	@Override
	public String execute() throws Exception {
		/*���ҳ��idΪ�գ��������Դ��Ѱ������Ϊindex�����ӣ�����ҳ�����ӣ�
		 * �������л�ȡpageId����䵽��Action��pageId��
		 * */
		if (pageId == null) {
			WebLink link = (WebLink) HibernateUtils.getSingleObjectBySql("FROM WebLink WHERE linkName = 'index'");
			String linkUrl = link.getLinkUrl();
			pageId = linkUrl.split("=")[1];
		}
		//ͨ��pageId��ȡWebPage����
		WebPage page = (WebPage) HibernateUtils.getSingleObjectBySql("FROM WebPage WHERE id = '" + pageId + "'");
		/*
		 * ͨ��WebPage�����ȡSet<WebPageToModelBindEntity>(ҳ��ģ���ʵ�弯��)
		 * WebPageToModelBindEntity�����ֶΣ�
		 * 				int id; // id
		 *				int modelRandomNumber; // �����������ҳ������Դ��ȡ��λ
	 	 *				String dataTableName; // ���ݿ���
	 	 *				String dataSourceField; // ����Դ�������ݿ�������
	 	 *				WebPage webPage; // ҳ��
		 * */
		Set<WebPageToModelBindEntity> modelBindEntities = page.getWebPageToModelBindEntities();
		
		//����WebPageToModelBindEntity����
		for (WebPageToModelBindEntity modelbindEntity : modelBindEntities) {
			/*ͨ��WebPageToModelBindEntity�е����ݿ���������Դ����ȡ��Դ��
			 * ������Դ��WebPageToModelBindEntity�е������Ϊ�����������������
			 * */
			List<Object> dataList = HibernateUtils.getObjectsByField(modelbindEntity.getDataTableName(),
					modelbindEntity.getDataSourceField());
			ServletActionContext.getRequest().setAttribute(Integer.toString(modelbindEntity.getModelRandomNumber()),
					dataList);
		}
		// װ�ص�����
		List<Object> NavBarLinks = HibernateUtils.getObjectsByField("WebLink", "NavBarDefault");
		ServletActionContext.getRequest().setAttribute("NavBarDefault", NavBarLinks);

		return SUCCESS;
	}
}
