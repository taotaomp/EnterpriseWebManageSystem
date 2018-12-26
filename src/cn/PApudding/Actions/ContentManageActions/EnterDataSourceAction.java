package cn.PApudding.Actions.ContentManageActions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;

/**
 * 进入特定数据源的Action
 * @author PApudding
 *
 */
public class EnterDataSourceAction extends ActionSupport{
	private String databaseName;	//数据库名
	private String dataField;	//数据源名（Field）
	
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
			//获取指定数据源的全部对象放入集合
			List<Object> list = HibernateUtils.getObjectsByField(databaseName, dataField);
			ServletActionContext.getRequest().setAttribute("data", list);
			//放入数据库名和数据源名
			ServletActionContext.getRequest().setAttribute("dataField", dataField);
			ServletActionContext.getRequest().setAttribute("databaseName", databaseName);
			return SUCCESS;
		}
}
