package com.it.apps.nina._share.remote;

import java.util.List;

public interface AppsBo {
	
	public String getBaseUrl();
	
	public String getImageUrl();
	
	public List<AppDto> getApps();
	
	public String getAppUrl(Long appId);

}
