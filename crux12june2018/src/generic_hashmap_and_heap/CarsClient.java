package generic_hashmap_and_heap;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CarsClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		CarsDemo  c1 = new  CarsDemo(300,5000,"blue");
		CarsDemo  c2 = new  CarsDemo(500,96000,"glue");
		CarsDemo  c3 = new  CarsDemo(400,15450,"rlue");
		CarsDemo  c4 = new  CarsDemo(900,14000,"vlue");
		CarsDemo  c5 = new  CarsDemo(1400,2450,"plue");
		
		System.out.println(c1);
		int a[] = {100,53,17,89,245,614,78,2,24,6,5};
		//CarsDemo.bubbleSort(a);
		
		/*for(Integer val : a) {
			System.out.println(val);
		}*/
	
		
		//System.out.println(c1.compareTo(c5));
		
		Cars []car = new Cars[5];
		car[0] = new  Cars(300,5000,"blue");
		car[1] = new  Cars(500,96000,"glue");
		car[2]= new  Cars(400,15450,"rlue");
		car[3]= new  Cars(900,14000,"vlue");
		car[4] = new  Cars(1400,2450,"plue");
		
		CarsDemo.bubbleSort(car,new CarsSpeedComparator());
		for(Cars val : car) {
			System.out.println(val);
		}
		System.out.println("*****************");
		CarsDemo.bubbleSort(car, new CarsColorComparator() );
		for(Cars val : car) {
			System.out.println(val);
		}
		System.out.println("*****************");
		CarsDemo.bubbleSort(car, new CarsPriceComparator());
		for(Cars val : car) {
			System.out.println(val);
		}
		
	}

}
