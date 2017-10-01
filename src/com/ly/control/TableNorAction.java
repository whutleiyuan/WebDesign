package com.ly.control;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ly.model.TableName;
import com.ly.service.NorService;
import com.opensymphony.xwork2.ActionSupport;

public class TableNorAction extends ActionSupport {

	/**
	 * 对表进行归一化
	 * @author leiyuan
	 */
	private static final long serialVersionUID = 127068517248912446L;
	// 注入业务逻辑组件NorService所需的实例
	private NorService ns;
	// 封装选中表头的值
	private String[] tableheader;
	// 封装选中的表头对应的复选框
	private int[] checkbox;
	// 封装对选中表头对应的排序序号
	private String[] headersort;
	// 封装归一化所的表的表名
	private String tablename;
	//存储表名
	private TableName tn;

	public TableName getTn() {
		return tn;
	}

	public void setTn(TableName tn) {
		this.tn = tn;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public NorService getNs() {
		return ns;
	}

	public void setNs(NorService ns) {
		this.ns = ns;
	}

	public String[] getTableheader() {
		return tableheader;
	}

	public void setTableheader(String[] tableheader) {
		this.tableheader = tableheader;
	}

	public int[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(int[] checkbox) {
		this.checkbox = checkbox;
	}

	public String[] getHeadersort() {
		return headersort;
	}

	public void setHeadersort(String[] headersort) {
		this.headersort = headersort;
	}

	// 对表头进行归一化
	@SuppressWarnings("rawtypes")
	public String execute() {
		// 调用业务逻辑组件的tableheadernor()方法来对选中的表头进行归一化
		if (getCheckbox() != null) {
			List tablelist = ns.tableheadernor(getTableheader(), getCheckbox(), getHeadersort());
			if (tablelist != null) {
				ServletActionContext.getServletContext().setAttribute("tablelist", tablelist);
				return INPUT;
			}
		}
		return ERROR;

	}

	// 填充数据
	@SuppressWarnings("rawtypes")
	public String fulfillData() {
		System.out.println("开始填充数据");
		// 调用业务逻辑组件对选中的表头填充数据
		Map<String, List> map = ns.fulfillData(getTableheader());
		// 将获得的数据放入request范围中
		if (!map.isEmpty()) {
			ServletActionContext.getRequest().setAttribute("map", map);
			ServletActionContext.getRequest().setAttribute("flag", "haovalue");
			ServletActionContext.getRequest().setAttribute("isfulfill", "isfulfill");
			System.out.println("map集合非空");
			for (Map.Entry<String, List> entry : map.entrySet()) {
				String tableheader = entry.getKey();
				if (tableheader.equals("发件地址邮编")) {
					List listTest = entry.getValue();
					for (int j = 0; j < listTest.size(); j++) {
						System.out.println("发件人数据：" + listTest.get(j));
					}
				}
			}
		}
		return INPUT;

	}

	// 保存选择的表
	public String saveTable() {
		/*
		 * System.out.println("开始进行游戏保存"); System.out.println(getTablename());
		 */
		// 调用业务逻辑组件的saveTable（）方法来创建表
		int issucc = ns.savaTable(getTablename(), getTableheader());
		//将表名保存到数据库中
		tn.setName(tablename);
		System.out.println("112345677"+tn.getName());
		ns.saveTableName(tn);
		
		if (issucc > 0) {
			return INPUT;
		}else{
			return ERROR;
		}

	}

}
