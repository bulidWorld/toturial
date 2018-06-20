package com.edu.mall.web;

import org.springframework.web.client.RestTemplate;

import com.edu.mall.web.bean.Response;
import com.google.gson.Gson;

/**
 * 调用方式
 * 服务提供的是什么服务，rest（http），web service, rpc
 * rest  RestTemplate，httpclient
 */
public class App {
	static String BASE_URL = "http://127.0.0.1:8080";
    public static void main( String[] args ){
    	RestTemplate rt = new RestTemplate();
    	String body = rt.getForObject(BASE_URL+"/soa/product/1", String.class);
    	Response resp = new Gson().fromJson(body, Response.class);
    	System.out.println(resp.getCode());
    	System.out.println(resp.getMsg());
    	System.out.println(resp.getData());
    }
}
