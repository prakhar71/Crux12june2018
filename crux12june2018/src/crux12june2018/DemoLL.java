package crux12june2018;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class DemoLL {

	private class Node {

		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("empty");
		}

		return this.tail.data;

	}

	public int getAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("invalid");
		}
		Node curr = this.head;
		for (int i = 0; i < idx; i++) {
			curr = curr.next;
		}

		return curr.data;

	}

	public Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("invalid");
		}
		Node curr = this.head;
		for (int i = 0; i <= idx; i++) {
			curr = curr.next;
		}

		return curr;
	}

	public void addFirst(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			nn.next = this.head;
			this.head = nn;
			this.size++;
		}

	}

	public void addLast(int item) {

		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		//connect
		if (this.size != 0) {
			this.tail.next = nn;
		}
		
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		}else {
			this.tail=nn;
			this.size++;
		}

	}

	public void addAt(int data, int idx) throws Exception {

		Node nn = new Node();
		nn.data = data;
		nn.next = null;
		
		if (idx < 0 || idx > this.size) {
			throw new Exception("invalid");
		}
		if(this.size == 0) {
			this.addFirst(data);
		}else if(idx == this.size) {
			this.addLast(data);
		}else {
			 Node im1=this.getNodeAt(idx-1);
			 Node ip1=im1.next;
			 
			 im1.next=nn;
			 nn.next=ip1;
			 this.size++;
		}
		
		
	}
	
	public int removeFirst() throws Exception {
		
		Node temp = this.head;
		if (this.size == 0) {
			throw new Exception("empty");
		}
		
		if(this.size == 1) {
			this.head=null;
			this.tail=null;
			this.size=0;
		}else {
			
			this.head=this.head.next;
			this.size--;
			temp.next=null;
		}
		
		return temp.data;
	}
	
	public int removeLast() throws Exception {
		Node temp = this.tail;
		if (this.size == 0) {
			throw new Exception("empty");
		}
		
		if(this.size == 1) {
			this.head=null;
			this.tail=null;
			this.size=0;
		}else {
			Node im2  =this.getNodeAt(this.size-2);
			im2.next=null;
			this.tail=im2;
			this.size--;
		}
		
		return temp.data;
		
	}
	
	
	
	public int removeAt(int idx) throws Exception {
		
		if (this.size == 0) {
			throw new Exception("empty");
		}
		
		if (idx < 0 || idx > this.size) {
			throw new Exception("invalid");
		}
		
		if(idx == 0) {
			return this.removeFirst();
		}
		
		if(idx == this.size-1) {
			return this.removeLast();
		}else {
			Node im1,ip1,i;
			im1=this.getNodeAt(idx-1);
			i=im1.next;
			ip1 = i.next;
			
			im1.next = ip1;
			this.size--;
			
			return i.data;
		}
		
		
	}
	
	public void display() {
		System.out.println("\n--------------------------");
		Node curr = this.head;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr=curr.next;
		}
		System.out.print("\n--------------------------");
	}

}
