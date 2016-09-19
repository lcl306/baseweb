package com.it.apps.nina.index;


import java.util.List;
import java.util.Map;

import com.it.apps.nina._share.bo.CompanyDto;
import com.it.apps.nina._share.bo.MenuDto;
import com.it.apps.nina._share.bo.UserDto;
import com.it.common.component.db.BaseMapper;

public interface IndexMapper extends BaseMapper {
	
	public List<Map> getMenuMap(String userId);
	
	public MenuDto getMenuDto();
	
	public UserDto getUserDto(String loginnm);
	
	public IndexUserDto getIndexUserDto(String loginnm);
	
	public CompanyDto getCompanyDto();   

}
