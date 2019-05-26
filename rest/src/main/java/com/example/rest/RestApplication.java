package com.example.rest;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;

@SpringBootApplication
@EnableJpaRepositories
public class RestApplication implements WebMvcConfigurer{

	@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new SpecificationArgumentResolver());
    }
	
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
