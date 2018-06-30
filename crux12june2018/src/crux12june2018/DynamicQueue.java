package crux12june2018;

public class DynamicQueue extends Queue {

	public DynamicQueue(int cap) {
		super(cap);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enque(int item) throws Exception {

		int[] oq = this.data;
		int[] nq = new int[oq.length * 2];

		if (this.size == this.data.length) {

			for (int i = 0; i < this.size; i++) {

				int idx = (this.front + i) % data.length;

				nq[i] = data[idx];

			}

			this.data = nq;
			this.front = 0;
		}

		super.enque(item);
	}

}
