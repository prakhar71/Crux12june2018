package demo_crux12june;

import generic_hashmap_and_heap.Cars;

public class CarsClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Cars []car = new Cars[5];
		car[0] = new  Cars(300,500,"blue");
		car[1] = new  Cars(500,960,"glue");
		car[2]= new  Cars(400,15450,"rlue");
		car[3]= new  Cars(900,14000,"vlue");
		car[4] = new  Cars(1400,2450,"plue");
		
		HeapDemoGeneric<Cars> h =new HeapDemoGeneric<>(); 
		h.insert(car[0]);
		h.insert(car[1]);
		h.insert(car[2]);
		h.insert(car[3]);
		h.insert(car[4]);
		
		h.remove();
		h.display();
		System.out.println("**************");
		h.remove();
		h.display();
		System.out.println("**************");
		h.remove();
		h.display();
		System.out.println("**************");
		h.remove();
		h.display();
		System.out.println("**************");
		h.remove();
		h.display();
		System.out.println("**************");
		
		
	}

}
