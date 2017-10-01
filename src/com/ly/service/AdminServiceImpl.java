package com.ly.service;

import java.util.List;

import com.ly.dao.AdminDao;
import com.ly.model.UserManager;

public class AdminServiceImpl implements AdminService{
//注入DAO
	private AdminDao adl;
	public AdminDao getAdl() {
		return adl;
	}
	public void setAdl(AdminDao adl) {
		this.adl = adl;
	}
	@Override
	public int userValidate(String username, String password) {
		if(username.equals("leiyuan")&&password.equals("123")){
			//查找出所有用户
			return 10;
		}else{
			
		return -1;
		}
		
	}
	@Override
	public List<UserManager> checkAllUser() {
		List<UserManager> list=adl.checkAllUser();
		return list;
	}
	@Override
	public int deleteUser(UserManager um) {
		//调用Dao来删除指定用户
		boolean issucc=adl.deleteUser(um);
		if(issucc){
			return 20;
		}
		return 0;
	}
	
	@Override
	public int modifypass(String password, String nickname) {
		//查询当前用户是否存在
		List<UserManager> list=adl.checkAllUser();
		//对List循环遍历。找到当前登录用户的昵称
				for(int i=0;i<list.size();i++){
					UserManager um=list.get(i);
					String nickname1=um.getNickname();
					String pass=um.getPassword();
					if(nickname1.equals(nickname)&&pass.equals(password)){
						return 20;

					}
	}
				return -12;
	

	}
	@Override
	public int affirmmodify(String password, String nickname) {
        //根据用户名和呢称修改密码
		int isExist=adl.affirmmodify(password, nickname);
		if(isExist>0){
			return 12;

		}
		return -1;
	}

}
