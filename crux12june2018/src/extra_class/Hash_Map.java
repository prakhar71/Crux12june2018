package extra_class;

import java.util.ArrayList;
import java.util.HashMap;

public class Hash_Map {

	public void intersection(int a[], int b[]) {

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

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < b.length; i++) {
			if (map.containsKey(b[i]) && (map.get(b[i]) > 0)) {
				int of = map.get(b[i]);
				int nf = of - 1;
				map.put(b[i], nf);
				list.add(b[i]);
			}
		}

		System.out.println(list);
	}

	public void sequence(int a[]) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			int valp1 = a[i] + 1;
			int valm1 = a[i] - 1;

			if (map.containsKey(valm1)) {
				map.put(a[i], false);
			} else {
				map.put(a[i], true);
			}

			if (map.containsKey(valp1)) {
				map.put(valp1, false);
			}
		}
		
		
		ArrayList<Integer> list = new ArrayList<>();
		int maxcount = 0;
		int start=0;
		for(int key : map.keySet()) {
			
			if(map.get(key)) {
				int count=0;
				while(map.containsKey(key +count)) {
					count++;
				}
				
				if(count > maxcount) {
					start = key;
					maxcount = count;
				}
				
				
			}
		}
		
		for(int i=start;i<start +maxcount;i++) {
			list.add(i);
		}
		
		System.out.println(list);

	}
	
	

}
