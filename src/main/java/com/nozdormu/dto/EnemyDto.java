package com.nozdormu.dto;

import com.nozdormu.enumerations.EnemyType;

public class EnemyDto {
	
    private Integer locationX;

    private Integer locationY;

    private Integer healthPoints;

    private Integer speedMultiplier;

    private EnemyType enemyType;

	public EnemyDto() {
		super();
	}

	public Integer getLocationX() {
		return locationX;
	}

	public void setLocationX(Integer locationX) {
		this.locationX = locationX;
	}

	public Integer getLocationY() {
		return locationY;
	}

	public void setLocationY(Integer locationY) {
		this.locationY = locationY;
	}

	public Integer getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(Integer healthPoints) {
		this.healthPoints = healthPoints;
	}

	public Integer getSpeedMultiplier() {
		return speedMultiplier;
	}

	public void setSpeedMultiplier(Integer speedMultiplier) {
		this.speedMultiplier = speedMultiplier;
	}

	public EnemyType getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(EnemyType enemyType) {
		this.enemyType = enemyType;
	}
    
    
}
