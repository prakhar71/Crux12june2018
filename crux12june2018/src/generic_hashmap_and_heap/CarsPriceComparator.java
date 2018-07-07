package generic_hashmap_and_heap;

import java.util.Comparator;

import javax.xml.crypto.dsig.CanonicalizationMethod;

public class CarsPriceComparator implements Comparator<Cars> {

	@Override
	public int compare(Cars tcar, Cars ocar) {
		return ocar.price-tcar.price;
	}

}
