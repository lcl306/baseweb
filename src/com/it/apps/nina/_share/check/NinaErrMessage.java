package com.it.apps.nina._share.check;

import com.it.common.component.check.group.BaseErrMessage;

public class NinaErrMessage extends BaseErrMessage{
	
	static{
		BaseErrMessage.setErrorContext();
		errorContextPaths.add("com/it/apps/nina/_share/check/ninaErrorMessage.txt");
		//itemNameContextPaths.add("com/it/apps/nina/_share/check/ninaItemName.txt");
	}

}
