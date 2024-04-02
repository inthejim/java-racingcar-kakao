package racingcar.domain;

public class Car {
    public static final String MOVEMENT_SYMBOL = "-";
    private static final int INITIAL_POSITION = 0;
    private static final int CRITERION_FOR_MOVING = 3;


    private final CarName name;
    private int position;


    public Car(String name) {
        this.name = new CarName(name);
        this.position = INITIAL_POSITION;
    }

    public void move(int number) {
        if (number > CRITERION_FOR_MOVING) {
            position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public CarName getCarName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + MOVEMENT_SYMBOL.repeat(position);
    }
}
