package racingcar;

import java.util.Random;

public class NumberGenerator {
    private static final int NUMBER_RANGE = 9;
    private final Random rand = new Random();

    public int generateNumber() {
        return rand.nextInt(NUMBER_RANGE + 1);
    }
}
