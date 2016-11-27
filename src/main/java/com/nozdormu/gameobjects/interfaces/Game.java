package com.nozdormu.gameobjects.interfaces;

import com.nozdormu.gamestates.interfaces.State;
import com.nozdormu.graphics.Display;
import com.nozdormu.graphics.GameMap;

import java.awt.*;

public interface Game {
    GameMap getMap();

    Display getDisplay();

    Graphics getGraphics();

    State getGameState();

    void displayFrame();

    void start();

    void stop();
}
