package com.nozdormu.gameobjects.entities;

import com.nozdormu.gameobjects.base.AbstractEnemy;
import com.nozdormu.gameobjects.utilities.GameObjectConstants;
import com.nozdormu.graphics.utililies.Assets;
import com.nozdormu.utilities.RandomGenerator;

public class SturdyEnemy extends AbstractEnemy {
    public SturdyEnemy(int x, int y, int healthPoints, int speedMultiplier) {
        super(x, y, healthPoints, Assets.sturdyEnemyInit, RandomGenerator.getNextIntRandom(GameObjectConstants.STURDY_ENEMY_POINTS_FOR_PLAYER),
                speedMultiplier);
    }
}
