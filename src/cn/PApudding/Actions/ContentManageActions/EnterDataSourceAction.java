package cn.PApudding.Actions.ContentManageActions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;

/**
 * �����ض�����Դ��Action
 * @author PApudding
 *
 */
public class EnterDataSourceAction extends ActionSupport{
	private String databaseName;	//���ݿ���
	private String dataField;	//����Դ����Field��
	
	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDataField() {
		return dataField;
	}

	public void setDataField(String dataField) {
		this.dataField = dataField;
	}

	@Override
		public String execute() throws Exception {
			//��ȡָ������Դ��ȫ��������뼯��
			List<Object> list = HibernateUtils.getObjectsByField(databaseName, dataField);
			ServletActionContext.getRequest().setAttribute("data", list);
			//�������ݿ���������Դ��
			ServletActionContext.getRequest().setAttribute("dataField", dataField);
			ServletActionContext.getRequest().setAttribute("databaseName", databaseName);
			return SUCCESS;
		}
}
