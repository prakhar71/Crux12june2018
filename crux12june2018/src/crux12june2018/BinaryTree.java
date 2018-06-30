package crux12june2018;

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;
	int size;

	public boolean isBalanced() {

		return isBalanced(this.root);
	}

	private boolean isBalanced(Node node) {

		boolean lftbal, rtbal;

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
	
	private class Bpair{
		boolean isBalanced;
		int height;
	}
	
	
	public boolean Balanced() {
		
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

		sp = this.ht(l) + this.ht(r) + 2;

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

}
