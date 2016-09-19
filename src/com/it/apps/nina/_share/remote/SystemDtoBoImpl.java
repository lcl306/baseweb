package com.it.apps.nina._share.remote;

import com.it.apps.nina._share.bo.NinaSystemDto;
import com.it.common.component.cache.CacheBo;
import com.it.common.component.cache.CacheBoFactory;
import com.it.common.component.check.group.ErrListDto;
import com.it.common.component.lang.str.StrUtil;
import com.it.common.component.log.LogPrint;
import com.it.common.component.meta.dto.SystemDto;

public class SystemDtoBoImpl implements SystemDtoBo {
	
	static final String PRE_ERR = "err_";
	
	static CacheBo cacheBo = CacheBoFactory.getInstance();
	
	public static void addSystemDto(String sessionId, NinaSystemDto so){
		String userId = so.getUserDto().getUserId();
		cacheBo.set(userId, so);
		cacheBo.set(sessionId, userId);
	}
	
	public static SystemDto delSystemDto(String sessionId){
		NinaSystemDto so = getSystemDtoFromMemCache(sessionId);
		if(so!=null) cacheBo.delete(so.getUserDto().getUserId());
		cacheBo.delete(sessionId);
		LogPrint.info(sessionId +": removed systemDto.");
		return so;
	}
	
	public static NinaSystemDto getSystemDtoFromMemCache(String sessionId){
		NinaSystemDto so = null;
		String userId = cacheBo.get(sessionId);
		if(StrUtil.isNotEmpty(userId)){
			 so = cacheBo.get(userId);
			 //如果cacheBo的过期时间的设置和session的一致，每次取得时，再set一次，达到的效果和session的过期一样
			 //cacheBo.set(userId, so);
			 //cacheBo.set(sessionId, userId);
		}
		return so;
	}

	@Override
	public NinaSystemDto getSystemDto(String sessionId) {
		return (NinaSystemDto)getSystemDtoFromMemCache(sessionId);
	}
	
	@Override
	public void setErrList(String sessionId, ErrListDto err){
		cacheBo.set(PRE_ERR+sessionId, err);
	}
	
	public static void removeErrList(String sessionId){
		cacheBo.delete(PRE_ERR+sessionId);
	}

}
