package com.nozdormu.dto;

public class PLayerDto {
			    
    private String name;

    private Integer numberOfLives;

    private Integer score;

    private Integer currentBonus;

    private Integer locationX;

    private Integer locationY;

    private Integer speed;
    
    
	public PLayerDto() {
		super();
	}
	
	public PLayerDto(String name, Integer numberOfLives, Integer score, Integer currentBonus, Integer locationX,
			Integer locationY, Integer speed) {
		super();
		this.setName(name);
		this.setNumberOfLives(numberOfLives);
		this.setScore(score);
		this.setCurrentBonus(currentBonus);
		this.setLocationX(locationX);
		this.setLocationY(locationY);
		this.setSpeed(speed);
	}



	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfLives() {
		return this.numberOfLives;
	}

	public void setNumberOfLives(Integer numberOfLives) {
		this.numberOfLives = numberOfLives;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getCurrentBonus() {
		return this.currentBonus;
	}

	public void setCurrentBonus(Integer currentBonus) {
		this.currentBonus = currentBonus;
	}

	public Integer getLocationX() {
		return this.locationX;
	}

	public void setLocationX(Integer locationX) {
		this.locationX = locationX;
	}

	public Integer getLocationY() {
		return this.locationY;
	}

	public void setLocationY(Integer locationY) {
		this.locationY = locationY;
	}

	public Integer getSpeed() {
		return this.speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
    
    

}
