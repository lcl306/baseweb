package com.it.apps.nina.remote;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRBoImpl implements ProductRBo {
	
	@Resource
	private ProductRMapper productRMapper;

	@Override
	public ProductRDto getProduct(Long productId) {
		return productRMapper.getProduct(productId);
	}
	
	

}
