package racingcar;

import java.util.List;

public class OutputView {

    public void printGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void printResultGuide() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public void printResult(Cars cars) {
        System.out.println(cars);
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
