package com.it.apps.nina._share.security;

import javax.servlet.http.HttpServletRequest;

import com.it.apps.nina._share.remote.SystemDtoBoImpl;
import com.it.common.component.meta.dto.SystemDto;
import com.it.common.share.AppFilter;

public class BaseAppFilter extends AppFilter {
	
	/**
	 * 从base的memcache中获得SystemDto
	 * */
	@Override
	protected SystemDto getSystemDto(HttpServletRequest request){
		return SystemDtoBoImpl.getSystemDtoFromMemCache(request.getSession().getId());
	}
	
	/**
	 * 将控制权限交给各个app
	 * */
	@Override
	protected boolean passRole(HttpServletRequest request){
		return true;
	}

}
