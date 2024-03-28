package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 테스트")
public class CarTest {

    @Test
    @DisplayName("자동차 이름은 5자 이하만 가능하다.")
    void 자동차_이름_검증() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("5자가 넘는 이름"));
    }

    @Test
    @DisplayName("전진한다.")
    void 전진() {
        Car car = new Car("test");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동하지 않는다.")
    void 멈춤() {
        Car car = new Car("test");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
