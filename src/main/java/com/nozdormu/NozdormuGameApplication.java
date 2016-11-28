package com.nozdormu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class NozdormuGameApplication {
	public static void main(String[] args) {
//		SpringApplication.run(NozdormuGameApplication.class, args);		
		new SpringApplicationBuilder(NozdormuGameApplication.class).headless(false).web(false).run(args);
	}
}
