package com.it.apps.nina._share.bo;

import java.io.Serializable;

public class CompanyDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3584845826213848452L;
	private Long companyId;
	private String companyCd;
	private String companyNm;
	private String companySn;
	private String companyAddr;
	private String zipCode;
	private String phoneNumber;
	private String fax;
	private String email;
	private String bank;
	private String account;
	private String taxCd;
	private Integer custCdSu;
	private Integer vendorCdSu;
	private Integer productCdSu;
	private Integer materailCdSu;
	private Integer machineCdSu;
	private Integer customerOrderCdSu;
	private Integer companyOrderCdSu;
	private Integer receiptCdSu;
	private Integer batchCdSu;
	private Integer weightDotSu;
	private Integer priceDotSu;
	private Integer priceIdotSu;
	private Integer amountDotSu;
	
	private Integer parentCustCdSu;
	
	private Integer wgtDotSu;
	
	private Integer exchangeRateDotSu;
	private Integer mouldCdSu;
	
	
	public Integer getMouldCdSu() {
		return mouldCdSu;
	}
	public void setMouldCdSu(Integer mouldCdSu) {
		this.mouldCdSu = mouldCdSu;
	}
	public Integer getExchangeRateDotSu() {
		return exchangeRateDotSu;
	}
	public void setExchangeRateDotSu(Integer exchangeRateDotSu) {
		this.exchangeRateDotSu = exchangeRateDotSu;
	}
	public Integer getWgtDotSu() {
		return wgtDotSu;
	}
	public void setWgtDotSu(Integer wgtDotSu) {
		this.wgtDotSu = wgtDotSu;
	}
	public Integer getParentCustCdSu() {
		return parentCustCdSu;
	}
	public void setParentCustCdSu(Integer parentCustCdSu) {
		this.parentCustCdSu = parentCustCdSu;
	}
	public Integer getPriceIdotSu() {
		return priceIdotSu;
	}
	public void setPriceIdotSu(Integer priceIdotSu) {
		this.priceIdotSu = priceIdotSu;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyCd() {
		return companyCd;
	}
	public void setCompanyCd(String companyCd) {
		this.companyCd = companyCd;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getCompanySn() {
		return companySn;
	}
	public void setCompanySn(String companySn) {
		this.companySn = companySn;
	}
	public String getCompanyAddr() {
		return companyAddr;
	}
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTaxCd() {
		return taxCd;
	}
	public void setTaxCd(String taxCd) {
		this.taxCd = taxCd;
	}
	public Integer getCustCdSu() {
		return custCdSu;
	}
	public void setCustCdSu(Integer custCdSu) {
		this.custCdSu = custCdSu;
	}
	public Integer getVendorCdSu() {
		return vendorCdSu;
	}
	public void setVendorCdSu(Integer vendorCdSu) {
		this.vendorCdSu = vendorCdSu;
	}
	public Integer getProductCdSu() {
		return productCdSu;
	}
	public void setProductCdSu(Integer productCdSu) {
		this.productCdSu = productCdSu;
	}
	public Integer getMaterailCdSu() {
		return materailCdSu;
	}
	public void setMaterailCdSu(Integer materailCdSu) {
		this.materailCdSu = materailCdSu;
	}
	public Integer getMachineCdSu() {
		return machineCdSu;
	}
	public void setMachineCdSu(Integer machineCdSu) {
		this.machineCdSu = machineCdSu;
	}
	public Integer getCustomerOrderCdSu() {
		return customerOrderCdSu;
	}
	public void setCustomerOrderCdSu(Integer customerOrderCdSu) {
		this.customerOrderCdSu = customerOrderCdSu;
	}
	public Integer getCompanyOrderCdSu() {
		return companyOrderCdSu;
	}
	public void setCompanyOrderCdSu(Integer companyOrderCdSu) {
		this.companyOrderCdSu = companyOrderCdSu;
	}
	public Integer getReceiptCdSu() {
		return receiptCdSu;
	}
	public void setReceiptCdSu(Integer receiptCdSu) {
		this.receiptCdSu = receiptCdSu;
	}
	public Integer getBatchCdSu() {
		return batchCdSu;
	}
	public void setBatchCdSu(Integer batchCdSu) {
		this.batchCdSu = batchCdSu;
	}
	public Integer getWeightDotSu() {
		return weightDotSu;
	}
	public void setWeightDotSu(Integer weightDotSu) {
		this.weightDotSu = weightDotSu;
	}
	public Integer getPriceDotSu() {
		return priceDotSu;
	}
	public void setPriceDotSu(Integer priceDotSu) {
		this.priceDotSu = priceDotSu;
	}
	public Integer getAmountDotSu() {
		return amountDotSu;
	}
	public void setAmountDotSu(Integer amountDotSu) {
		this.amountDotSu = amountDotSu;
	}	
	

}
