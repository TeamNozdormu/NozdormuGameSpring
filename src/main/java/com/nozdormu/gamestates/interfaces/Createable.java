package com.nozdormu.gamestates.interfaces;

import com.nozdormu.gameobjects.base.AbstractEnemy;

public interface Createable {

    AbstractEnemy createEasyEnemy(int x, int y, int healthPoints, int speedMultiplier);

    AbstractEnemy createSturdyEnemy(int x, int y, int healthPoints, int speedMultiplier);
}
