package racingcar;

public class RacingMain {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printGuide();
        String names = inputView.getNames();

        outputView.printTryCount();
        int tryCount = inputView.getNumber();

        playGame(tryCount, names);
    }

    private static void playGame(int tryCount, String names) {
        outputView.printResultGuide();

        RacingcarGame racingcarGame = new RacingcarGame(names, tryCount);
        while(!racingcarGame.isEnd()){
            racingcarGame.race();
            outputView.printResult(racingcarGame.getCars());
        }

        outputView.printWinners(racingcarGame.pickWinners());
    }
}
