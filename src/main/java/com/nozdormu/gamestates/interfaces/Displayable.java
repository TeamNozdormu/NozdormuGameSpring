package com.nozdormu.gamestates.interfaces;

import java.awt.Graphics;

import org.springframework.stereotype.Component;

@Component
public interface Displayable {

	default void display(Graphics g) {

	};
}
