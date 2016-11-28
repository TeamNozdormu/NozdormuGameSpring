package com.nozdormu.terminal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nozdormu.gameobjects.GameImpl;
import com.nozdormu.gameobjects.interfaces.Game;

@Component
public class Terminal implements CommandLineRunner {
	
	@Override
	public void run(String... arg0) throws Exception {			
		Game game = new GameImpl();
		game.start();                  
	}
}
