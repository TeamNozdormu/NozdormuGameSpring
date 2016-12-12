package com.nozdormu.dto.settings;

public class GameSettingDto {
	
    private int gameWidth;

    private int gameHeight;

    private String gameName;

	public GameSettingDto() {
		super();
	}

	public int getGameWidth() {
		return gameWidth;
	}

	public void setGameWidth(int gameWidth) {
		this.gameWidth = gameWidth;
	}

	public int getGameHeight() {
		return gameHeight;
	}

	public void setGameHeight(int gameHeight) {
		this.gameHeight = gameHeight;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
    
    
}
