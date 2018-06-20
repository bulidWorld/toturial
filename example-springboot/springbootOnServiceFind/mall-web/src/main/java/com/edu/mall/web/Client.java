package com.edu.mall.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.web.client.RestTemplate;

/**
 *  服务发现
 *  在进行服务调用的时候，需要先从注册中心获取到服务的地址，然后根据获取到的服务地址进行调用
 */
public class Client {
	public static void main(String[] args) throws Exception {
		
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.120.129:2181", new RetryOneTime(1000));
		client.start();
		client.blockUntilConnected();
		
		ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder.
				builder(Object.class).client(client).basePath("/soa").build();
		
		Collection<ServiceInstance<Object>> list = serviceDiscovery.queryForInstances("product");
		final List<String> services = new ArrayList<>();
				
		list.forEach((instance) -> {
			services.add(instance.getAddress()+":"+instance.getPort());
		});
		System.out.println(services);
		LoadBalance lb = new LoadBalance(services);
		
		for(int i=1;i<=10;i++){
			RestTemplate rt = new RestTemplate();
	    	String body = rt.getForObject("http://" + lb.choose() + "/soa/address", String.class);
	    	System.out.println(body);
		}
	}
}
