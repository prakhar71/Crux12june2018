package generic_hashmap_and_heap;

import java.util.ArrayList;

public class Heap {

	private ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return data.size();
	}

	public void insert(int item) {

		data.add(item);
		upheapify(this.size() - 1);
	}

	public void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (data.get(ci) < data.get(pi)) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	public void display() {
		System.out.println(data);
	}

	public int remove() {

		this.swap(0, this.size() - 1);
		int ans = data.remove(this.size() - 1);

		downheapify(0);

		return ans;

	}

	public void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if ((lci < data.size()) && data.get(lci) < data.get(mini)) {
			mini = lci;
		}

		if (((rci < data.size())) && data.get(rci) < data.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);

		data.set(j, ith);
		data.set(i, jth);
	}
	
	private void get() {
		// TODO Auto-generated method stub

	}
	
	

}
