package com.lhy.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolrConfig {
	
	@Value("${spring.data.solr.host}")
	private String url;
	
	@Bean
	public SolrClient initSolr() {
		return new HttpSolrClient(url);
	}

}
