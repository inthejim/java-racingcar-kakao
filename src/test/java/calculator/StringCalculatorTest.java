package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 계산기 단위 테스트")
public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {""})
    @DisplayName("빈 문자열 또는 null을 입력할 경우 0을 반환한다.")
    void 빈문자열_혹은_null(String input) {
        assertThat(calculator.calculate(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환한다.")
    void 숫자하나(String input) {
        assertThat(calculator.calculate(input)).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "1,2,3", "1,2:3"})
    @DisplayName("기본 구분자를 기준으로 분리해 합을 계산한다.")
    void 기본구분자_분리(String input) {
        assertThat(calculator.calculate(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1,2;3"})
    @DisplayName("커스텀 구분자를 기준으로 분리해 합을 계산한다.")
    void 커스텀구분자_분리(String input) {
        assertThat(calculator.calculate(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㄱ,1,2", "1,ㄱ,2", "ㄱ"})
    @DisplayName("숫자 이의외 값을 전달할 경우 RuntimeException 예외를 던진다.")
    void 숫자_이외의_값(String input) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.calculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "1,-3,2"})
    @DisplayName("음수 값을 전달할 경우 RuntimeException 예외를 던진다.")
    void 음수_값(String input) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.calculate(input));
    }
}
