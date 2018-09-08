package com.lhy.dao;

import java.util.List;

import com.lhy.entity.GoodsType;

public interface SearchDao {
	
	void splider(List list);

	List<GoodsType> getGoodsTypeList();

	List getBrandListByType(Integer goods_type_id);
}
