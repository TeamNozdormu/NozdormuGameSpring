package com.nozdormu.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import org.springframework.stereotype.Component;

import com.nozdormu.dto.settings.GameSettingDto;
import com.nozdormu.dto.settings.PlayerSettingDto;
import com.nozdormu.eventhandlers.KeyboardInput;
import com.nozdormu.eventhandlers.utilities.MouseInput;
import com.nozdormu.gameobjects.interfaces.Game;
import com.nozdormu.gamestates.AbstractState;
import com.nozdormu.gamestates.GameStateImpl;
import com.nozdormu.gamestates.interfaces.Serviceable;
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
import com.nozdormu.parser.interfaces.ModelParser;
import com.nozdormu.service.BulletService;
import com.nozdormu.service.EnemyService;
import com.nozdormu.service.PlayerService;
import com.nozdormu.service.setting.GameSettingService;
import com.nozdormu.service.setting.PlayerSettingService;

@Component
public class GameImpl implements Game, Serviceable, Runnable {

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
    
    //settings
    private PlayerSettingDto playerSetting;
    private GameSettingDto gameSetting;
    
    //services
    private GameSettingService gameSettingService;
    private PlayerSettingService playerSettingService;
    private PlayerService playerService;
    private EnemyService enemyService;
    private ModelParser modelParser;
    private BulletService bulletService;
       
    public GameImpl(
    		GameSettingService gameSettingService, 
    		PlayerSettingService playerSettingService,
    		PlayerService playerService,
    		EnemyService enemyService,
    		ModelParser modelParser,
    		BulletService bulletService) {
		super();
		this.setGameSettingService(gameSettingService);
		this.setPlayerSettingService(playerSettingService);
		this.setPlayerService(playerService);
		this.setEnemyService(enemyService);
		this.setModelParser(modelParser);
		this.setBulletService(bulletService);
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

	public void setMap(GameMap map) {
		this.map = map;
	}

	public Display getDisplay() {
		return this.display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public MouseInput getMouseInput() {
		return this.mouseInput;
	}

	public void setMouseInput(MouseInput mouseInput) {
		this.mouseInput = mouseInput;
	}

	public Thread getThread() {
		return this.thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public KeyboardInput getKeyboardInput() {
		return this.keyboardInput;
	}

	public void setKeyboardInput(KeyboardInput keyboardInput) {
		this.keyboardInput = keyboardInput;
	}

	public BufferStrategy getBufferStrategy() {
		return this.bufferStrategy;
	}

	public void setBufferStrategy(BufferStrategy bufferStrategy) {
		this.bufferStrategy = bufferStrategy;
	}

	public Graphics getGraphics() {
		return this.graphics;
	}

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}

	public State getGameState() {
		return this.gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public AbstractState getMenuState() {
		return this.menuState;
	}

	public void setMenuState(AbstractState menuState) {
		this.menuState = menuState;
	}

	public State getGameOverState() {
		return this.gameOverState;
	}

	public void setGameOverState(State gameOverState) {
		this.gameOverState = gameOverState;
	}

	public State getHighScoreState() {
		return this.highScoreState;
	}

	public void setHighScoreState(State highScoreState) {
		this.highScoreState = highScoreState;
	}

	public State getChooseDifficulty() {
		return ChooseDifficulty;
	}

	public void setChooseDifficulty(State chooseDifficulty) {
		ChooseDifficulty = chooseDifficulty;
	}

	public State getChooseSideState() {
		return this.chooseSideState;
	}

	public void setChooseSideState(State chooseSideState) {
		this.chooseSideState = chooseSideState;
	}

	public State getIntroState() {
		return IntroState;
	}

	public void setIntroState(State introState) {
		IntroState = introState;
	}

	public State getIntroTaskState() {
		return IntroTaskState;
	}

	public void setIntroTaskState(State introTaskState) {
		IntroTaskState = introTaskState;
	}

	public PlayerSettingDto getPlayerSetting() {
		return this.playerSetting;
	}

	public void setPlayerSetting(PlayerSettingDto playerSetting) {
		this.playerSetting = playerSetting;
	}

	public GameSettingDto getGameSetting() {
		return this.gameSetting;
	}

	public void setGameSetting(GameSettingDto gameSetting) {
		this.gameSetting = gameSetting;
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

	public PlayerService getPlayerService() {
		return this.playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	public EnemyService getEnemyService() {
		return this.enemyService;
	}

	public void setEnemyService(EnemyService enemyService) {
		this.enemyService = enemyService;
	}
	
	public ModelParser getModelParser() {
		return this.modelParser;
	}

	public void setModelParser(ModelParser modelParser) {
		this.modelParser = modelParser;
	}
	
	public BulletService getBulletService() {
		return this.bulletService;
	}

	public void setBulletService(BulletService bulletService) {
		this.bulletService = bulletService;
	}

	private void init() {
    	this.createGameSetting();
    	this.createPlayerSetting();
    	this.createGameMap();
    	this.createDisplay();  
        this.setKeyboardInput(new KeyboardInput(this, this.getDisplay()));
        this.setMouseInput(new MouseInput(this.getDisplay()));
        this.setGameState(new GameStateImpl(this));        
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
		this.setGameSetting(new GameSettingDto());
		this.getGameSetting().setGameHeight(600);
		this.getGameSetting().setGameWidth(800);
		this.getGameSetting().setGameName("Spring game Nozdormu version 1");		
		//save game setting in DB
		this.gameSettingService.create(this.getGameSetting());
	}
	
	private void createPlayerSetting() {
		this.setPlayerSetting(new PlayerSettingDto());
		this.getPlayerSetting().setDefaultName("Ivanof");
		this.getPlayerSetting().setDefaultLocationX(this.getGameSetting().getGameWidth() / 2 - 40);	//GAME_WIDTH / 2 - 40;
		this.getPlayerSetting().setDefaultLocationY(this.getGameSetting().getGameHeight() - 70);	//GAME_HEIGHT - 70
		this.getPlayerSetting().setDefaultScores(0);
		this.getPlayerSetting().setDefaultSpeed(15);
		this.getPlayerSetting().setInitialNumberOfLives(3);		
		//save player setting in DB
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
        this.getGraphics().clearRect(0, 0, this.gameSetting.getGameWidth(), this.gameSetting.getGameHeight());

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
        @SuppressWarnings("unused")
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
