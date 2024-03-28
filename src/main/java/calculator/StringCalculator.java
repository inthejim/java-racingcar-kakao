package calculator;

import java.util.Objects;

public class StringCalculator {
    private static final int DEFAULT_VALUE = 0;

    public int calculate(String numberSequence) {
        if (Objects.isNull(numberSequence) || numberSequence.isEmpty()) {
            return DEFAULT_VALUE;
        }

        return NumberCalculator.calculate(StringParser.parse(numberSequence));
    }
}
