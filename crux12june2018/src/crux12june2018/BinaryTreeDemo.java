package crux12june2018;

import java.util.Scanner;

public class BinaryTreeDemo {

	public BinaryTreeDemo(int[] pre, int[] in) {
		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi) {
			return null;
		}

		int si = -1, noe;
		Node nn = new Node();
		nn.data = pre[plo];

		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pre[plo]) {
				si = i;
				break;
			}
		}
		noe = si - ilo;

		nn.left = construct(pre, plo + 1, plo + noe, in, ilo, si - 1);
		nn.right = construct(pre, plo + noe + 1, phi, in, si + 1, ihi);

		return nn;

	}

	public void printInRange(int sidx, int eidx) {
		printInRange(this.root, sidx, eidx);
	}

	private void printInRange(Node node, int sidx, int eidx) {

		if(node == null) {
			return;
		}
		
		if (sidx > node.data) { // correct
			printInRange(node.right, sidx, eidx);
		} else if (sidx < node.data) {
			printInRange(node.left, sidx, eidx);
		} else { // print
			System.out.println(node.data);
			return;
		}

		if (eidx > node.data) {
			printInRange(node.right, sidx, eidx);
		} else if (eidx < node.data) { // correct
			printInRange(node.left, sidx, eidx);
		} else {
			System.out.println(node.data);
			return;
		}
	}

	public class Node {
		int data;
		Node left;
		Node right;
	}

	Scanner scn;

	private Node root;

	public BinaryTreeDemo(String str) {
		scn = new Scanner(str);
		this.root = takeInput(null, false);
	}

	private Node takeInput(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int item = scn.nextInt();
		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			nn.left = takeInput(nn, true);
		}

		System.out.println(nn.data + " has right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			nn.right = takeInput(nn, false);
		}

		return nn;
	}

	public void display() {

		System.out.println("-------------");
		display(this.root);
		System.out.println("-------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		int ans = Math.max(node.data, Math.max(lm, rm));

		return ans;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;
	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	public boolean isBalanced() {

		return isBalanced(this.root);
	}

	private boolean isBalanced(Node node) {

		boolean lftbal, rtbal;
		
		if(node == null ) {
			return true;
		}

		int lh = this.ht(node.left);
		int rh = this.ht(node.right);

		int ans = Math.abs((lh - rh));
		if (ans == 0 || ans == 1) {
			lftbal = isBalanced(node.left);
			rtbal = isBalanced(node.right);

			if (lftbal && rtbal) {
				return true;
			} else
				return false;

		} else {
			return false;
		}

	}

	private class Bpair {
		boolean isBalanced;
		int height;
	}

	public boolean Balanced() {

		return Balanced(this.root).isBalanced;
	}

	private Bpair Balanced(Node node) {

		if (node == null) {
			Bpair bp = new Bpair();
			bp.height = -1;
			bp.isBalanced = true;
			return bp;
		}

		Bpair lp = Balanced(node.left);
		Bpair rp = Balanced(node.right);

		Bpair sp = new Bpair();

		int lph = lp.height;
		int rph = rp.height;
		sp.height = Math.max(lph, rph) + 1;

		boolean lpib = lp.isBalanced;
		boolean rpib = rp.isBalanced;

		int ans = lph - rph;
		if (lpib && rpib && ans >= -1 && ans <= 1) {
			sp.isBalanced = true;
		} else {
			sp.isBalanced = false;
		}

		return sp;

	}

	public int diameter() {
		return diameter(this.root);

	}

	private int diameter(Node node) {

		int l, r, sp;

		if (node == null) {
			return 0;
		}

		l = diameter(node.left);
		r = diameter(node.right);

		sp = this.ht(node.left) + this.ht(node.right) + 2;

		return Math.max(sp, Math.max(l, r));
	}

	private class Pair {
		int height;
		int diameter;

	}

	public int diameter2() {

		Pair p = diameter2(this.root);
		return p.height;
	}

	private Pair diameter2(Node node) {
		Pair sp = new Pair();

		if (node == null) {

			sp.height = -1;
			sp.diameter = 0;

			return sp;
		}

		Pair lp = diameter2(node.left);
		Pair rp = diameter2(node.right);

		int lph = lp.height;
		int rph = rp.height;

		sp.height = Math.max(lph, rph) + 1;

		int lpd = lp.diameter;
		int rpd = rp.diameter;

		int spd = lpd + rpd + 2;

		sp.diameter = Math.max(spd, Math.max(lpd, rpd));

		return sp;

	}

	public class BSTpair {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		boolean isBst = true;
		Node Lbstroot;
		int size = 0;
	}

	public void biggestBST() {
		BSTpair bp = biggestBST(this.root);
		System.out.println(bp.Lbstroot.data);
		System.out.println(bp.size);
	}

	private BSTpair biggestBST(Node node) {

		if (node == null) {
			BSTpair bp = new BSTpair();

			return bp;

		}

		BSTpair lp = biggestBST(node.left);

		BSTpair rp = biggestBST(node.right);

		BSTpair sp = new BSTpair();
		sp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		sp.min = Math.min(node.data, Math.min(lp.min, rp.min));

		if (node.data >= lp.max && node.data <= rp.min && lp.isBst && rp.isBst) {
			sp.isBst = true;
			sp.Lbstroot = node;
			sp.size = lp.size + rp.size + 1;
		} else {
			if (lp.size > rp.size) {
				sp.Lbstroot = lp.Lbstroot;
				sp.size = lp.size;
				sp.isBst = false;
			} else {
				sp.Lbstroot = rp.Lbstroot;
				sp.size = rp.size;
				sp.isBst = false;
			}

		}

		return sp;
	}

}
