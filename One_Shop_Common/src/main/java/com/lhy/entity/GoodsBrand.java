package com.lhy.entity;

import java.io.Serializable;

public class GoodsBrand implements Serializable {
	
	private Integer goods_brand_id;
	
	private String goods_brand_name;
	
	private Integer goods_type_id;

	public Integer getGoods_brand_id() {
		return goods_brand_id;
	}

	public void setGoods_brand_id(Integer goods_brand_id) {
		this.goods_brand_id = goods_brand_id;
	}

	public String getGoods_brand_name() {
		return goods_brand_name;
	}

	public void setGoods_brand_name(String goods_brand_name) {
		this.goods_brand_name = goods_brand_name;
	}

	public Integer getGoods_type_id() {
		return goods_type_id;
	}

	public void setGoods_type_id(Integer goods_type_id) {
		this.goods_type_id = goods_type_id;
	}
	
}
