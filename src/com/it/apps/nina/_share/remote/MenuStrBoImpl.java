package com.it.apps.nina._share.remote;

import com.it.apps.nina._share.bo.NinaSystemDto;
import com.it.apps.nina._share.tag.NinaMenuTag;

public class MenuStrBoImpl implements MenuStrBo {

	@Override
	public String getMenuStr(NinaSystemDto no) {
		return NinaMenuTag.getMenuStr(no);
	}

}
