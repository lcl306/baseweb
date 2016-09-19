package com.it.apps.nina._share.bo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.it.common.component.db.BaseDao;

public class WarehouseDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3340538924911152639L;

	/**
	 * 
	 */


	private Long warehouseId;
	
	private String warehouseNm;
	
	private String waregroupNm;
	
	private String processType;
	
	private String takestockType;	
	
	private String processStatus;
	
	private String valid;	
	
	private String invalidDay;
	
	private Long lockid;
	
	public static Map<Long,WarehouseDto> getWarehouses(){
		String sql = "select * from warehouse order by sort";
		List<WarehouseDto> list = BaseDao.getInstance().getObjectsBySql(sql, WarehouseDto.class);
		Map<Long, WarehouseDto> rtn = new HashMap<Long, WarehouseDto>();
		for(WarehouseDto dto : list){
			rtn.put(dto.getWarehouseId(), dto);
		}
		return rtn;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseNm() {
		return warehouseNm;
	}

	public void setWarehouseNm(String warehouseNm) {
		this.warehouseNm = warehouseNm;
	}

	public String getWaregroupNm() {
		return waregroupNm;
	}

	public void setWaregroupNm(String waregroupNm) {
		this.waregroupNm = waregroupNm;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public String getTakestockType() {
		return takestockType;
	}

	public void setTakestockType(String takestockType) {
		this.takestockType = takestockType;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getInvalidDay() {
		return invalidDay;
	}

	public void setInvalidDay(String invalidDay) {
		this.invalidDay = invalidDay;
	}

	public Long getLockid() {
		return lockid;
	}

	public void setLockid(Long lockid) {
		this.lockid = lockid;
	}

	@Override
	public String toString() {
		return "WarehouseDto [warehouseId=" + warehouseId + ", warehouseNm="
				+ warehouseNm + ", waregroupNm=" + waregroupNm
				+ ", processType=" + processType + ", takestockType="
				+ takestockType + ", processStatus=" + processStatus + "]";
	}

	

}
