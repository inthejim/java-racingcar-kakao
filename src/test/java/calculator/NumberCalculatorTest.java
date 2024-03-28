package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("숫자 계산기 단위 테스트")
public class NumberCalculatorTest {

    @Test
    @DisplayName("숫자 합을 계산한다.")
    void 숫자_합() {
        assertThat(NumberCalculator.calculate(List.of(1, 2, 3))).isEqualTo(6);
    }
}
