package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringParser {
    private static final String DEFAULT_DELIMITER = ",:";
    private static final Pattern PATTERN = Pattern.compile("(//(.+)\\n)?(.*)");

    private StringParser() {
        throw new IllegalStateException("utility 입니다.");
    }

    public static List<Integer> parse(String numberSequence) {
        Matcher matcher = PATTERN.matcher(numberSequence);
        String delimiters = generateDelimiter(matcher);
        String numbers = matcher.group(3);

        return Arrays.stream(numbers.split(delimiters))
                .map(StringParser::parseElement)
                .collect(Collectors.toList());
    }

    private static String generateDelimiter(Matcher matcher) {
        StringBuilder sb = new StringBuilder(DEFAULT_DELIMITER);

        if (matcher.find() && Objects.nonNull(matcher.group(2))) {
            sb.append(matcher.group(2));
        }

        return new StringBuilder("[]")
                .insert(1, sb)
                .toString();
    }

    private static Integer parseElement(String element) {
        try {
            int number = Integer.parseInt(element);
            validateRange(number);
            return number;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void validateRange(int number) {
        if (number < 0) throw new IllegalArgumentException("양수를 입력해주세요.");
    }
}
