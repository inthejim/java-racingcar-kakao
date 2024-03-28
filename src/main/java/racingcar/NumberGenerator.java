package racingcar;

import java.util.Random;

public class NumberGenerator {
    private static final int NUMBER_RANGE = 9;

    public int generateNumber() {
        Random rand = new Random();
        return rand.nextInt(NUMBER_RANGE + 1);
    }
}
