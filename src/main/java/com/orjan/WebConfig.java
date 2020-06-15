package com.orjan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.orjan.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

}