package com.it.apps.nina.remote;

import org.apache.ibatis.annotations.Param;

import com.it.common.component.db.BaseMapper;

public interface ProductRMapper extends BaseMapper{
	
	public ProductRDto getProduct(@Param("productId")Long productId);

}
