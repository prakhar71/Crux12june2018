package demo_crux12june;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.sound.midi.Sequence;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {2,12,9,16,10,5,20,5,11,1,8,6};
		
		sequence(a);
	}

	
	private static void sequence(int a[]) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		
		for(int i=0;i<a.length;i++) {
			
			int valp1 = a[i]+1;
			int valm1 = a[i]-1;
			if(map.containsKey(valm1)) {
				map.put(a[i], false);
			}else {
				map.put(a[i], true);
			}
			
			if(map.containsKey(valp1)) {
				map.put(valp1, false);
			}
		}
		int maxcount = 0,startidx=0;
		Set<Map.Entry<Integer, Boolean>> e = map.entrySet();
		
		for(Map.Entry<Integer, Boolean> entry : e) {
			
			int key = entry.getKey();
			boolean val = entry.getValue();
		
			if(val) {
				int c=1;
				while(map.containsKey(key +c)) {
					c++;
					
				}
				if(c>maxcount) {
					maxcount =c;
					startidx=key;
				}
					
			}
			
		}
		
		for(int i=startidx;i<startidx + maxcount;i++) {
			System.out.println(i);
		}
		

	}
}
