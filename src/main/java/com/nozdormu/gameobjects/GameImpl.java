package com.nozdormu.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import org.springframework.stereotype.Component;

import com.nozdormu.entities.setting.GameSetting;
import com.nozdormu.entities.setting.PlayerSetting;
import com.nozdormu.eventhandlers.KeyboardInput;
import com.nozdormu.eventhandlers.utilities.MouseInput;
import com.nozdormu.gameobjects.interfaces.Game;
import com.nozdormu.gamestates.AbstractState;
import com.nozdormu.gamestates.GameStateImpl;
import com.nozdormu.gamestates.interfaces.State;
import com.nozdormu.gamestates.menustates.gameplay.GameOverState;
import com.nozdormu.gamestates.menustates.gameplay.IntroState;
import com.nozdormu.gamestates.menustates.gameplay.IntroTaskState;
import com.nozdormu.gamestates.menustates.main.ChooseDifficultyStateImpl;
import com.nozdormu.gamestates.menustates.main.ChooseSideStateImpl;
import com.nozdormu.gamestates.menustates.main.HighScoresStateImpl;
import com.nozdormu.gamestates.menustates.main.MainMenuStateImpl;
import com.nozdormu.gamestates.utilities.StateManager;
import com.nozdormu.graphics.Display;
import com.nozdormu.graphics.GameMap;
import com.nozdormu.service.setting.GameSettingService;
import com.nozdormu.service.setting.PlayerSettingService;
import com.nozdormu.utilities.GameSettings;

import javassist.expr.NewArray;

@Component
public class GameImpl implements Game, Runnable {

    public GameMap map;
    private Display display;
    private boolean isRunning = false;
    private MouseInput mouseInput;
    private Thread thread;
    private KeyboardInput keyboardInput;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private State gameState;
    private AbstractState menuState;
    private State gameOverState;
    private State highScoreState;
    private State ChooseDifficulty;
    private State chooseSideState;
    private State IntroState;
    private State IntroTaskState;
    

	//spring game
    private GameSettingService gameSettingService;
    private PlayerSettingService playerSettingService;
    private GameSetting gameSetting;
    private PlayerSetting playerSetting;
    
    public GameImpl(GameSettingService gameSettingService, PlayerSettingService playerSettingService) {
		super();
		this.setGameSettingService(gameSettingService);
		this.setPlayerSettingService(playerSettingService);
	}

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    public GameMap getMap() {
        return this.map;
    }

    private void setMap(GameMap map) {
        this.map = map;
    }

    public Display getDisplay() {
        return this.display;
    }

    private void setDisplay(Display display) {
        this.display = display;
    }

    @SuppressWarnings("unused")
	private MouseInput getMouseInput() {
        return this.mouseInput;
    }

    private void setMouseInput(MouseInput mouseInput) {
        this.mouseInput = mouseInput;
    }

    private Thread getThread() {
        return this.thread;
    }

    private void setThread(Thread thread) {
        this.thread = thread;
    }

    @SuppressWarnings("unused")
    private KeyboardInput getKeyboardInput() {
        return this.keyboardInput;
    }

    private void setKeyboardInput(KeyboardInput keyboardInput) {
        this.keyboardInput = keyboardInput;
    }

    private BufferStrategy getBufferStrategy() {
        return this.bufferStrategy;
    }

    private void setBufferStrategy(BufferStrategy bufferStrategy) {
        this.bufferStrategy = bufferStrategy;
    }

    public Graphics getGraphics() {
        return this.graphics;
    }

    private void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public State getGameState() {
        return this.gameState;
    }

    private void setGameState(State gameState) {
        this.gameState = gameState;
    }

    private AbstractState getMenuState() {
        return this.menuState;
    }

    private void setMenuState(AbstractState menuState) {
        this.menuState = menuState;
    }

    @SuppressWarnings("unused")
    private State getGameOverState() {
        return this.gameOverState;
    }

    private void setGameOverState(State gameOverState) {
        this.gameOverState = gameOverState;
    }

    @SuppressWarnings("unused")
	private State getHighScoreState() {
        return this.highScoreState;
    }

    private void setHighScoreState(AbstractState highScoreState) {
        this.highScoreState = highScoreState;
    }

    @SuppressWarnings("unused")
	private State getChooseDifficulty() {
        return this.ChooseDifficulty;
    }

    private void setChooseDifficulty(State chooseDifficulty) {
        ChooseDifficulty = chooseDifficulty;
    }

    @SuppressWarnings("unused")
	private State getChooseSideState() {
        return this.chooseSideState;
    }

    private void setChooseSideState(AbstractState chooseSideState) {
        this.chooseSideState = chooseSideState;
    }

    @SuppressWarnings("unused")
    private State getIntroState() {
        return this.IntroState;
    }

    private void setIntroState(State introState) {
        IntroState = introState;
    }

    @SuppressWarnings("unused")
    private State getIntroTaskState() {
        return this.IntroTaskState;
    }

    private void setIntroTaskState(State introTaskState) {
        IntroTaskState = introTaskState;
    }
    
    public GameSetting getGameSetting() {
		return this.gameSetting;
	}

	public void setGameSetting(GameSetting gameSetting) {
		this.gameSetting = gameSetting;
	}
	
	public PlayerSetting getPlayerSetting() {
		return this.playerSetting;
	}

	public void setPlayerSetting(PlayerSetting playerSetting) {
		this.playerSetting = playerSetting;
	}

	public GameSettingService getGameSettingService() {
		return this.gameSettingService;
	}

	public void setGameSettingService(GameSettingService gameSettingService) {
		this.gameSettingService = gameSettingService;
	}

	public PlayerSettingService getPlayerSettingService() {
		return this.playerSettingService;
	}

	public void setPlayerSettingService(PlayerSettingService playerSettingService) {
		this.playerSettingService = playerSettingService;
	}

	private void init() {
    	this.createGameSetting();
    	this.createPlayerSetting();
    	this.createGameMap();
    	this.createDisplay();    	
        this.setKeyboardInput(new KeyboardInput(this, this.getDisplay()));
        this.setMouseInput(new MouseInput(this.getDisplay()));
        
        this.setGameState(new GameStateImpl());
        this.setMenuState(new MainMenuStateImpl());
        this.setChooseDifficulty(new ChooseDifficultyStateImpl());
        this.setChooseSideState(new ChooseSideStateImpl());
        this.setIntroState(new IntroState());
        this.setIntroTaskState(new IntroTaskState());
        this.setGameOverState(new GameOverState());
        this.setHighScoreState(new HighScoresStateImpl("Descending"));
        StateManager.setCurrentState(this.getMenuState());
    }
	
	private void createGameSetting() {
		this.setGameSetting(new GameSetting());
		this.getGameSetting().setGameHeight(1000);
		this.getGameSetting().setGameWidth(1000);
		this.getGameSetting().setGameName("Spring game Nozdormu version 1");
		
		this.gameSettingService.create(this.getGameSetting());
	}
	
	private void createPlayerSetting() {
		this.setPlayerSetting(new PlayerSetting());
		this.getPlayerSetting().setDefaultName("Ivanof");
		this.getPlayerSetting().setDefaultLocationX(this.getGameSetting().getGameWidth() / 2 - 40);	//GAME_WIDTH / 2 - 40;
		this.getPlayerSetting().setDefaultLocationY(this.getGameSetting().getGameHeight() - 70);	//GAME_HEIGHT - 70
		this.getPlayerSetting().setDefaultScores(0);
		this.getPlayerSetting().setDefaultSpeed(15);
		this.getPlayerSetting().setInitialNumberOfLives(3);
		
		this.playerSettingService.create(this.getPlayerSetting());
	}
	
	private void createGameMap() {
		this.setMap(new GameMap(this.gameSetting.getGameWidth(), this.gameSetting.getGameHeight()));
	}
	
	private void createDisplay() {
		this.setDisplay(new Display(
				this.gameSetting.getGameName(), 
				this.gameSetting.getGameWidth(), 
				this.gameSetting.getGameHeight()));
	}

    public void displayFrame() {
        //Display the current frame using the display frame;
        this.setBufferStrategy(this.display.getCanvas().getBufferStrategy());

        if (this.getBufferStrategy() == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.setGraphics(bufferStrategy.getDrawGraphics());
        /////////DRAW HERE /////////////////
        this.getGraphics().clearRect(0, 0, GameSettings.GAME_WIDTH, GameSettings.GAME_HEIGHT);

        if (StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().display(graphics);
        }

        ////////////// TO HERE////////////
        this.getGraphics().dispose();
        this.getBufferStrategy().show();
    }

    public void update() {
        if (StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().update();
        }
    }

    public synchronized void start() {
        if (this.isRunning) {
            return;
        }

        this.isRunning = true;
        this.setThread(new Thread(this));
        this.getThread().start();
    }

    public synchronized void stop() {
        if (!isRunning) {
            return;
        }

        this.isRunning = false;

        try {
            this.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {

        init();
        int fps = 36;
        double timePerTick = 1_000_000_000.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (this.isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                this.update();
                this.displayFrame();
                ticks++;
                delta--;
            }

            if (timer >= 1_000_000_000) {
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }
}
