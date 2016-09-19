package com.it.apps.nina._share.remote;

import java.util.List;

import com.it.common.component.check.group.ErrListDto;

public interface DateBo {
	
	public List<Integer> getYears();
	
	public String getAheadDay(String destineDay, String dayNum);
	
	public String getDelayDay(String inputDay, int dayNum);
	
	public boolean allowAdd(String inoutDay, int delayNum, ErrListDto err);
	
	public boolean isLegalHoliday(String day);

}
