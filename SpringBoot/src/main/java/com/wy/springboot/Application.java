package com.wy.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Application {
	@Value("${name}")
	private String name;

	@RequestMapping("/")
	String home() {
		return "Hello "+name;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}