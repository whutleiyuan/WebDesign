package com.ly.control;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.ly.service.GatherService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 汇总
 * @author leiyuan
 *
 */
@SuppressWarnings("serial")
public class GatherAction extends ActionSupport {
	// 注入汇总的业务逻辑组件
	private GatherService gs;
	//封装库存时间
	private String time;
	//封装分类选择
	private String classify;

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public GatherService getGs() {
		return gs;
	}

	public void setGs(GatherService gs) {
		this.gs = gs;
	}

	// 获取为未汇总的表头
	@SuppressWarnings("rawtypes")
	public String execute() {
		List list = gs.findungather();
		if (list != null) {
			if(getClassify()!=null){
				ServletActionContext.getRequest().setAttribute("classify", getClassify());
				ServletActionContext.getServletContext().setAttribute("list", list);
				System.out.println("归类"+getClassify());

			}else{
				ServletActionContext.getServletContext().setAttribute("list", list);

			}
			return INPUT;
		} else {
			return ERROR;
		}

	}
	//按库存时间汇总
	@SuppressWarnings({ "rawtypes", "unused" })
	public String hasgather(){
    //调用GatherService的hasgather()方法按库存时间汇总
		 Map<String,List> timemap=gs.hasgather(getTime());
		return null;
		
	}
}
