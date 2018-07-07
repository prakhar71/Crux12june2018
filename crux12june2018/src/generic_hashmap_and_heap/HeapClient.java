package generic_hashmap_and_heap;

public class HeapClient {

	public static void main(String[] args) {

		Heap h = new Heap();

		h.insert(20);
		h.insert(300);
		h.insert(40);
		h.insert(5);
		h.insert(60);

		h.display();

		System.out.println(h.remove());
		System.out.println(h.remove());
		System.out.println(h.remove());
		System.out.println(h.remove());
		System.out.println(h.remove());

	}

}
