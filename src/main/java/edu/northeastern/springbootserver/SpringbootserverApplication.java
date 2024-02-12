package edu.northeastern.springbootserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootserverApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootserverApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootserverApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}

}
