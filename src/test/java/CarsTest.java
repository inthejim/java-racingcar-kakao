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
	@DisplayName("자동차들을 이동시킨다.")
	void 자동차_이동_시도() {
		Cars cars = new Cars("pohi,crong,honux");
		cars.move();
	}
}