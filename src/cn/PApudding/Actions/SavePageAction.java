package cn.PApudding.Actions;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebPage;
import cn.PApudding.Beans.WebPageToModelBindEntity;
import cn.PApudding.Dao.HibernateUtils;

/**
 * ���󡰱��洴����ҳ�桱ʱ��Action
 * 
 * @author PApudding
 *
 */
public class SavePageAction extends ActionSupport {
	private String pageName;
	private String pageFileCode;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageFileCode() {
		return pageFileCode;
	}

	public void setPageFileCode(String pageFileCode) {
		this.pageFileCode = pageFileCode;
	}

	@Override
	public String execute() throws Exception {
		// ����webPage���󣬲�����ֶ�
		WebPage webPage = new WebPage();
		webPage.setPageName(pageName);
		webPage.setPageFileCode(pageFileCode);

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
					// ��ȡֵ��ֵ�ĸ�ʽΪ�������ݿ�����*������������
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
		// ���webPage��Set�ֶ�
		webPage.setWebPageToModelBindEntities(bindEntities);

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
