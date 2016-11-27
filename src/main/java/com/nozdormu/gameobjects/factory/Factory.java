package com.nozdormu.gameobjects.factory;

import com.nozdormu.gameobjects.base.AbstractEnemy;
import com.nozdormu.gameobjects.entities.EasyEnemy;
import com.nozdormu.gameobjects.entities.SturdyEnemy;
import com.nozdormu.gamestates.interfaces.Createable;

public class Factory implements Createable {

    @Override
    public AbstractEnemy createEasyEnemy(int x, int y, int healthPoints, int speedMultiplier) {
        return new EasyEnemy(x, y, healthPoints, speedMultiplier);
    }

    @Override
    public AbstractEnemy createSturdyEnemy(int x, int y, int healthPoints, int speedMultiplier) {
        return new SturdyEnemy(x, y, healthPoints, speedMultiplier);
    }

}
