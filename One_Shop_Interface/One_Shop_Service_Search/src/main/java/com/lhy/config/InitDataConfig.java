package com.lhy.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lhy.dao.SearchDao;
import com.lhy.entity.GoodsType;
import com.lhy.utils.RedisUtil;


@Configuration
public class InitDataConfig {
	
	@Autowired
	private SearchDao searchDao;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Bean
	public Object initGoodsInfo() {
		System.out.println("初始化数据缓存.....开始");
		Map map = new HashMap();
		//查询所有的种类
		List<GoodsType> typeList = searchDao.getGoodsTypeList();
		System.out.println("共检测到有："+typeList.size()+"种类别");
		//查询所有品牌集合
		for (GoodsType goodsType : typeList) {
			//将所有的品牌，以类别作为key，装入map
			System.out.println("查询类别为:"+goodsType.getGoods_type_name()+"的品牌");
			List brandList = searchDao.getBrandListByType(goodsType.getGoods_type_id());
			map.put(goodsType.getGoods_type_id()+"", brandList);
			System.out.println("类别为:"+goodsType.getGoods_type_name()+"的品牌共："+brandList.size());
		}
		//将所有类别的list和所有品牌的map装入redis
		redisUtil.del("goods_type");
		redisUtil.lSet("goods_type", typeList);
		redisUtil.hmset("goods_brand", map);
		
		System.out.println("初始化数据缓存.....结束");
		return null;
	}

}
