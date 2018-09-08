package com.lhy.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SpliderUtil {

	public static String getHtmlByUrl(String url) throws IOException{  
        String html = null;  
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        httpget.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpget.setHeader("Accept-Encoding","gzip, deflate");
        httpget.setHeader("Accept-Language","zh-CN,zh;q=0.9");
        httpget.setHeader("Connection","keep-alive");
        httpget.setHeader("Cookie","provinceId=2; cityId=2817; yhd_location=2_2817_51973_0; cart_num=0; cart_cookie_uuid=ce684228-b96c-4390-a9b6-e5345a2f761e; __jda=218172059.1533948548594245233580.1533948549.1533948549.1533948549.1; __jdc=218172059; __jdv=218172059|baidu-search|t_262767352_baidusearch|cpc|80615031042_0_b0aa9eab67334273b54bc87e7f7cf9ad|1533949639069; JSESSIONID=6319CA569EC2B5116EAEEB2B27D178F8.s1; __jdb=218172059.9.1533948548594245233580|1.1533948549");
        httpget.setHeader("Host","search.yhd.com");
        httpget.setHeader("Referer",url);
        httpget.setHeader("Upgrade-Insecure-Requests","1");
        httpget.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.26 Safari/537.36 Core/1.63.5702.400 QQBrowser/10.2.1893.400");
        try {  
            HttpResponse responce = httpClient.execute(httpget);     
            int resStatu = responce.getStatusLine().getStatusCode();
            if (resStatu == HttpStatus.SC_OK) {
                HttpEntity entity = responce.getEntity();  
                if (entity != null) {  
                    html = EntityUtils.toString(entity);
                    System.out.println(html);
                }  
            }  
        } catch (Exception e) {
        	System.out.println("���ʡ�"+url+"�������쳣!");  
            e.printStackTrace();  
        } finally {
            httpClient.close();  
        }  
        return html;  
    }  
}
