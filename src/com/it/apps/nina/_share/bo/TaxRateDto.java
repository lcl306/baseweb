package com.it.apps.nina._share.bo;

import java.io.Serializable;

import com.it.common.component.db.BaseDao;

public class TaxRateDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1357616655414115356L;

	private Long taxId;	
	
	private String startDay;
	
	private String endDay;

	private Double taxRate = 17d;
	
	public static TaxRateDto getInstance(){
		String sql = "select * from tax t WHERE t.start_day <= DATE_FORMAT(NOW(),'%Y%m%d') and t.end_day >= DATE_FORMAT(NOW(),'%Y%m%d')";
		return BaseDao.getInstance().getObjectBySql(sql, TaxRateDto.class);
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public Long getTaxId() {
		return taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}
	
	


}
