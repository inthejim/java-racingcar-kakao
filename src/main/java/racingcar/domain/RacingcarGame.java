package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingcarGame {

    private Cars cars;
    private int tryCount;
    private NumberGenerator numberGenerator = new NumberGenerator();

    public RacingcarGame(String names, int tryCount) {
        validateInput(names, tryCount);
        this.cars = new Cars(names);
        this.tryCount = tryCount;
    }

    private void validateInput(String names, int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수이어야 합니다.");
        }
    }

    public boolean isEnd() {
        return tryCount == 0;
    }

    public void race() {
        cars.moveAll(numberGenerator);
        tryCount--;
    }

    public Cars getCars() {
        return this.cars;
    }

    public List<String> pickWinners() {
        return cars.pickWinners()
                .stream()
                .map(CarName::getName)
                .collect(Collectors.toList());
    }
}
