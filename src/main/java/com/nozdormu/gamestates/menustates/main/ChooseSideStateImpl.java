package com.nozdormu.gamestates.menustates.main;

import com.nozdormu.gameobjects.entities.ButtonOne;
import com.nozdormu.gamestates.AbstractState;
import com.nozdormu.gamestates.interfaces.ChooseSideState;
import com.nozdormu.graphics.utililies.Assets;

import java.awt.*;

public class ChooseSideStateImpl extends AbstractState implements ChooseSideState {

    //TODO: Display the menu with options and listen for the event clicked
    private static ButtonOne backButton;
    private Rectangle archerButton;
    private Rectangle mageButton;

    public ChooseSideStateImpl() {
        ChooseSideStateImpl.setBackButton(new ButtonOne(300, 480, Assets.button, "Back"));
        this.setArcherButton(new Rectangle(50, 300, 300, 100));
        this.setMageButton(new Rectangle(450, 300, 300, 100));
    }

    public static ButtonOne getBackButton() {
        return backButton;
    }

    private static void setBackButton(ButtonOne backButton) {
        ChooseSideStateImpl.backButton = backButton;
    }

    public Rectangle getArcherButton() {
        return archerButton;
    }

    private void setArcherButton(Rectangle archerButton) {
        this.archerButton = archerButton;
    }

    public Rectangle getMageButton() {
        return mageButton;
    }

    private void setMageButton(Rectangle mageButton) {
        this.mageButton = mageButton;
    }

    public void display(Graphics g) {
        g.drawImage(Assets.chooseSide, 0, 0, null);
        Graphics2D g2d = (Graphics2D) g;

        g.setFont(new Font("redensek", Font.PLAIN, 40));
        g.setColor(Color.GREEN);
        g2d.draw(archerButton);
        g2d.draw(mageButton);
        backButton.display(g);
    }
}