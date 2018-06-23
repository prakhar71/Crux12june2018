package crux12june2018;

public class Stack {

	int[] data;
	private int tos = -1;

	public Stack() {

		data = new int[5];

	}

	public Stack(int cap) {
		data = new int[cap];
	}

	public int size() {

		return data.length;
	}

	public boolean isEmpty() {

		if (tos == -1)
			return true;
		return false;
	}

	public void push(int item) throws Exception {

		if (tos == data.length - 1) {
			throw new Exception("stack is full");
		}
		tos++;
		data[tos] = item;
	}

	public int pop() throws Exception {

		if (tos == -1) {
			throw new Exception("stack is empty");
		}

		int rv = data[tos];
		data[tos] = 0;
		tos--;

		return rv;

	}

	public int peek() throws Exception {

		if (tos == -1) {
			throw new Exception("stack is empty");
		}

		return data[tos];
	}

	public void display() {
		System.out.println("------------------------");
		int i;
		for (i = this.tos; i >= 0; i--) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		System.out.println("------------------------");
	}
}
