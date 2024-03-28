package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cars 딘위 테스트")
class CarsTest {

    @Test
    @DisplayName("자동차들을 생성한다.")
    void 자동차_생성() {
        Cars cars = new Cars("pobi,crong,honux");
        List<String> carNames = cars.getCarNames();
        assertThat(carNames).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("중복된 이름의 차가 존재할 경우 중지한다")
    void 중복된_이름_검증() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Cars("pobi,pobi,honux"));
    }

    @Test
    @DisplayName("자동차들을 이동시킨다.")
    void 자동차_이동_시도() {
        Cars cars = new Cars("pohi,crong,honux");
        cars.moveAll(new NumberGenerator() {
            int n = 0;

            @Override
            public int generateNumber() {
                if (n < 2) {
                    n++;
                    return 10;
                }
                return 1;
            }
        });

        assertThat(cars.getCarPositions()).containsExactly(1, 1, 0);
    }

    @Test
    @DisplayName("우승자 목록을 반환한다.")
    void 우승자_목록_반환() {
        Cars cars = new Cars("pohi,crong,honux");
        cars.moveAll(new NumberGenerator() {
            int n = 0;

            @Override
            public int generateNumber() {
                if (n < 2) {
                    n++;
                    return 10;
                }
                return 1;
            }
        });

        assertThat(cars.pickWinners()).containsExactly("pohi", "crong");
    }
}