package com.lhy.service;

import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Service;
import com.lhy.utils.NumberPageUtil;
@Service(version="1.0.0")
public interface SearchService {


	NumberPageUtil search(Map map);

	void splider(List list);

}
