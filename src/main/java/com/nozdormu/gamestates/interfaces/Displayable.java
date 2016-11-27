package com.nozdormu.gamestates.interfaces;

import org.springframework.stereotype.*;

import java.awt.*;

public interface Displayable {

    default void display(Graphics g) {

    };
}
