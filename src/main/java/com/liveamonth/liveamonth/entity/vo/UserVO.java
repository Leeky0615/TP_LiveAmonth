package com.liveamonth.liveamonth.entity.vo;

public class UserVO {
	private int userNO;
	private String userID;
	private String userPassword;
	private String userName;
	private String userNickname;
	private int userAge;
	private boolean userSex;
	private String userEmail;

	public UserVO() {
		this.userNO = 0;
		this.userID = null;
		this.userPassword = null;
		this.userName = null;
		this.userNickname = null;
		this.userAge = 0;
		this.userSex = false;
		this.userEmail = null;
	}


	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public boolean getUserSex() {
		return userSex;
	}

	public void setUserSex(boolean userSex) {
		this.userSex = userSex;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserNO() {
		return userNO;
	}


	public void setUserNO(int userNO) {
		this.userNO = userNO;
	}
	
}



