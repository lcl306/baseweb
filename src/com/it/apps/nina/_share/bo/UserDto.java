package com.it.apps.nina._share.bo;

import java.io.Serializable;

public class UserDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6676996771893980891L;

	private String userId;
	
	private String loginNm;
	
	private String userNm;
	
	private String userDpt;
	
	private String showPrice;
	
	private String valid;

	public String getUserId() {
		return userId;
	}
	public Long getLongUserId() {
		return Long.parseLong(userId);
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginNm() {
		return loginNm;
	}

	public void setLoginNm(String loginNm) {
		this.loginNm = loginNm;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserDpt() {
		return userDpt;
	}

	public void setUserDpt(String userDpt) {
		this.userDpt = userDpt;
	}

	public String getShowPrice() {
		return showPrice;
	}

	public void setShowPrice(String showPrice) {
		this.showPrice = showPrice;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}
	
}
