package demo_crux12june;

public class BST {

	public class Node {
		int data;
		Node left;
		Node right;

	}

	Node root;

	public BST(int pre[], int[] in) {

	}

	public void display() {
		System.out.println("----------");
		display(this.root);
		System.out.println("----------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		// self work
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

		// left
		display(node.left);
		// right
		display(node.right);

	}

	private class Mover {
		int sum;
	}

	public void replaceWSOL() {

		Mover mover = new Mover();
		replaceWSOL(this.root, mover);
	}

	private void replaceWSOL(Node node, Mover mover) {

		if (node == null) {
			return;

		}

		replaceWSOL(node.right, mover);

		// swaping

		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;

		//
		replaceWSOL(node.left, mover);

		return;

	}

	private class BSTclass {

		int max=Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		Node LBSTroot;
		
		int size = 0;
		boolean isBst=true;
		
	}
	
	public int Biggest() {
		 Biggest(this.root);
		
		
		
	}

	private BSTclass Biggest(Node node) {
		
		if(node == null) {
			BSTclass bp = new BSTclass();
			return bp;
		}
		
		
		BSTclass lp = Biggest(node.left);
		
		BSTclass rp = Biggest(node.right);
		
		BSTclass sp = new BSTclass();
		
		sp.max =Math.max(node.data, Math.max(lp.max, rp.max));
		sp.min =Math.min(node.data, Math.min(lp.min, rp.min));
		
		if(node.data > lp.max && node.data < rp.max  && lp.isBst && rp.isBst) {
			
			sp.isBst=true;
			sp.size=lp.size+rp.size +1;
			sp.LBSTroot = node;
		}else {
			sp.isBst = false;
			if(lp.size > rp.size) {
				
				sp.LBSTroot = lp.LBSTroot;
				sp.size =lp.size;
			}else {
				sp.LBSTroot = rp.LBSTroot;
				sp.size =rp.size;
			}
			
			
		}
		
		return sp;
		
		
	}
}
