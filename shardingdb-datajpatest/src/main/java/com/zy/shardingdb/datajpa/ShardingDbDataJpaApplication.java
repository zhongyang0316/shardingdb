package com.zy.shardingdb.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.zy.shardingdb.datajpa"})
public class ShardingDbDataJpaApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ShardingDbDataJpaApplication.class, args);
		System.out.println(ctx.getId() + " started!");
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ShardingDbDataJpaApplication.class);
	}

}
