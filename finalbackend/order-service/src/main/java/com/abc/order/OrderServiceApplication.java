package com.abc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.abc.order.exception.ProductErrorDecoder;

import feign.codec.ErrorDecoder;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
//	@Bean
//	public ErrorDecoder getErroDecoderBean() {
//		return new ProductErrorDecoder();
//	}

}
