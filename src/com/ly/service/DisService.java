package com.ly.service;

import java.io.File;

public interface DisService {
/**
 * 邮件账户验证
 * @param username 用户名
 * @param password 密  码
 * @return 整形
 */
	public int validateUser(String username, String password);

	/**
	 * 获取邮件信息
	 * @param emailgetname 收件人
	 * @param emailtitle  邮件主题
	 * @param emailcontent 邮件内容
	 * @param emailsentname 发件人昵称 
	 * @return
	 */
	public int sentemail(String emailgetname,String emailtitle,String emailcontent, String emailsentname );

	/**
	 * 
	 * @param emailgetname 发件人
	 * @param emailtitle 邮件主题
	 * @param emailcontent 邮件文本内容
	 * @param emailsentname 发件人昵称
	 * @param file  附件内容
	 * @param fileFileName 附件名称
	 * @return
	 */
	public int sentemail(String emailgetname, String emailtitle, String emailcontent, String emailsentname, File file,
			String fileFileName);


}
