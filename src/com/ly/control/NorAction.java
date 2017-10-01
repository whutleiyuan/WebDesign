package com.ly.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ly.service.NorService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用来拦截归一化的请求并返回最终的处理结果
 * @author leiyuan
 *
 */

public class NorAction extends ActionSupport{
	private static final long serialVersionUID = -3250449205225698653L;
	//注入业务逻辑组件NorService所需的实例
	private NorService ns;
	//封装表头选择的值
	private String[] checkbox;
	//封装表头的值
	private String[] tableheader;
	public String[] getTableheader() {
		return tableheader;
	}
	public void setTableheader(String[] tableheader) {
		this.tableheader = tableheader;
	}
	public NorService getNs() {
		return ns;
	}
	public void setNs(NorService ns) {
		this.ns = ns;
	}
	public String[] getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
	//抽出所有表头
	public String execute(){     
		//调用NorService的findTableHeader()方法，得到所有的表头
           System.out.println("进入execute");
/*    	   List list=ns.findTableHeader();
  	     if(list!=null){
  	    	 ServletActionContext.getServletContext().setAttribute("list", list);
  	    	return INPUT;
  	     }else{
  	    	return ERROR;
  	     }
    	   	  */
   		Map<String,Object> session=ActionContext.getContext().getSession();
   		//控制显示待处理数据表选择
   		session.put("status", "456");
   		//控制隐藏待处理对话框
		session.remove("flag");
		//控制隐藏表头处理对话框
		session.remove("norsort");
		//控制归一化对话框的显示与隐藏
		session.remove("nor");
		return INPUT;   
           
		
	}
	
	@SuppressWarnings("rawtypes")
	public String tablenor(){
	    //得到Seesion用来跟踪下一步操作
		Map<String,Object> session=ActionContext.getContext().getSession();
		if(getCheckbox()!=null){
        //将跟踪参放在session中
		session.put("flag", "123");
		//找到每个表的表头
		List list=ns.findTableHeader(getCheckbox());
		if(list!=null){
 	    	 ServletActionContext.getRequest().setAttribute("list1", list);
		}
		return INPUT;
		}else{
		session.remove("flag");
		}
		return ERROR;
	}
	
public String backnor(){
    //得到Seesion用来跟踪下一步操作
	Map<String,Object> session=ActionContext.getContext().getSession();
	session.remove("flag");
	session.remove("status");
	return INPUT;
	
}

@SuppressWarnings("rawtypes")
public String next(){
    //得到Seesion用来跟踪下一步操作
	Map<String,Object> session=ActionContext.getContext().getSession();
	session.remove("status");
	session.remove("flag");
	session.put("norsort", "1");
	//调用业务逻辑组件的tablesort()方法来将重复的表头删掉
	List tablelist=ns.tablesort(getTableheader());
	if(tablelist!=null){
    	 ServletActionContext.getServletContext().setAttribute("tablelist", tablelist);
	}
	return INPUT;
	
}

//归一化的排序对话框对应的上一步按钮的响应Action方法
public String upstep(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		//控制显示待处理对话框
		session.put("status", "456");
		//控制隐藏表头处理对话框
		session.remove("norsort");
	return INPUT;
	
}

@SuppressWarnings({ "rawtypes", "unchecked" })
public String nextstep(){
	List norlist=new ArrayList();
	Map<String,Object> session=ActionContext.getContext().getSession();
	//控制隐藏表头处理对话框
	session.remove("norsort");
	System.out.println("成功了");
	//控制归一化对话框的显示
	session.put("nor", "123");
	//根据表头在数据库中建立表
	int issucc=ns.createTable(getTableheader());
	if(issucc>0){
		for(int i=0;i<getTableheader().length;i++){
			norlist.add(getTableheader()[i]);
		}
   	 ServletActionContext.getRequest().setAttribute("norlist", norlist);
		return INPUT;
	}
	return ERROR;
	
}

public String norupstep(){
	Map<String,Object> session=ActionContext.getContext().getSession();
	//控制表头处理对话框的显示
	session.put("norsort", "1");
	//控制隐藏归一化对话框
	session.remove("nor");
	return INPUT;
	
}

public String nornextstep(){
	Map<String,Object> session=ActionContext.getContext().getSession();
	//控制隐藏归一化对话框
	session.remove("nor");
	return ERROR;
	
}
}
