package crux12june2018;

public class LinkedList {

	class Node {
		int data;
		Node next;
	}

	private class Mover {
		Node left;
	}

	protected Node head;
	protected Node tail;
	protected int size;

	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty");
		}
		return this.head.data;
	}

	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty");
		}
		return this.tail.data;

	}

	public int getAt(int idx) throws Exception {

		Node temp = this.head;

		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("idx not valid");
		}

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	public Node getNodeAt(int idx) throws Exception {

		Node temp = this.head;

		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("idx not valid");
		}

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	public void addLast(int item) {
		// create new node
		Node nn = new Node();

		nn.data = item;
		nn.next = null;

		// connect
		if (this.size != 0) {
			this.tail.next = nn;
		}

		// update data
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}

	}

	public void addFirst(int item) {
		// create new node
		Node nn = new Node();

		nn.data = item;
		nn.next = null;

		// connect
		if (this.size != 0) {
			nn.next = this.head;
		}

		// update data
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	public void addAt(int idx, int item) throws Exception {
		// create new node
		Node nn = new Node();

		nn.data = item;
		nn.next = null;

		if (this.size == 0) {
			this.addFirst(item);
		}
		if (idx == this.size) {
			this.addLast(item);
		}

		if (idx < 0 || idx > this.size) {
			throw new Exception("idx not valid");
		}

		Node im1 = this.getNodeAt(idx - 1);
		Node ip1 = im1.next;
		im1.next = nn;
		nn.next = ip1;
	}

	public int removeFirst() throws Exception {

		Node temp = this.head;
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		else if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return temp.data;
	}

	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		Node temp = tail;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}

		else {
			Node sm2 = getNodeAt(this.size - 2);
			sm2.next = null;
			this.tail = sm2;
			this.size--;
		}

		return temp.data;
	}

	public int removeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		else if (idx < 0 || idx > this.size) {
			throw new Exception("idx not valid");
		} else if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size - 1) {
			return this.removeLast();
		} else {
			Node im1 = this.getNodeAt(idx - 1);
			Node ip1 = this.getNodeAt(idx + 1);
			Node i = this.getNodeAt(idx);
			im1.next = ip1;

			return i.data;
		}

	}

	public void display() {
		System.out.println("\n--------------------");
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " ,");
			temp = temp.next;
		}
		System.out.println("\n-----------------------");
	}

	public void reverseDataItem() throws Exception {
		int fwd = 0;
		int bwd = this.size - 1;
		int temp;
		while (fwd < bwd) {
			/// swap
			temp = this.getNodeAt(fwd).data;
			this.getNodeAt(fwd).data = this.getNodeAt(bwd).data;
			this.getNodeAt(bwd).data = temp;

			bwd--;
			fwd++;

		}

	}

	public void reversePointers() {

		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {

			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}

		Node h = this.head;
		Node t = this.tail;

		this.head = t;
		this.tail = h;
		this.tail.next = null;

	}

	public void RPointerRec() {
		RPointerRec(this.head, this.head.next);

		Node h = this.head;
		Node t = this.tail;

		this.head = t;
		this.tail = h;
		this.tail.next = null;

	}

	private void RPointerRec(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		RPointerRec(curr, curr.next);

		// ******reversing the links
		curr.next = prev;

	}

	public void RDataRec() {

		Mover mover = new Mover();
		mover.left = this.head;
		RDataRec(mover, this.head, 0);
	}

	public void RDataRec(Mover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		RDataRec(mover, right.next, count + 1);
		if (count >= size / 2) {

			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;
	}

	public void fold() {
		Mover mover = new Mover();
		mover.left = this.head;
		fold(mover, this.head, 0);
	}

	public void fold(Mover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		fold(mover, right.next, count + 1);

		// *******count comes down from 5 to 3 for this if
		if (count > size / 2) {

			Node temp;
			temp = mover.left.next;
			mover.left.next = right;
			right.next = temp;
			mover.left = temp;
		}
		if (count == size / 2) {
			this.tail = right;// *****
			this.tail.next = null;
		}

	}

	public Node mid() {

		Node slow, fast;
		slow = this.head;
		fast = this.head;

		while ((fast.next != null) && (fast.next.next != null)) {

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public int kthFromLast(int k) {

		Node slow, fast;
		slow = this.head;
		fast = this.head;

		for (int i = 0; i < k - 1; i++) {
			fast = fast.next;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	public void kReverse(int k) throws Exception {

		LinkedList prev = null;
		while (this.size != 0) {

			LinkedList curr = new LinkedList();
			for (int i = 1; i <= k; i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size = prev.size + curr.size;
			}

		}

		this.size = prev.size;
		this.head = prev.head;
		this.tail = prev.tail;

	}

	@SuppressWarnings("unused")
	public static LinkedList merge2SortedLL(LinkedList l1, LinkedList l2) {

		LinkedList list = new LinkedList();

		Node t1 = l1.head;
		Node t2 = l2.head;

		while (t1 != null && t2 != null) {

			if (t1.data < t2.data) {
				list.addLast(t1.data);
				t1 = t1.next;

			} else {
				list.addLast(t2.data);
				t2 = t2.next;

			}
		}

		if (t1 == null) {

			while (t2 != null) {
				list.addLast(t2.data);
				t2 = t2.next;
			}
		} else {
			while (t1 != null) {
				list.addLast(t1.data);
				t1 = t1.next;
			}

		}

		return list;

	}
	
	public static  LinkedList mergeSort(LinkedList list) {
		
		if(list.size == 1) {
			return list;
		}
		
		LinkedList fp = new LinkedList();
		LinkedList sp = new LinkedList();
		
		
		Node midn = list.mid();
		fp.head = list.head;
		Node temp = midn.next;
		sp.head = temp;
		sp.tail=list.tail;
		sp.tail.next=null;
		
		midn.next = null;
		fp.tail = midn;
		fp.tail.next=null;
		fp.size = (list.size+1)/2;
		sp.size=list.size/2;
		
		
		
		
		LinkedList ans = merge2SortedLL(mergeSort(fp), mergeSort(sp));
		return ans;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
