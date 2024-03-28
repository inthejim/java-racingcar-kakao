package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_NAME_DELIMITER = ",";
    public static final int DEFAULT_POSITION = 0;

    private final List<Car> cars;

    public Cars(String s) {
        this(Arrays.asList(s.split(CAR_NAME_DELIMITER)));
    }

    public Cars(List<String> carNames) {
        validateNotDuplicated(carNames);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private void validateNotDuplicated(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveAll(NumberGenerator generator) {
        for (Car car : cars) {
            car.move(generator.generateNumber());
        }
    }

    public List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public List<String> pickWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_POSITION);
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
