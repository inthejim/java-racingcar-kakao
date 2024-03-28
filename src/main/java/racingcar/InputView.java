package racingcar;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String getNames() {
        return scanner.next();
    }

    public int getNumber() {
        return scanner.nextInt();
    }
}
