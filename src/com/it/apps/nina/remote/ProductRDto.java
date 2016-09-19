package com.it.apps.nina.remote;

import java.io.Serializable;

public class ProductRDto implements Serializable{

	private static final long serialVersionUID = -276225186107402125L;

	private Long productId;
	
	private String productCd;
	
	private String productNm;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCd() {
		return productCd;
	}

	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}

	public String getProductNm() {
		return productNm;
	}

	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}
	
	

}
