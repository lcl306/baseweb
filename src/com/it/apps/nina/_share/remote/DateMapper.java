package com.it.apps.nina._share.remote;

import java.util.List;

import com.it.common.component.db.BaseMapper;

public interface DateMapper extends BaseMapper{
	
	public List<HolidayDto> getHolidays();

}
