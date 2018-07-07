package generic_hashmap_and_heap;

import java.util.Comparator;

public class CarsColorComparator implements Comparator<Cars> {

	@Override
	public int compare(Cars ocar, Cars tcar) {
	return tcar.compareTo(ocar);
	}

}
