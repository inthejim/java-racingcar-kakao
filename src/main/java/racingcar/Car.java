package racingcar;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int CRITERION_FOR_MOVING = 3;

    private final String name;
    private int position;


    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
    }

    public void move(int number) {
        if (number > CRITERION_FOR_MOVING) {
            this.position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
