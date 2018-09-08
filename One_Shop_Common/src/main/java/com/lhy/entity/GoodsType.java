package com.lhy.entity;

import java.io.Serializable;

public class GoodsType implements Serializable {
	
	private Integer goods_type_id;
	
	private String goods_type_name;

	public Integer getGoods_type_id() {
		return goods_type_id;
	}

	public void setGoods_type_id(Integer goods_type_id) {
		this.goods_type_id = goods_type_id;
	}

	public String getGoods_type_name() {
		return goods_type_name;
	}

	public void setGoods_type_name(String goods_type_name) {
		this.goods_type_name = goods_type_name;
	}
	
}
