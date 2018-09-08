package com.lhy.entity;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
	
	private Integer goods_id;
	
	private String goods_name;
	
	private Long goods_price;
	
	private Integer goods_count;
	
	private Integer goods_brand_id;
	
	private Integer goods_type_id;
	
	private String goods_brand_name;
	
	private String goods_type_name;
	
	private Integer goods_point;
	
	private Date last_modify;

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public Long getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(Long goods_price) {
		this.goods_price = goods_price;
	}

	public Integer getGoods_count() {
		return goods_count;
	}

	public void setGoods_count(Integer goods_count) {
		this.goods_count = goods_count;
	}

	public Integer getGoods_brand_id() {
		return goods_brand_id;
	}

	public void setGoods_brand_id(Integer goods_brand_id) {
		this.goods_brand_id = goods_brand_id;
	}

	public Integer getGoods_type_id() {
		return goods_type_id;
	}

	public void setGoods_type_id(Integer goods_type_id) {
		this.goods_type_id = goods_type_id;
	}

	public String getGoods_brand_name() {
		return goods_brand_name;
	}

	public void setGoods_brand_name(String goods_brand_name) {
		this.goods_brand_name = goods_brand_name;
	}

	public String getGoods_type_name() {
		return goods_type_name;
	}

	public void setGoods_type_name(String goods_type_name) {
		this.goods_type_name = goods_type_name;
	}

	public Integer getGoods_point() {
		return goods_point;
	}

	public void setGoods_point(Integer goods_point) {
		this.goods_point = goods_point;
	}

	public Date getLast_modify() {
		return last_modify;
	}

	public void setLast_modify(Date last_modify) {
		this.last_modify = last_modify;
	}
	
}
