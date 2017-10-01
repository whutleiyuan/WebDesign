package com.ly.service;

import java.io.File;

public class DisServiceImpl implements DisService{

	@Override
	public int validateUser(String username, String password) {
		if(username.equals("caomuzhao")&&password.equals("123")){
			return 10;
		}else{
			
		return -1;
		}
	}

	@Override
	public int sentemail(String emailgetname, String emailtitle, String emailcontent, String emailsentname) {
		//获取邮件实例
    	try {
			simplemailsent sll=	new simplemailsent(emailgetname,emailtitle,emailcontent,emailsentname);
		    if(sll!=null){
		    	return 2;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -8;
 
	}

	@Override
	public int sentemail(String emailgetname, String emailtitle, String emailcontent, String emailsentname, File file,
			String fileFileName) {
		//获取邮件实例
    	try {
			hardmailsent hll=	new hardmailsent(emailgetname,emailtitle,emailcontent,emailsentname,file,fileFileName);
		    if(hll!=null){
		    	return 2;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -8;
	}



}
