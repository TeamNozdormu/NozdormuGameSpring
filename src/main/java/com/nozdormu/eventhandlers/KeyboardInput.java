package com.nozdormu.eventhandlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.nozdormu.gameobjects.GameImpl;
import com.nozdormu.gameobjects.entities.PlayerImpl;
import com.nozdormu.gamestates.GameStateImpl;
import com.nozdormu.gamestates.menustates.gameplay.GameOverState;
import com.nozdormu.gamestates.menustates.main.MainMenuStateImpl;
import com.nozdormu.gamestates.utilities.StateManager;
import com.nozdormu.graphics.Display;
import com.nozdormu.graphics.utililies.Assets;

public class KeyboardInput implements KeyListener {

	private GameImpl game;

	public KeyboardInput(GameImpl game, Display display) {
		this.setGame(game);
		display.getCanvas().addKeyListener(this);
	}

	public GameImpl getGame() {
		return this.game;
	}

	public void setGame(GameImpl game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT) {
			PlayerImpl.isMovingRight = true;
		} else if (key == KeyEvent.VK_LEFT) {
			PlayerImpl.isMovingLeft = true;
		} else if (key == KeyEvent.VK_UP) {
			PlayerImpl.isMovingUp = true;
		} else if (key == KeyEvent.VK_DOWN) {
			PlayerImpl.isMovingDown = true;
		}

		if (key == KeyEvent.VK_SPACE && PlayerImpl.isFiring == false) {
			PlayerImpl.isFiring = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT) {
			PlayerImpl.isMovingRight = false;
		} else if (key == KeyEvent.VK_LEFT) {
			PlayerImpl.isMovingLeft = false;
		} else if (key == KeyEvent.VK_UP) {
			PlayerImpl.isMovingUp = false;
		} else if (key == KeyEvent.VK_DOWN) {
			PlayerImpl.isMovingDown = false;
		}

		if (key == KeyEvent.VK_SPACE && PlayerImpl.isFiring == true) {
			PlayerImpl.isFiring = false;
		}

		if (StateManager.getCurrentState() instanceof GameOverState) {
			if (key >= 'A' && key <= 'Z' && GameOverState.getStringBuilder().length() < 14) {
				GameOverState.getStringBuilder().append((char) key);
			} else if (key == KeyEvent.VK_BACK_SPACE && GameOverState.getStringBuilder().length() > 0) {
				GameOverState.getStringBuilder().deleteCharAt(GameOverState.getStringBuilder().length() - 1);
			} else if (key == KeyEvent.VK_ENTER && GameOverState.getStringBuilder().length() > 0) {
				GameStateImpl.getPlayer().setPlayerName(GameOverState.getStringBuilder().toString());
				GameOverState.getStringBuilder().setLength(0);
				Assets.savingHighScores(GameStateImpl.getPlayer().getPlayerName(), GameStateImpl.getScore());
				StateManager.setCurrentState(new MainMenuStateImpl());
			}
		}
	}
}
