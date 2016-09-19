package com.it.apps.nina._share.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7138756927679191385L;

	private Long menuId;	
	
	private String menuNm;
	
	private String menuPath;
	
	private String menuType;	
	
	private String valid;
	
	private String menuUrl;
	
	private String appUrl;
	
	private List<String> operations = new ArrayList<String>();

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public List<String> getOperations() {
		return operations;
	}

	public void setOperations(List<String> operations) {
		this.operations = operations;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
	

}
