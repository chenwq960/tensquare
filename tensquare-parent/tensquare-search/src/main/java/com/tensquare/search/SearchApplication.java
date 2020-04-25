package com.tensquare.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tensquare.utils.IdWorker;

@SpringBootApplication
public class SearchApplication {
	public static void main(String [] agrs) {
		SpringApplication.run(SearchApplication.class,agrs);
	}
	
	@Bean
	public IdWorker idWorker() {
		return new IdWorker(1,1);
	}
}
