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

	public List<Integer> parse(String numberSequence) {
		Matcher matcher = PATTERN.matcher(numberSequence);
		String delimiters = generateDelimiter(matcher);
		String numbers = matcher.group(3);

		return Arrays.stream(numbers.split(delimiters))
			.map(this::parseElement)
			.collect(Collectors.toList());
	}

	private String generateDelimiter(Matcher matcher) {
		StringBuilder sb = new StringBuilder(DEFAULT_DELIMITER);

		if (matcher.find() && Objects.nonNull(matcher.group(2))) {
			sb.append(matcher.group(2));
		}

		return "[" + sb + "]";
	}

	private Integer parseElement(String element) {
		try {
			int number = Integer.parseInt(element);
			if (number < 0) throw new IllegalArgumentException("숫자를 입력해주세요.");
			return number;
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("숫자를 입력해주세요.");
		}
	}
}