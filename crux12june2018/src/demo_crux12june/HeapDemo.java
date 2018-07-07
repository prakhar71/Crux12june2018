package demo_crux12june;

import java.util.ArrayList;

public class HeapDemo {

	private ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return data.size();
	}

	public void display() {
		System.out.println(data);
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);

		data.set(j, ith);
		data.set(i, jth);
	}

	public void insert(int item) {

		data.add(item);
		int ci = data.size() - 1;
		int pi = (ci - 1) / 2;
		upheapify(ci);

	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;
		if (pi < 0) {
			return;
		}

		if (data.get(ci) < data.get(pi)) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	public void remove() {

		swap(0, data.size() - 1);

		downheapify(0);

	}

	private void downheapify(int pi) {

		
		
		int rci = 2 * pi + 2;
		int lci = 2 * pi + 1;
		
		if(lci >= data.size() || rci >= data.size()) {
			return;
		}

		int mini ;
		
		if(data.get(lci)<data.get(rci)) {
			mini = lci;
		}else {
			mini=rci;
		}
		
		if(data.get(mini)>data.get(pi)) {
			mini = pi;
		}
		
		
		if(mini != pi) {
			swap(mini,pi);
			downheapify(mini);
		}

	}
}
