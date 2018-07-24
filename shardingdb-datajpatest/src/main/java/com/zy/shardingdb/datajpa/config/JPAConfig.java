package com.zy.shardingdb.datajpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan({"com.zy.shardingdb.datajpa.domain"})
@EnableJpaRepositories({"com.zy.shardingdb.datajpa.domain"})
public class JPAConfig {

}
