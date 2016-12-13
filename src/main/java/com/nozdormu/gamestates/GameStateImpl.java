package com.nozdormu.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import com.nozdormu.dto.EnemyDto;
import com.nozdormu.dto.PLayerDto;
import com.nozdormu.entities.Player;
import com.nozdormu.enumerations.EnemyType;
import com.nozdormu.eventhandlers.utilities.MouseInput;
import com.nozdormu.gameobjects.base.AbstractBonus;
import com.nozdormu.gameobjects.base.AbstractEnemy;
import com.nozdormu.gameobjects.entities.BulletImpl;
import com.nozdormu.gameobjects.entities.EasyEnemy;
import com.nozdormu.gameobjects.entities.PlayerImpl;
import com.nozdormu.gameobjects.factory.Factory;
import com.nozdormu.gamestates.interfaces.Displayable;
import com.nozdormu.gamestates.interfaces.GameState;
import com.nozdormu.gamestates.interfaces.Serviceable;
import com.nozdormu.gamestates.menustates.gameplay.GainLevelState;
import com.nozdormu.gamestates.menustates.gameplay.GameOverState;
import com.nozdormu.gamestates.utilities.StateManager;
import com.nozdormu.graphics.utililies.Assets;
import com.nozdormu.utilities.GameSettings;
import com.nozdormu.utilities.PlayerSettings;
import com.nozdormu.utilities.RandomGenerator;

public class GameStateImpl extends AbstractState implements GameState, Displayable {

	private static int LEVEL_POINTS;
	private static final int MISSED_ENEMIES = 3;
	public static int score;
	private static PlayerImpl player;
	private static List<AbstractEnemy> enemiesList;
	private static List<BulletImpl> bulletsList;
	private static List<AbstractBonus> bonusList;
	private static Factory factory;
	private static boolean isLevelGained;
	private long lastTimeMissed, now;
	private int enemyTypes = 1;
	private boolean explode;
	private int cropX, cropY;
	private int cropXMonster = 0, cropYMonster = 0;

	public static Serviceable services;

	public GameStateImpl(Serviceable service) {
		this();
		services = service;

		this.createPlayerDto();
		Player p = services.getPlayerService().getPlayerByID(1L);
		player = new PlayerImpl(p.getLocationX(), p.getLocationY(), p.getName(), p.getSpeed(), LEVEL_POINTS);
		factory = new Factory();
		bulletsList = new LinkedList<>();
		enemiesList = new LinkedList<>();
		bonusList = new LinkedList<>();
		AbstractEnemy e = new EasyEnemy(RandomGenerator.getNextIntRandom(725), -100, 1, 2);
		enemiesList.add(e);
		this.insertEnemyInDatabase(e, EnemyType.EASY);
	}

	public GameStateImpl() {
		if (!isLevelGained) {
			score = 0;
		} else {
			isLevelGained = false;
		}

		init();

		if (MouseInput.isEasyButton) {
			LEVEL_POINTS = 400;
		} else if (MouseInput.isMediumButton) {
			LEVEL_POINTS = 800;
		} else {
			LEVEL_POINTS = 1200;
		}

	}

	public static PlayerImpl getPlayer() {
		return player;
	}

	public static List<AbstractEnemy> getEnemiesList() {
		return enemiesList;
	}

	public static List<BulletImpl> getBulletsList() {
		return bulletsList;
	}

	public static List<AbstractBonus> getBonusList() {
		return bonusList;
	}

	private static Factory getFactory() {
		return factory;
	}

	public static int getScore() {
		return score;
	}

	public static boolean isLevelGained() {
		return isLevelGained;
	}

	public static void setLevelGained(boolean levelGained) {
		isLevelGained = levelGained;
	}

	public long getLastTimeMissed() {
		return lastTimeMissed;
	}

	public void setLastTimeMissed(long lastTimeMissed) {
		this.lastTimeMissed = lastTimeMissed;
	}

	public long getNow() {
		return now;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public int getEnemyTypes() {
		return enemyTypes;
	}

	public void setEnemyTypes(int enemyTypes) {
		this.enemyTypes = enemyTypes;
	}

	public boolean isExplode() {
		return explode;
	}

	public void setExplode(boolean explode) {
		this.explode = explode;
	}

	public int getCropX() {
		return cropX;
	}

	public void setCropX(int cropX) {
		this.cropX = cropX;
	}

	public int getCropY() {
		return cropY;
	}

	public void setCropY(int cropY) {
		this.cropY = cropY;
	}

	public int getCropXMonster() {
		return cropXMonster;
	}

	public void setCropXMonster(int cropXMonster) {
		this.cropXMonster = cropXMonster;
	}

	public int getCropYMonster() {
		return cropYMonster;
	}

	public void setCropYMonster(int cropYMonster) {
		this.cropYMonster = cropYMonster;
	}

	public void init() {
		Assets.init();
	}

	private void createPlayerDto() {
		// TODO get configuration from DB
		PLayerDto playerDto = new PLayerDto("ivanof", 3, 0, 0, PlayerSettings.PLAYER_SET_X, PlayerSettings.PLAYER_SET_Y,
				PlayerSettings.PLAYER_DEFAULT_SPEED);
		services.getPlayerService().create(playerDto);
	}

	private void insertEnemyInDatabase(AbstractEnemy e, EnemyType type) {
		EnemyDto enemyDto = new EnemyDto();
		enemyDto.setEnemyType(type);
		enemyDto.setHealthPoints(e.getHealth());
		enemyDto.setLocationX(e.getX());
		enemyDto.setLocationY(e.getY());
		enemyDto.setSpeedMultiplier(e.getSpeed());
		services.getEnemyService().create(enemyDto);
	}

	private void addNewSturdyEnemy(int numberOfSturdyEnemies) {
		AbstractEnemy sturdyEnemy = getFactory().createSturdyEnemy(
				RandomGenerator.getNextIntRandom(GameSettings.GAME_WIDTH - 100), -100,
				RandomGenerator.getNextIntRandom(4), RandomGenerator.getNextIntRandom(PlayerImpl.getLevel() + 1));
		getEnemiesList().add(sturdyEnemy);
		this.insertEnemyInDatabase(sturdyEnemy, EnemyType.STURDY);
		this.setEnemyTypes(0);
	}

	private void addNewEasyEnemy() {
		AbstractEnemy easyEnemy = getFactory()
				.createEasyEnemy(RandomGenerator.getNextIntRandom(GameSettings.GAME_WIDTH - 100), -100, 1, 2);
		getEnemiesList().add(easyEnemy);
		this.insertEnemyInDatabase(easyEnemy, EnemyType.EASY);
	}

	private void gameOver() {
		if (player.getNumberOfLives() == 0) {
			PlayerImpl.setLevel(1);
			StateManager.setCurrentState(new GameOverState());
		}
	}

	private void increaseLevel() {
		if (GameStateImpl.score >= LEVEL_POINTS * PlayerImpl.getLevel()) {
			PlayerImpl.inceraseLevel();
			GameStateImpl.isLevelGained = true;
			StateManager.setCurrentState(new GainLevelState());
		}
	}

	@Override
	public void update() {

		if (!explode) {
			player.update();
		}

		// if player misses three enemies loses one live
		if (AbstractEnemy.passed >= MISSED_ENEMIES) {
			player.setNumberOfLives(player.getNumberOfLives() - 1);
			lastTimeMissed = System.currentTimeMillis();
			AbstractEnemy.passed = 0;
			enemiesList.clear();
		}

		for (int i = 0; i < bulletsList.size(); i++) {
			bulletsList.get(i).update();
		}

		for (int i = 0; i < bonusList.size(); i++) {
			bonusList.get(i).update();
		}

		for (int i = 0; i < enemiesList.size(); i++) {

			if (player.collide(enemiesList.get(i).getColliderBox())) {
				player.setNumberOfLives(player.getNumberOfLives() - 1);
				explode = true;
				enemiesList.get(i).setColliderBox(new Rectangle(0, 0, 1, 1));

				break;
			}

			if (!explode) {
				enemiesList.get(i).update();
			}
		}

		// player gains level
		this.increaseLevel();

		// PlayerImpl Ends Playing
		this.gameOver();

		if (explode) {
			cropX++;
			if (cropX >= 6) {
				cropX = 0;
				explode = false;
				enemiesList.clear();
				player.setX(350);
				player.setY(500);
			}
		}

		// change difficulty
		if (getEnemiesList().size() < 6) {
			if (this.getEnemyTypes() == 6) {
				this.addNewSturdyEnemy(PlayerImpl.getLevel());
			} else {
				this.addNewEasyEnemy();
			}

			this.setEnemyTypes(this.getEnemyTypes() + 1);
		}
	}

	@Override
	public void display(Graphics g) {
		// TODO draw map
		g.drawImage(Assets.background, 0, 0, null);

		if (player.getCurrentBonus() != null) {
			g.drawImage(player.getCurrentBonus().getObjectIcon(), 730, 530, null);
		}

		if (!explode) {
			player.display(g);
		}

		for (int i = 0; i < bonusList.size(); i++) {
			bonusList.get(i).display(g);
		}

		for (int i = 0; i < bulletsList.size(); i++) {
			bulletsList.get(i).display(g);
		}

		for (int i = 0; i < enemiesList.size(); i++) {
			// enemiesList.get(i).display(g);
			if (enemiesList.get(i).getPointsForPlayer() == 5) {
				g.drawImage(Assets.easyEnemy.crop(cropXMonster, cropYMonster), enemiesList.get(i).getX() - 20,
						enemiesList.get(i).getY(), null);
			} else {
				g.drawImage(Assets.sturdyEnemy.crop(cropXMonster, cropYMonster), enemiesList.get(i).getX() - 20,
						enemiesList.get(i).getY(), null);
			}

			cropXMonster += 1;
			if (cropXMonster >= 4) {
				cropXMonster = 0;
			}

		}

		g.setFont(new Font("redensek", Font.PLAIN, 25));
		g.setColor(Color.RED);
		g.drawString(String.format("Level: %d", PlayerImpl.getLevel()), 560, 50);
		g.drawString(String.format("Next Level: %d", LEVEL_POINTS * PlayerImpl.getLevel()), 560, 80);
		g.drawString(String.format("Score: %d", GameStateImpl.score), 560, 110);
		g.drawString("Lives: ", 560, 140);
		g.drawString(String.format("Monsters: %d", getEnemiesList().size()), 560, 170);
		g.drawString(String.format("Monster to kill: %d", (MISSED_ENEMIES - AbstractEnemy.passed)), 500, 200);

		for (int i = 0; i < player.getNumberOfLives(); i++) {
			g.drawImage(Assets.live, 660 + i * 35, 1, null);
		}

		now = System.currentTimeMillis();

		if (now - lastTimeMissed < 3000) {
			g.setFont(new Font("redensek", Font.CENTER_BASELINE, 50));
			g.drawString("You've missed three enemies", 50, 200);
		}

		if (explode) {
			g.drawImage(Assets.die.crop(cropX, cropY), player.getX(), player.getY(), null);
		}
	}

}