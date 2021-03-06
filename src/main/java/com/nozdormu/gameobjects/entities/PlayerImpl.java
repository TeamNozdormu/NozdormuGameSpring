package com.nozdormu.gameobjects.entities;

import java.awt.image.BufferedImage;

import com.nozdormu.dto.BulletDto;
import com.nozdormu.gameobjects.base.AbstractBonus;
import com.nozdormu.gameobjects.base.AbstractGameObject;
import com.nozdormu.gameobjects.interfaces.Player;
import com.nozdormu.gamestates.GameStateImpl;
import com.nozdormu.graphics.utililies.Assets;
import com.nozdormu.utilities.PlayerSettings;

public class PlayerImpl extends AbstractGameObject implements Player {

	public static boolean isMovingLeft = false, isMovingRight = false, isMovingUp = false, isMovingDown = false,
			isFiring = false;

	private static int level = 1;
	private int numberOfLives;
	private String playerName;
	private int score;
	private AbstractBonus currentBonus;
	private int timeForBonus;

	public PlayerImpl(int x, int y, String name, int speed, int nextLevel) {
		super(x, y, Assets.player, speed);
		this.setPlayerName(name);
		this.setNumberOfLives(PlayerSettings.PLAYER_INITIAL_NUMBER_OF_LIVES);
		this.setScore(PlayerSettings.PLAYER_DEFAULT_SCORES);
	}

	public PlayerImpl(BufferedImage bufferedImage) {
		super(bufferedImage);
	}

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int level) {
		PlayerImpl.level = level;
	}

	public static void inceraseLevel() {
		level++;
	}

	public int getTimeForBonus() {
		return this.timeForBonus;
	}

	public void setTimeForBonus(int timeForBonus) {
		this.timeForBonus = timeForBonus;
	}

	public void addToScore(int points) {
		this.score += points;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getNumberOfLives() {
		return this.numberOfLives;
	}

	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}

	public AbstractBonus getCurrentBonus() {
		return this.currentBonus;
	}

	public void setCurrentBonus(AbstractBonus bonus) {
		this.currentBonus = bonus;
		this.setTimeForBonus(bonus.getBonusDuration());
	}

	@Override
	public void update() {
		if (this.timeForBonus > 0) {
			this.timeForBonus--;
		} else if (this.currentBonus != null && this.timeForBonus == 0) {
			this.currentBonus = null;
		} else {
			this.currentBonus = null;
			this.timeForBonus = 0;
		}

		movePlayer();
		handleFireAction();
	}

	private void handleFireAction() {
		if (isFiring) {
			BulletImpl bulletImpl = null;
			if (this.getCurrentBonus() != null) {
				bulletImpl = new BulletImpl(this.getX() + 16, this.getY(),
						this.getCurrentBonus().getMultiplierForDamage());
				GameStateImpl.getBulletsList().add(bulletImpl);
			} else {
				bulletImpl = new BulletImpl(this.getX() + 16, this.getY(), 1);
				GameStateImpl.getBulletsList().add(bulletImpl);
			}

			BulletDto bulletDto = new BulletDto();
			bulletDto.setLocationX(bulletImpl.getX());
			bulletDto.setLocationY(bulletImpl.getY());
			bulletDto.setSpeed(bulletImpl.getSpeed());

			GameStateImpl.services.getBulletService().create(bulletDto);

			isFiring = false;
		}
	}

	private void movePlayer() {
		this.getColliderBox().setBounds(this.getX(), this.getY(), this.getObjectIcon().getWidth(),
				this.getObjectIcon().getHeight());

		if (isMovingRight && this.getX() + this.getSpeed() <= 730) {
			this.setX(this.getX() + this.getSpeed());
		}
		if (isMovingLeft && this.getX() + this.getSpeed() >= 0) {
			this.setX(this.getX() - this.getSpeed());
		}
		if (isMovingDown && this.getY() + this.getSpeed() < 520) {
			this.setY(this.getY() + this.getSpeed());
		}
		if (isMovingUp && this.getY() - this.getSpeed() >= 0) {
			this.setY(this.getY() - this.getSpeed());
		}
	}
}
