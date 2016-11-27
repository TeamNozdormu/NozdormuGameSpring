package com.nozdormu.gameobjects.interfaces;

import com.nozdormu.gameobjects.base.AbstractBonus;

public interface Player {

    int getTimeForBonus();

    void setTimeForBonus(int timeForBonus);

    void addToScore(int points);

    int getScore();

    void setScore(int score);

    String getPlayerName();

    void setPlayerName(String playerName);

    int getNumberOfLives();

    void setNumberOfLives(int numberOfLives);

    AbstractBonus getCurrentBonus();

    void setCurrentBonus(AbstractBonus bonus);
}
