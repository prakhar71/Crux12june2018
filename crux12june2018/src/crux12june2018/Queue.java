package crux12june2018;

public class Queue {

	/*
	 * private int a[]; private int front =0,rear = 0;
	 * 
	 * public Queue() { a = new int [5];
	 * 
	 * 
	 * }
	 * 
	 * public Queue(int size) { a = new int [size]; }
	 * 
	 * public void Add(int n) throws Exception {
	 * 
	 * if(rear == a.length ) { rear--; throw new Exception("queue is full");
	 * 
	 * } a[rear] = n; rear++;
	 * 
	 * 
	 * 
	 * }
	 * 
	 * public int peek() { if(front == rear) return (Integer) null;
	 * 
	 * return a[front]; }
	 * 
	 * public int element()throws Exception{
	 * 
	 * if(front == rear) { throw new Exception("Queue is empty"); } return a[front];
	 * }
	 * 
	 * public int remove() throws Exception {
	 * 
	 * if(front == rear) { throw new Exception("Queue is empty"); }
	 * 
	 * int num =a[front];
	 * 
	 * for (int i = front; i < rear -1; i++) { a[i]=a[i+1];
	 * 
	 * } rear--; return num; }
	 * 
	 * public void display() { for (int i = 0; i < a.length; i++) {
	 * System.out.print(a[i] + " ,"); } System.out.println(rear); }
	 */

	protected int[] data;
	protected int front;
	protected int size;

	public Queue(int cap) {

		data = new int[cap];

	}

	public int size() {
		return data.length;
	}

	public boolean isEmpty() {
		if (data.length == 0) {
			return true;
		}
		return false;
	}

	public void enque(int item) throws Exception {

		int idx;

		if (this.size == data.length) {
			throw new Exception("Queue is full");
		}

		idx = (this.front + this.size) % data.length;
		data[idx] = item;
		this.size++;

	}

	public int deque() throws Exception {

		if (this.size == 0) {
			throw new Exception("Queue is empty");
		}

		int temp = data[this.front];
		data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;

		return temp;

	}

	public int getFront() throws Exception {

		if (this.size == 0) {
			throw new Exception("Queue is empty");
		}

		int temp = data[this.front];

		return temp;
	}

	public void displayQueue() {

		System.out.println("----------------------------\n");

		for (int i = 0; i < size; i++) {
			int idx = (i + front) % data.length;
			System.out.print(data[idx] + " ");
		}

		System.out.println("\n----------------------------");
	}

}
