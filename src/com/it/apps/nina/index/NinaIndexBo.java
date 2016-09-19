package com.it.apps.nina.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.it.apps.nina._share.bo.CompanyDto;
import com.it.apps.nina._share.bo.MenuDto;
import com.it.apps.nina._share.bo.NinaSystemDto;
import com.it.apps.nina._share.bo.UserDto;
import com.it.apps.nina._share.remote.AppsBo;

@Service
public class NinaIndexBo {
	
	@Resource
	private IndexMapper indexMapper;
	
	@Resource
	private AppsBo appsBo;
	
	public List<Map> getMenuMap(String userId){
		return indexMapper.getMenuMap(userId);
	}
	
	public MenuDto getMenuDto(){
		return indexMapper.getMenuDto();
	}
	public UserDto getUseDto(String loginnm){
		return indexMapper.getUserDto(loginnm);
	}
	
	public IndexUserDto getIndexUserDto(String loginnm){
		return indexMapper.getIndexUserDto(loginnm);
	}
	
	public CompanyDto getCompanyDto(){
		return indexMapper.getCompanyDto();
	}
	
	public boolean chkUser(String loginNm,String password){
		if(loginNm.equals("")||password.equals("")){
			return false;
		}
		return true;
	}
	
	public NinaSystemDto readSystemDto(String loginnm, String sessionId){
		NinaSystemDto no= new NinaSystemDto();
		CompanyDto companyDto = this.getCompanyDto();
		no.setCompanyDto(companyDto);
		no.setBaseUrl(appsBo.getBaseUrl());
		no.setImageUrl(appsBo.getImageUrl());
		no.setFirstProUrl(appsBo.getAppUrl(2l));
		UserDto userDto = this.getUseDto(loginnm);
		no.setUserDto(userDto);
		//MenuDto menuDto = ninaIndexBo.getMenuDto();
		List<Map> menuList = this.getMenuMap(userDto.getUserId());
		List<String> operations = new ArrayList<String>();
		List<MenuDto> menuDtoList = new ArrayList<>();
		Map<String, MenuDto> menus = new HashMap<String, MenuDto>();
		MenuDto menuDto = new MenuDto();
		String path="";int i=0,length=menuList.size()-1;
		//有操作的三级菜单集合
		Set<String> activeMenuPath=new HashSet<String>();
		for(Map menuMap : menuList){
			//Map.Entry menuEntry = (Entry) menuMap.entrySet();
			
			String menuPath = (String) menuMap.get("menu_path");
			activeMenuPath.add(menuPath);
			//menuDto.setMenuPath(menuPath);
			if(!path.equals(menuPath)&&i!=0){
				menuDtoList.add(menuDto);
				String menuId = Long.toString(menuDto.getMenuId());////(Long)menuMap.get("menu_id")
				menus.put(menuId, menuDto);
				menuDto = new MenuDto();
				operations = new ArrayList<>();
				//i++;
			}
			path=menuPath;
			menuDto.setMenuPath(menuPath);
			menuDto.setMenuId((Long)menuMap.get("menu_id"));
			menuDto.setMenuNm((String)menuMap.get("menu_nm"));
			menuDto.setMenuType((String)menuMap.get("menu_type"));
			menuDto.setValid((String)menuMap.get("valid"));
			menuDto.setMenuUrl((String)menuMap.get("menu_url"));
			menuDto.setAppUrl((String)menuMap.get("app_url"));
			String operation = String.valueOf((Long) menuMap.get("operation_id"));
			operations.add(operation);
			menuDto.setOperations(operations);
			if(i==length){
				menuDtoList.add(menuDto);
				String menuId = Long.toString(menuDto.getMenuId());////(Long)menuMap.get("menu_id")
				menus.put(menuId, menuDto);
			}
			i++;
		}
		no.setMenus(menus);
		no.setActiveMenuPath(activeMenuPath);
		no.setSessionId(sessionId);
		return no;
	}
}
