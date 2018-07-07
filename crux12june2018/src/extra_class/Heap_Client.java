package extra_class;

import java.util.ArrayList;

import generic_hashmap_and_heap.Cars;

public class Heap_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cars []car = new Cars[5];
		car[0] = new  Cars(300,5000,"blue");
		car[1] = new  Cars(500,96000,"glue");
		car[2]= new  Cars(400,15450,"rlue");
		car[3]= new  Cars(900,14000,"vlue");
		car[4] = new  Cars(1400,2450,"blue");
		
		Heap_Generic<Cars> h = new Heap_Generic<>();
		h.insert(car[0]);
		h.insert(car[1]);
		h.insert(car[2]);
		h.insert(car[3]);
		h.insert(car[4]);
		
		
		System.out.println(h.remove());
	System.out.println(h.remove());

		System.out.println(h.remove());

		System.out.println(h.remove());

		System.out.println(h.remove());

	}
	
	public void mergeKSorted(ArrayList<ArrayList<Integer>> list) {
		
		Heap h = new Heap();
		
		for(int i=0;i<list.size();i++) {
			int val =list.get(i).get(0);
			h.insert(val);
			
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		int start = h.remove();
		
		
	}

}
