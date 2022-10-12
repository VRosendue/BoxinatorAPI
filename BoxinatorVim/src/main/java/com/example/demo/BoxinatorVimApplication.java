package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//https://stackoverflow.com/questions/70036953/spring-boot-2-6-0-spring-fox-3-failed-to-start-bean-documentationpluginsboo
@EnableWebMvc
@SpringBootApplication
public class BoxinatorVimApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoxinatorVimApplication.class, args);
	}

}
