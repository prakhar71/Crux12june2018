package crux12june2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

	}

	Scanner scn;
	private Node root;

	public GenericTree(String str) {
		scn = new Scanner(str);
		this.root = takeInput(null, -1);
	}

	private Node takeInput(Node parent, int ith) {

		if (parent == null) {
			System.out.println("enter the value of root node");
		} else {
			System.out.println("enter the value of " + ith + " child of" + parent.data + "node");
		}

		int item = scn.nextInt();
		Node nn = new Node();

		nn.data = item;

		System.out.println("enter the no of child of " + nn.data + " node");

		int k = scn.nextInt();

		for (int i = 0; i < k; i++) {
			Node child = takeInput(nn, i);
			nn.children.add(child);
		}

		return nn;
	}

	public void display() {

		System.out.println("-------------------");
		display(this.root);
		System.out.println("--------------------");
	}

	private void display(Node parent) {

		String str = parent.data + " -> ";
		for (Node child : parent.children) {
			str += child.data + " ";
		}
		System.out.println(str);

		for (Node child : parent.children) {
			display(child);
		}
	}

	public int size() {
		return size(this.root);

	}

	private int size(Node node) {
		int count = 0;
		for (Node child : node.children) {
			count = count + size(child);
		}

		return count + 1;
	}

	public boolean find(int item) {

		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {
			boolean ans = find(child, item);
			if (ans == true) {
				return true;
			}
		}

		return false;

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		int max = node.data;

		for (Node child : node.children) {
			int ans = max(child);
			if (ans > max) {
				max = ans;
			}
		}

		return max;

	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		int maxh = -1;
		if (node.children.size() == 0) {
			return 0;
		}

		for (Node child : node.children) {

			int ans = height(child);
			if (ans > maxh) {
				maxh = ans;
			}
		}

		return maxh + 1;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {

			mirror(child);
		}

		Collections.reverse(node.children);
	}

	public void levelTraversal() {

		levelTraversalR(this.root);
	}

	private void levelTraversalR(Node node) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= this.height(); i++) {
			printAtLevel(this.root, 0, i);
		}

	}

	public void printAtLevel(Node node, int count, int level) {

		if (count == level) {
			System.out.println(node.data);
		}

		for (Node child : node.children) {
			printAtLevel(child, count + 1, level);
		}
	}

	public void levelOrderI() {

		LinkedList<Node> list = new LinkedList<Node>();
		Node temp;
		list.add(this.root);
		while (list.isEmpty() != true) {
			temp = list.removeFirst();
			System.out.println(temp.data);
			for (Node child : temp.children) {
				list.addLast(child);
			}

		}

	}

}
