package cn.PApudding.Actions.TemplateActions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.PApudding.Dao.HibernateUtils;
/* WebModel
	 int id; // id
	 String modelName; // �ؼ�����
	 String modelType; // �ؼ�����
	 String modelHtmlCode; // �ؼ���html����
	 String modeCssCode; // �ؼ���css��ʽ
	 String modelJs; // �ؼ���Javascript����
*/

/**
 * ���󡰴���ģ��ҳ�桱ʱ��Action
 * 
 * @author PApudding
 *
 */
public class EnterCreateTemplateAction extends ActionSupport {

	

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}
}
