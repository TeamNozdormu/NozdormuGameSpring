package com.nozdormu;

import com.nozdormu.gameobjects.GameImpl;
import com.nozdormu.gameobjects.interfaces.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new GameImpl();
        game.start();
    }
}