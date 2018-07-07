package extra_class;

import java.util.ArrayList;

public class Heap_Generic<T extends Comparable<T>> {
	
	ArrayList<T> data = new ArrayList<>();
	
	
	
	public T remove() {

		swap(0,data.size() -1);
		T rv =data.remove(data.size()-1);
		downheapify(0);
		
		return rv;
	}
	
	private void downheapify(int pi) {
		int lci = 2*pi + 1;
		int rci = 2*pi +2;
		
		int mini = pi;
		
		if((lci < data.size())  && isLarger(data.get(lci), data.get(mini)) >0) {
			mini = lci;
		}
		
		if( (rci < data.size())  && isLarger(data.get(rci), data.get(mini)) >0) {
			mini = rci;
		}
		
		if(mini != pi) {
			swap(mini,pi);
			downheapify(mini);
		}
		
	}

	public void swap(int i,int j) {
		T ith = data.get(i);
		T jth = data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
		
	}
	
	public void insert(T item) {
		
		data.add(item);
		upheapify(data.size()-1);
		

	}

	private void upheapify(int ci) {
		
		int pi = (ci-1)/2;
		
		//no base case required as (0-1)/2 = 0
		if(isLarger(data.get(ci),data.get(pi)) >0) {
			swap(pi,ci);
			upheapify(pi);
		}
		
	}
	
	public int isLarger(T t,T o) {
		return t.compareTo(o);
	}
	
	

}
