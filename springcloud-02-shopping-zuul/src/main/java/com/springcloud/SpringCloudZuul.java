package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient	//发现服务
@EnableZuulProxy 		//当前项目启用zuul路由
public class SpringCloudZuul {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuul.class, args);

	}

}
