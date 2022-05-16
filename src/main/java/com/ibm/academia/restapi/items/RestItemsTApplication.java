package com.ibm.academia.restapi.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "api-productos")
@EnableFeignClients
@SpringBootApplication
public class RestItemsTApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestItemsTApplication.class, args);
	}

}
