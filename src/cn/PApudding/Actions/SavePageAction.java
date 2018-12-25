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
 * 请求“保存创建的页面”时的Action
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
		// 创建webPage对象，并填充字段
		WebPage webPage = new WebPage();
		webPage.setPageName(pageName);
		webPage.setPageFileCode(pageFileCode);

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
					// 获取值，值的格式为：“数据库名”*“作用域名”
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
		// 填充webPage的Set字段
		webPage.setWebPageToModelBindEntities(bindEntities);

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
