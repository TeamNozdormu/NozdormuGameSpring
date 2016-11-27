package com.nozdormu.gamestates.menustates.gameplay;

import com.nozdormu.gamestates.AbstractState;
import com.nozdormu.graphics.utililies.Assets;

import java.awt.*;

public class GainLevelState extends AbstractState {

    public void display(Graphics g) {
        g.drawImage(Assets.gainLevel, 0, 0, null);
    }
}
