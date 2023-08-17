package com.swarga.project.dotbazaar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10, name = "user_id")
	private int userId;
	@Column(length = 100, name="user_name",unique =true)
	private String userName;
	@Column(length = 100, name="user_email",unique =true)
	private String userEmail;
	@Column(length = 100, name="user_password")
	private String userPassword;
	@Column (length = 10, name="user_phone")
	private String userPhone;
	@Column(name = "user_pic")
	private String userPic;
	@Column(length = 100, name = "user_address")
	private String userAddress;
	@Column(length = 100, name = "user_type")
	private String userType;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPic() {
		return userPic;
	}
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", " + (userName != null ? "userName=" + userName + ", " : "")
				+ (userEmail != null ? "userEmail=" + userEmail + ", " : "")
				+ (userPassword != null ? "userPassword=" + userPassword + ", " : "")
				+ (userPhone != null ? "userPhone=" + userPhone + ", " : "")
				+ (userPic != null ? "userPic=" + userPic + ", " : "")
				+ (userAddress != null ? "userAddress=" + userAddress + ", " : "")
				+ (userType != null ? "userType=" + userType : "") + "]";
	}
		
	
}
