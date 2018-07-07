package extra_class;

public class Cars implements Comparable<Cars> {

	int price;
	String color;
	int speed;

	
	public Cars(int speed, int price, String color) {
		this.speed = speed;
		this.price = price;
		this.color = color; 
		
	}
	
	@Override
	public int compareTo(Cars other) {
		return other.price - this.price;

	}
	
	@Override
	public String toString() {
		return this.speed + " " + this.price + " " + this.color;

	}

}
