package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 파싱 단위 테스트")
class StringParserTest {

    @Test
    @DisplayName("숫자 하나를 입력한 경우 해당 숫자를 반환한다.")
    void 구분자_없는_경우_파싱() {
        assertThat(StringParser.parse("1")).containsExactly(1);
    }

    @Test
    @DisplayName("기본 구분자를 기준으로 분리한 숫자를 반환한다.")
    void 기본_구분자_파싱() {
        assertThat(StringParser.parse("1,2:3")).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("커스텀 구분자를 기준으로 분리한 숫자를 반환한다.")
    void 커스텀_구분자_파싱() {
        assertThat(StringParser.parse("//;\n1;2;3")).containsExactly(1, 2, 3);
    }
}