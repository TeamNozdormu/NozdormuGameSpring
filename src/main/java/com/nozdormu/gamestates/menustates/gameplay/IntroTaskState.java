package com.nozdormu.gamestates.menustates.gameplay;

import com.nozdormu.gamestates.AbstractState;
import com.nozdormu.graphics.utililies.Assets;

import java.awt.*;

public class IntroTaskState extends AbstractState {

    public void display(Graphics g) {
        g.drawImage(Assets.introTask, 0, 0, null);
    }
}
