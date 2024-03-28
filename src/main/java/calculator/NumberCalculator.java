package calculator;

import java.util.List;

public class NumberCalculator {

    private NumberCalculator() {
        throw new IllegalStateException("utility 입니다.");
    }

    public static int calculate(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
