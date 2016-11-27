package com.nozdormu.gameobjects.entities;

import com.nozdormu.gameobjects.base.AbstractGameObject;
import com.nozdormu.gameobjects.interfaces.Bullet;
import com.nozdormu.gameobjects.utilities.GameObjectConstants;
import com.nozdormu.gamestates.GameStateImpl;
import com.nozdormu.graphics.utililies.Assets;

public class BulletImpl extends AbstractGameObject implements Bullet {

    private int bulletStrength;

    public BulletImpl(int x, int y, int strengthMultiplier) {
        super(x, y, Assets.bullet, GameObjectConstants.BULLET_SPEED_MULTIPLIER);
        this.setBulletStrength(1 * strengthMultiplier);
    }

    public int getBulletStrength() {
        return this.bulletStrength;
    }

    public void setBulletStrength(int bulletStrength) {
        this.bulletStrength = bulletStrength;
    }

    @Override
    public void update() {
        this.getColliderBox().setBounds(
                this.getX(),
                this.getY(),
                this.getObjectIcon().getWidth(),
                this.getObjectIcon().getHeight()
        );
        this.setY(this.getY() - this.getSpeed() * GameObjectConstants.BULLET_SPEED_MULTIPLIER);

        if (this.getY() == 0) {
            GameStateImpl.getBulletsList().remove(this);
        }
    }

}
