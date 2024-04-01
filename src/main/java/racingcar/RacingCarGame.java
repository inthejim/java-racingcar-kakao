package racingcar;

import calculator.NumberCalculator;

public class RacingCarGame {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printGuide();
        String names = inputView.getNames();
        Cars cars = new Cars(names);

        outputView.printTryCount();
        int tryCount = inputView.getNumber();

        playGame(tryCount, cars);
    }

    private static void playGame(int tryCount, Cars cars) {
        outputView.printResultGuide();
        NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(numberGenerator);
            outputView.printResult(cars);
        }

        outputView.printWinners(cars.pickWinners());
    }
}
