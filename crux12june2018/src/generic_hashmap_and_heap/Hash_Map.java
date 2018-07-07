package generic_hashmap_and_heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Hash_Map {

	public static void main(String[] args) {

		int a[] = {10,20,5,30,40,30,40,5};
		int b[] = {5,10,10,25,30,30,40,2};
		
		intersection(a, b);

	}

	public static ArrayList<Integer> sequence(int a[]) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			int val = a[i];

			if (map.containsKey(val - 1)) {

				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {

				map.put(val + 1, false);
			}

		}

		Set<Integer> keys = map.keySet();

		int starting = 0;
		int maxcount = 0;
		for (int val : keys) {

			if (map.get(val)) {

				int c = 0;
				while (map.containsKey(val + c)) {
					c++;
				}

				if (c > maxcount) {
					maxcount = c;
					starting = val;
				}

			}

		}

		for (int i = starting; i < starting + maxcount; i++) {

			list.add(i);
		}

		return list;

	}

	private static void intersection(int a[], int b[]) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				int of = map.get(a[i]);
				int nf = of + 1;
				map.put(a[i], nf);
			} else {
				map.put(a[i], 1);
			}
		}

		for (int i = 0; i < b.length; i++) {

			if (map.containsKey(b[i]) && (map.get(b[i]) > 0)) {
				int of = map.get(b[i]);
				int nf = of - 1;
				map.put(b[i], nf);
				System.out.println(b[i] + " ");
			}
		}

	}

}
