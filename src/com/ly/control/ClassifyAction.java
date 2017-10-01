package com.ly.control;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 归类处理
 * @author leiyuan
 *
 */

@SuppressWarnings("serial")
public class ClassifyAction extends ActionSupport{
	//封装归类方式
	private String classify;
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String classify() {
		System.out.println("归类选择为"+getClassify() );
		if(classify!=null){
			ServletActionContext.getRequest().setAttribute("classifysel", getClassify() );
		}
		return INPUT;
		
	}
}
