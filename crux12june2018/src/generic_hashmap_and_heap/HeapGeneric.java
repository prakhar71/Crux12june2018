package generic_hashmap_and_heap;

import java.util.ArrayList;

public class HeapGeneric<T extends Comparable<T>> {

	private ArrayList<T> data = new ArrayList<>();

	public int size() {
		return data.size();
	}

	public void insert(T item) {

		data.add(item);
		upheapify(this.size() - 1);
	}

	public void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	public void display() {
		System.out.println(data);
	}

	public T remove() {

		this.swap(0, this.size() - 1);
		T ans = data.remove(this.size() - 1);

		downheapify(0);

		return ans;

	}

	public void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if ((lci < data.size()) && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}

		if (((rci < data.size())) && isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
	}

	private void swap(int i, int j) {
		T ith = data.get(i);
		T jth = data.get(j);

		data.set(j, ith);
		data.set(i, jth);
	}

	private int isLarger(T t, T o) {

		return t.compareTo(o);
	}

	public boolean isEmpty() {

		return this.data.size() == 0;
	}

	public void updatePriority(T Pair) {
		int idx = -1;
		for (int i = 0; i < this.data.size(); i++) {

			if (this.data.get(i) == Pair) {
				idx = i;
			}
		}

		upheapify(idx);

	}

}
