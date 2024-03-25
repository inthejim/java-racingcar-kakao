public class Car {
	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public void move(int number) {
		if(number>3){
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}
}