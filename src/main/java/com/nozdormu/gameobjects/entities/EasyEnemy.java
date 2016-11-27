package com.nozdormu.gameobjects.entities;

import com.nozdormu.gameobjects.base.AbstractEnemy;
import com.nozdormu.gameobjects.utilities.GameObjectConstants;
import com.nozdormu.graphics.utililies.Assets;

public class EasyEnemy extends AbstractEnemy {
    public EasyEnemy(int x, int y, int healthPoints, int speedMultiplier) {
        super(x, y, healthPoints, Assets.easyEnemyInit, GameObjectConstants.EASY_ENEMY_POINTS_FOR_PLAYER, speedMultiplier);
    }
}
