package com.nozdormu.gamestates.menustates.gameplay;

import com.nozdormu.gamestates.AbstractState;
import com.nozdormu.graphics.utililies.Assets;

import java.awt.*;

public class IntroState extends AbstractState {

    public void display(Graphics g) {
        g.drawImage(Assets.intro, 0, 0, null);
    }
}
