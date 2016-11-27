package com.nozdormu.utilities;

import java.util.Random;

public class RandomGenerator {

    private static Random random = null;

    public static Random getRandom() {
        if(random == null) {
            random = new Random();
        }

        return random;
    }


    public static double getNextDoubleRandom() {
        if (random == null) {
            getRandom();
        }

        return random.nextDouble();
    }

    public static int getNextIntRandom(int number) {
        if (random == null) {
            getRandom();
        }

        return random.nextInt(number);
    }
}
