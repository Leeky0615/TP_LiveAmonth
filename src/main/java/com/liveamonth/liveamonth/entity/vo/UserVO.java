package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

import java.util.Calendar;

import static com.liveamonth.liveamonth.constants.EntityConstants.ImageURL;

@Data
public class UserVO {
	// Attributes
	private int userNO;
	private String userID;
	private String userPassword;
	private String userName;
	private String userNickname;
	private int userAge;
	private Boolean userSex;
	private String userEmail;
	private String userImage;

	// Constructor
	public UserVO() {
		this.userNO = 0;
		this.userID = null;
		this.userPassword = null;
		this.userName = null;
		this.userNickname = null;
		this.userAge = 0;
		this.userSex = null;
		this.userEmail = null;
	}

	// Getter & Setter
	public int getUserNO() {return userNO;}
	public void setUserNO(int userNO) {this.userNO = userNO;}

	public String getUserID(){return userID;}
	public void setUserID(String userID) {this.userID = userID;}

	public String getUserPassword() {return userPassword;}
	public void setUserPassword(String userPassword) {this.userPassword = userPassword;}

	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}

	public String getUserNickname() {return userNickname;}
	public void setUserNickname(String userNickname) {this.userNickname = userNickname;}

	public int getUserAge() {return userAge;}
	public int getUserRealAge(){
		return Calendar.getInstance().get(Calendar.YEAR) - this.userAge;
	}
	public void setUserAge(int userAge) {this.userAge = userAge;}

//	public Boolean isUserSex() {return userSex;}
	public Boolean getUserSex() {return userSex;}
	public void setUserSex(Boolean userSex) {this.userSex = userSex;}
	public String getUserSexToString() {
		if (this.getUserSex()) return "여성";
		else return "남성";
	}

	public String getUserEmail() {return userEmail;}
	public void setUserEmail(String userEmail) {this.userEmail = userEmail;}

	public String getUserImage() {return userImage;}
	public void setUserImage(String userImage) {this.userImage = userImage;}

	// Get URL
	public String getUserImageURL(){
		return ImageURL+"user/"+this.getUserImage();
	}
}



