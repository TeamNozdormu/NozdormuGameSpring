package com.nozdormu.gamestates.interfaces;

public interface HighScoresState {

    int getRow();

    int getBackButtonXPos();

    String getCurrentSortingOrder();

    void reverseOrder();


}
