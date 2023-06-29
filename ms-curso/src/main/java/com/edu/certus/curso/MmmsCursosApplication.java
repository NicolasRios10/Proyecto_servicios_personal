package com.edu.certus.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients("com.edu.certus.curso.client")
@SpringBootApplication
public class MmmsCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmmsCursosApplication.class, args);
	}

}
