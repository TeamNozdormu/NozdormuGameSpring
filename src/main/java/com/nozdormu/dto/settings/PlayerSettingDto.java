package com.nozdormu.dto.settings;

public class PlayerSettingDto {
	
    private Integer initialNumberOfLives;

    private Integer defaultScores;

    private Integer defaultSpeed; 

    private String defaultName;

    private Integer defaultLocationX;

    private Integer defaultLocationY;

	public PlayerSettingDto() {
		super();
	}

	public Integer getInitialNumberOfLives() {
		return initialNumberOfLives;
	}

	public void setInitialNumberOfLives(Integer initialNumberOfLives) {
		this.initialNumberOfLives = initialNumberOfLives;
	}

	public Integer getDefaultScores() {
		return defaultScores;
	}

	public void setDefaultScores(Integer defaultScores) {
		this.defaultScores = defaultScores;
	}

	public Integer getDefaultSpeed() {
		return defaultSpeed;
	}

	public void setDefaultSpeed(Integer defaultSpeed) {
		this.defaultSpeed = defaultSpeed;
	}

	public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	public Integer getDefaultLocationX() {
		return defaultLocationX;
	}

	public void setDefaultLocationX(Integer defaultLocationX) {
		this.defaultLocationX = defaultLocationX;
	}

	public Integer getDefaultLocationY() {
		return defaultLocationY;
	}

	public void setDefaultLocationY(Integer defaultLocationY) {
		this.defaultLocationY = defaultLocationY;
	}
    
    
}
