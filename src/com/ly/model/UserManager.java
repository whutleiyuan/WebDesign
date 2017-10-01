package com.ly.model;

public class UserManager {
		private int id;
		private String nickname;//用户名
		private String username;//用户账号
		private String password;//用户密码
		public UserManager(){
				
		    }
	    public UserManager(String username,String password){
			   this.username=username;
			   this.password=password;
		   }

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
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
}
