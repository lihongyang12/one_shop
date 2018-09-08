package com.lhy.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.SolrParams;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.lhy.dao.SearchDao;
import com.lhy.entity.Goods;
import com.lhy.entity.GoodsType;
import com.lhy.utils.NumberPageUtil;
import com.lhy.utils.RedisUtil;

@Service(version="1.0.0")
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SearchDao searchDao;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private SolrClient solrClient;

	@Override
	public NumberPageUtil search(Map map) {
		List<Goods> list = new ArrayList<Goods>();
		Goods g = (Goods) map.get("goods");
		SolrQuery query = new SolrQuery();
		
		String q = "goods_name:"+g.getGoods_name();
		
		if(g.getGoods_type_id()!=null) {
			q += " AND goods_type_id:"+g.getGoods_type_id();
		}
		
		query.set("q", q);
		
		query.setHighlight(true);
		query.set("hl.fl", "goods_name");
		query.setHighlightSimplePre("<span class=\"hl\">");
		query.setHighlightSimplePost("</span>");
		
		Integer pageNum = map.get("pageNum")==null? 1: (Integer)map.get("pageNum");
		Integer pageSize = (Integer)map.get("pageSize");
		query.setStart((pageNum-1)*pageSize);
		query.setRows(pageSize);
		
		QueryResponse response = null;
		try {
			response = solrClient.query("one_shop", query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SolrDocumentList results = response.getResults();
		
		long count = results.getNumFound();
		
		Map<String, Map<String, List<String>>> hl = response.getHighlighting();
		for (SolrDocument doc : results) {
			Goods goods = new Goods();
			String goods_id = (String)doc.get("goods_id");
			goods.setGoods_id(Integer.parseInt(goods_id));
			goods.setGoods_name(hl.get(goods_id).get("goods_name").get(0));
			goods.setGoods_price(Long.parseLong((Integer)doc.get("goods_price")+""));
			
			list.add(goods);
		}
		System.out.println(pageNum+"---"+count+"----"+pageSize);
		
		NumberPageUtil page = new NumberPageUtil(pageNum, Integer.parseInt(count+""), pageSize, 5);
		page.setData(list);
		
		//获取页面中需要展示的类别和品牌
		List<Object> redisTypeList = redisUtil.lGet("goods_type",0,-1);
		List<GoodsType> typeList = (List)redisTypeList.get(0);
		page.setTypeList(typeList);
		
		Map goods_brand = redisUtil.hmget("goods_brand");
		List brandList = new ArrayList();
		
		if(g.getGoods_type_id()==null) {
			for (GoodsType type : typeList) {
				brandList.addAll((List)goods_brand.get(type.getGoods_type_id()+""));
			}
		}else {
			brandList.addAll((List)goods_brand.get(g.getGoods_type_id()+""));
		}
		page.setBrandList(brandList);
		return page;
	}

	@Override
	public void splider(List list) {
		searchDao.splider(list);
	}

}
