package generic_hashmap_and_heap;

import java.util.Comparator;

public class CarsDemo  {

	int speed;
	int price;
	String color;

	public CarsDemo(int speed, int price, String color) {
		this.speed = speed;
		this.price = price;
		this.color = color;
	}

	@Override
	public String toString() {

		return this.speed + " " + this.color + " " + this.price;
	}

	public static <T extends Comparable<T>>void bubbleSort(T arr[]) {

		T temp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				
				if (arr[j + 1].compareTo(arr[j]) > 0) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
		}
	}

	
	/*public int compareTo(CarsDemo oth) {

		return oth.price - this.price;

	}*/
	
	
	public static <T>void bubbleSort(T arr[],Comparator<T> comparator) {

		T temp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				
				if (comparator.compare(arr[j+1],arr[j])>0) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
		}
	}
}
