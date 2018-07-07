package generic_hashmap_and_heap;

import java.util.Comparator;

public class CarsSpeedComparator implements Comparator<Cars> {

	@Override
	public int compare(Cars tcar,Cars ocar) {
		
		
		return tcar.speed-ocar.speed;
	}

}
