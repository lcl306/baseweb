package com.it.apps.nina._share.remote;

import com.it.apps.nina._share.bo.NinaSystemDto;
import com.it.common.component.check.group.ErrListDto;

public interface SystemDtoBo {
	
	public NinaSystemDto getSystemDto(String sessionId);
	
	public void setErrList(String sessionId, ErrListDto err);

}
