package com.it.apps.nina._share.remote;

import java.io.Serializable;

public class AppDto implements Serializable{
	
	private static final long serialVersionUID = -6193120573255009204L;

	private Long appId;
	
	private String appNm;
	
	private String appUrl;

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getAppNm() {
		return appNm;
	}

	public void setAppNm(String appNm) {
		this.appNm = appNm;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
	
	

}
