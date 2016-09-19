package com.it.apps.nina._share.bo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.it.apps.nina._share.remote.SystemDtoBoImpl;
import com.it.common.component.meta.dto.SystemDto;

public class NinaSystemDto extends SystemDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3014581063077286171L;
	
	private String sessionId;
	
	private String baseUrl;
	
	private String imageUrl;
	
	private String firstProUrl;

	private UserDto userDto;
	
	private CompanyDto companyDto;
	//有操作的三级菜单集合
	private Set<String> activeMenuPath;
	
	private TaxRateDto taxRateDto = TaxRateDto.getInstance();
	
	private Map<Long, WarehouseDto> warehouses = WarehouseDto.getWarehouses();
	
	/** key=menuId, value=MenuDto */
	private Map<String, MenuDto> menus = new HashMap<String, MenuDto>();
	
	public Map<String, MenuDto> getMenus() {
		return menus;
	}

	public void setMenus(Map<String, MenuDto> menus) {
		this.menus = menus;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public static NinaSystemDto getInstance(HttpServletRequest request){
		//return (NinaSystemDto)request.getSession().getAttribute(GlobalName.SYSTEMDTO_NAME);
		return (NinaSystemDto)SystemDtoBoImpl.getSystemDtoFromMemCache(request.getSession().getId());
		//return (NinaSystemDto)request.getAttribute(request.getSession().getId());
	}

	public CompanyDto getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(CompanyDto companyDto) {
		this.companyDto = companyDto;
	}

	public TaxRateDto getTaxRateDto() {
		return taxRateDto;
	}

	public void setTaxRateDto(TaxRateDto taxRateDto) {
		this.taxRateDto = taxRateDto;
	}

	public Map<Long, WarehouseDto> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(Map<Long, WarehouseDto> warehouses) {
		this.warehouses = warehouses;
	}

	public Set<String> getActiveMenuPath() {
		return activeMenuPath;
	}

	public void setActiveMenuPath(Set<String> activeMenuPath) {
		this.activeMenuPath = activeMenuPath;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getFirstProUrl() {
		return firstProUrl;
	}

	public void setFirstProUrl(String firstProUrl) {
		this.firstProUrl = firstProUrl;
	}	


}
