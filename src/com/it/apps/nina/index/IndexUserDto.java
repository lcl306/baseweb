package com.it.apps.nina.index;

import java.io.Serializable;

public class IndexUserDto implements Serializable {
	private Long userId;
	private String loginNm;
	private String userNm;
	private String password;
	private String userDpt;
	private String showPrice;
	private String valid;
	private String invalidDay;
	private Long lockid;
	private String createDay;
	private String modifyDay;
	private Long creator;
	private Long modifier;
	private String resetPassword;
	
	
	
	public IndexUserDto() {
		super();
	}
	public IndexUserDto(Long userId, String loginNm, String userNm,
			String password, String userDpt, String showPrice, String valid,
			String invalidDay, Long lockid, String createDay, String modifyDay,
			Long creator, Long modifier, String resetPassword) {
		super();
		this.userId = userId;
		this.loginNm = loginNm;
		this.userNm = userNm;
		this.password = password;
		this.userDpt = userDpt;
		this.showPrice = showPrice;
		this.valid = valid;
		this.invalidDay = invalidDay;
		this.lockid = lockid;
		this.createDay = createDay;
		this.modifyDay = modifyDay;
		this.creator = creator;
		this.modifier = modifier;
		this.resetPassword = resetPassword;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getInvalidDay() {
		return invalidDay;
	}
	public void setInvalidDay(String invalidDay) {
		this.invalidDay = invalidDay;
	}
	public Long getLockid() {
		return lockid;
	}
	public void setLockid(Long lockid) {
		this.lockid = lockid;
	}
	public String getCreateDay() {
		return createDay;
	}
	public void setCreateDay(String createDay) {
		this.createDay = createDay;
	}
	public String getModifyDay() {
		return modifyDay;
	}
	public void setModifyDay(String modifyDay) {
		this.modifyDay = modifyDay;
	}
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public Long getModifier() {
		return modifier;
	}
	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}
	public String getResetPassword() {
		return resetPassword;
	}
	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}
	
	
}
