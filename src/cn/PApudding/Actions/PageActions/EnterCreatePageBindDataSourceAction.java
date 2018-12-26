package cn.PApudding.Actions.PageActions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebTemplate;
import cn.PApudding.Dao.HibernateUtils;

/**
 * ������Դ�������action
 * @author PApudding
 *
 */
public class EnterCreatePageBindDataSourceAction extends ActionSupport{
	private String webTemplateName;	//��ҳģ����

	public String getWebTemplateName() {
		return webTemplateName;
	}

	public void setWebTemplateName(String webTemplateName) {
		this.webTemplateName = webTemplateName;
	}
	
	@Override
	public String execute() throws Exception {
		WebTemplate webTemplate = (WebTemplate) HibernateUtils.getSingleObjectBySql("FROM WebTemplate WHERE templateName = "+ webTemplateName);
		if(webTemplate==null) {
			return ERROR;
		}
		
		return SUCCESS;
	}
}
