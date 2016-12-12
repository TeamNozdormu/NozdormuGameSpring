package com.nozdormu.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nozdormu.gameobjects.GameImpl;
import com.nozdormu.gameobjects.interfaces.Game;
import com.nozdormu.service.EnemyService;
import com.nozdormu.service.PlayerService;
import com.nozdormu.service.setting.GameSettingService;
import com.nozdormu.service.setting.PlayerSettingService;

@Component
public class Terminal implements CommandLineRunner {
	
	@Autowired
	private GameSettingService gameSettingService;
	
	@Autowired
	private PlayerSettingService playerSettingService;
	
	@Autowired
    private PlayerService playerService;
    
    @Autowired
    private EnemyService enemyService;    
	
	@Override
	public void run(String... arg0) throws Exception {			
		Game game = new GameImpl(
				this.gameSettingService, 
				this.playerSettingService,
				this.playerService,
				this.enemyService);
		game.start();                  
	}	
}
