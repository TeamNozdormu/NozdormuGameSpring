package com.nozdormu.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nozdormu.gamestates.GameStateImpl;

@Configuration
@ComponentScan(basePackages = "com.nozdormu")
public class AppConfig {

	@Bean
	public GameStateImpl gameStateImpl() {
		return new GameStateImpl();
	}

}
