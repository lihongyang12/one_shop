package com.lhy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lhy.entity.Goods;
import com.lhy.service.SearchService;
import com.lhy.utils.NumberPageUtil;
import com.lhy.utils.SpliderUtil;

@Controller
public class SearchController {
	
	@Reference(version="1.0.0")
	private SearchService searchService;
	
	@RequestMapping("/search")
	public String search(Goods goods, Integer pageNum,HttpServletRequest request) {
		Map map = new HashMap();
		map.put("goods", goods);
		map.put("pageSize", 8);
		//要访问的页码
		map.put("pageNum", pageNum);
		NumberPageUtil page = searchService.search(map);
		request.setAttribute("page", page);
		request.setAttribute("goods", goods);
		return "list";
	}
	
	@RequestMapping("/data")
	public String data() {
		return "data";
	}
	
	@RequestMapping("/splider")
	public String splider(String url, Integer goods_brand_id, Integer goods_type_id) throws IOException {
		Integer goods_count = 500;
		
		String html = SpliderUtil.getHtmlByUrl(url);
		
		List list = parserHtml(html,goods_brand_id,goods_type_id,goods_count);
		
		searchService.splider(list);

		return "redirect:/";
	}
	
	private List parserHtml(String html, Integer brand, Integer type, Integer count) throws ParseException, IOException {
		Document doc = Jsoup.parse(html);
		Elements links = doc.getElementsByClass("itemBox");
		List<Goods> list = new ArrayList<Goods>();
		for (Element element : links) {
			Goods goods = new Goods();
			String gname = element.select("p[class=proName clearfix]").select("a").attr("title");
			String gprice = element.select("p[class=proPrice]").select("em").text();
			gprice = gprice.substring(1);
			gprice = gprice.replaceAll("\\.", "");
			System.out.println(gprice);
			
			goods.setGoods_name(gname);
			goods.setGoods_price(Long.parseLong(gprice));
			goods.setGoods_brand_id(brand);
			goods.setGoods_type_id(type);
			goods.setGoods_count(count);
			
			list.add(goods);
		}
		
		return list;
	}
	
}
