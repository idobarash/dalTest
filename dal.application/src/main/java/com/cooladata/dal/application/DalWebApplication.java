package com.cooladata.dal.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Configuration
		@ComponentScan(basePackages = {"com.cooladata.dal"}, excludeFilters={
		@ComponentScan.Filter(type= FilterType.REGEX, pattern = {"com.cooladata.dal"}) })
@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.cooladata.dal"})

@EnableTransactionManagement
@EnableJpaRepositories
@EnableWebMvc
public class DalWebApplication {


	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DalWebApplication.class, args);
	}
	
	

}