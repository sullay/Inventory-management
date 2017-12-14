package com.sullay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//注解启动一个服务注册中心提供给其他应用进行对话
@EnableEurekaServer
public class ImEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImEurekaServerApplication.class, args);
	}
}
