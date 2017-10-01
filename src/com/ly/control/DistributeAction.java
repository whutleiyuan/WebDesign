package com.ly.control;

import java.io.File;

import com.ly.service.DisService;
import com.opensymphony.xwork2.ActionSupport;
/**
 *进行邮件分发
 * @author leiyuan
 *
 */

@SuppressWarnings("serial")
public class DistributeAction extends ActionSupport{
	//注入业务逻辑组件DisService
	private DisService ds;
	//封装邮件用户名
	private String username;
	//封装邮件密码
	private String password;
	//封装邮件收件人
	private String emailgetname;
	//封装邮件主题
	private String emailtitle;
	//封装邮件内容
	private String emailcontent;
	//封装发件人昵称
	private String emailsentname;
	//封装附件内容
	private File file;
    //提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    private String fileContentType;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getEmailsentname() {
		return emailsentname;
	}
	public void setEmailsentname(String emailsentname) {
		this.emailsentname = emailsentname;
	}
	public String getEmailgetname() {
		return emailgetname;
	}
	public void setEmailgetname(String emailgetname) {
		this.emailgetname = emailgetname;
	}
	public String getEmailtitle() {
		return emailtitle;
	}
	public void setEmailtitle(String emailtitle) {
		this.emailtitle = emailtitle;
	}
	public String getEmailcontent() {
		return emailcontent;
	}
	public void setEmailcontent(String emailcontent) {
		this.emailcontent = emailcontent;
	}
	public DisService getDs() {
		return ds;
	}
	public void setDs(DisService ds) {
		this.ds = ds;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//进行用户验证
	public String execute(){
		int issucc=ds.validateUser(getUsername() ,getPassword());
		if(issucc>0){
			return INPUT;
		}
		return ERROR;
		
	}
	
	//获取邮件信息
	public String sentemail(){
/*		int issucc=ds.sentemail(getEmailgetname(), getEmailtitle(), getEmailcontent(),getEmailsentname());*/
		int issucc1=ds.sentemail(getEmailgetname(), getEmailtitle(), getEmailcontent(),getEmailsentname(), getFile(),getFileFileName() );	
		if(issucc1>0){
			return INPUT;
		}else{
			return null;
		}
		
	}
	

}
