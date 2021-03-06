package com.nozdormu.gamestates.interfaces;

import com.nozdormu.parser.interfaces.ModelParser;
import com.nozdormu.service.BulletService;
import com.nozdormu.service.EnemyService;
import com.nozdormu.service.PlayerService;
import com.nozdormu.service.setting.GameSettingService;
import com.nozdormu.service.setting.PlayerSettingService;

public interface Serviceable {
	GameSettingService getGameSettingService();

	PlayerSettingService getPlayerSettingService();

	PlayerService getPlayerService();

	EnemyService getEnemyService();

	ModelParser getModelParser();
	
	BulletService getBulletService();
}
