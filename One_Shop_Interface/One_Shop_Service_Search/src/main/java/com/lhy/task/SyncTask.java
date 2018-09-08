package com.lhy.task;

import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SyncTask {
	
	@Scheduled(cron="0 30 3 * * ?")
	public void fullImportc() throws Exception {
		System.out.println("[执行定时任务]------Solr全量同步[开始]------");
		String url = "http://47.95.6.120:8080/solr/one_shop/dataimport?command=full-import&clean=true&commit=true&wt=json&indent=true&entity=goods&verbose=false&optimize=false&debug=false";
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		httpClient.execute(post);
		System.out.println("[执行定时任务]------Solr全量同步[结束]------");
	}
	
	@Scheduled(cron="0/30 * * * * ?")
	public void deltaImportc() throws Exception {
		System.out.println("[执行定时任务]------Solr增量同步[开始]------");
		String url = "http://47.95.6.120:8080/solr/one_shop/dataimport?command=delta-import&entity=goods";
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		httpClient.execute(post);
		System.out.println("[执行定时任务]------Solr增量同步[结束]------");
	}

}
