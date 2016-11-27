package com.nozdormu.gamestates.utilities;

import com.nozdormu.gamestates.AbstractState;

public final class StateManager {

    private static AbstractState currentState;

    public static AbstractState getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(AbstractState quitState) {
        currentState = quitState;
    }
}

