package com.nozdormu.gamestates.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface GameState {

	long getLastTimeMissed();

	long getNow();

	int getEnemyTypes();

	public boolean isExplode();

	int getCropX();

	int getCropY();

	int getCropXMonster();

	int getCropYMonster();

}
