package cn.PApudding.Actions.TemplateActions;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebPageToModelBindEntity;
import cn.PApudding.Beans.WebBeans.WebTemplate;
import cn.PApudding.Beans.WebBeans.WebTemplateToModelBindEntity;
import cn.PApudding.Dao.HibernateUtils;

/*
class WebTemplate
	int id; // id
	String templateName; // 模板的名称
	String templateType; // 模板的类型
	String templateFileCode; // 模板的整体代码
*/
/**
 * 请求“保存创建的模板页面”时的Action
 * 
 * @author PApudding
 *
 */
public class SaveTemplateAction extends ActionSupport {
	private String templateName; // 模板的名称
	private String templateType; // 模板的类型
	
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	@Override
	public String execute() throws Exception {
		// 获取Http请求对象
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取请求对象中的全部键
		Enumeration<String> moduleNames = request.getParameterNames();
		// 创建容器
		WebTemplate webTemplate = new WebTemplate();
		Set<WebTemplateToModelBindEntity> bindEntitySet = new HashSet<WebTemplateToModelBindEntity>();
		WebTemplateToModelBindEntity bindEntity;

		// 循环遍历得到的键，获取对应值
		while (moduleNames.hasMoreElements()) {
			String moduleName = (String) moduleNames.nextElement();
			// 如果键不为模板的名字和类型
			if (!moduleName.equals("templateName")) {
				if (!moduleName.equals("templateType")) {
					bindEntity = new WebTemplateToModelBindEntity();
					bindEntity.setModelName(moduleName);
					String styleValue = request.getParameter(moduleName);
					bindEntity.setModelStyleValue(styleValue);
					bindEntitySet.add(bindEntity);
				}
			}
		}

		// 填充webTemplate的Set字段
		webTemplate.setTemplateToModelBindEntities(bindEntitySet);
		webTemplate.setTemplateName(templateName);
		webTemplate.setTemplateType(templateType);
		// 存储对象到数据库中
		Set<Object> ocToStore = new HashSet<Object>();
		for (Object objects : bindEntitySet) {
			ocToStore.add(objects);
		}
		ocToStore.add(webTemplate);
		HibernateUtils.saveObjects(ocToStore);
		return SUCCESS;
	}
}
