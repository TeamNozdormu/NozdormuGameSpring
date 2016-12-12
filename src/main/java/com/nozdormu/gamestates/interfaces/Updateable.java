package com.nozdormu.gamestates.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface Updateable {

	default void update() {

	};
}
