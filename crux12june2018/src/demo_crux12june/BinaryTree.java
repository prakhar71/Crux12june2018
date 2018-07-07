package demo_crux12june;

import java.util.Scanner;

import demo_crux12june.BST.Node;

public class BinaryTree {
	
	private class Node{
		int data;
		Node left;
		Node right;
		
	}
	
	Scanner scn;
	Node root;
	
	public BinaryTree(String str) {
		scn = new Scanner(str);
	this.root =	takeInput(null,false);
		
		
	}
	
	public BinaryTree(int pre[],int in[]) {
		this.root=construct(pre, 0, pre.length-1, in, 0, in.length-1);
	}
	
	public Node construct(int[] pre, int plo, int phi, int in[], int ilo, int ihi) {
		int si = -1, noe;
		Node nn = new Node();
		nn.data = pre[plo];

		if (plo > phi) {
			return null;
		}

		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pre[plo]) {
				si = i;
				break;
			}
		}

		noe = si - plo;
		// left construct
		nn.left = construct(pre, plo + 1, plo + noe, in, ilo, si - 1);
		// rt cons
		nn.right = construct(pre, plo + noe + 1, phi, in, si + 1, ihi);

		return nn;

	}
	
	public void printInRange(int sidx,int eidx) {
		printInRange(sidx, eidx,this.root);
	}

	private void printInRange(int sidx, int eidx, Node node) {
		
		
		if(node == null) {
			return;
		}
		if(sidx < node.data) {
			if(node.data <eidx) {
				System.out.println(node.data);
			}
			printInRange(sidx, eidx,node.left);
		}else if(sidx >node.data) {
			printInRange(sidx, eidx, node.right);
		}else {
			System.out.println(node.data);
			return;
		}
		
	}
	
	

	private Node takeInput(Node node,boolean ilc) {
		
		if(node == null) {
			System.out.println("enter value of root node");
		}else {
			
			if(ilc) {
				System.out.println("enter the value of left child of" + node.data);

			}else {
				System.out.println("enter the value of right child of" + node.data);

			}
		}
		
		Node nn = new Node();
		
		nn.data = scn.nextInt();
		
		
		
		System.out.println("do u hve left child of" + nn.data + "node");
		boolean ansl = scn.nextBoolean();
		if(ansl) {
			
			 nn.left =takeInput(nn,true);
		}
		
		System.out.println("do u hve right child of " + nn.data + "node");
		boolean ansr = scn.nextBoolean();

		
		if(ansr) {
			

			nn.right=takeInput(nn,false);
			
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
	
	public boolean find(int item) {
		return find(this.root,item);
	}

	private boolean  find(Node node,int item) {
		// TODO Auto-generated method stub
		if(node == null) {
			return false;
		}
		boolean lf,rf;
		if(node.data == item) {
			return true;
		}
		
		lf =find(node.left,item);
		rf =find(node.right,item);
		
		return lf || rf;
	}
	
	public int  max() {
		
		return max(this.root);
	}

	private int max(Node node) {
		// TODO Auto-generated method stub
		int sans,lans,rans;
		
		if(node == null) {
			return 0;
		}
		sans = node.data;
		lans = max(node.left);
		rans = max(node.right);
		
		return Math.max(sans, Math.max(lans,rans));
	}
	
	
	
	public int  ht() {
		return ht(this.root) -1;
	}

	private int ht(Node node) {
		// TODO Auto-generated method stub
		
		
		if(node == null) {
			return 0;
		}
		
		int max=Integer.MIN_VALUE;
		int lht,rht;
		
		lht = ht(node.left);
		if(lht >max) {
			max = lht;
		}
		
		rht = ht(node.right);
		if(rht >max) {
			max = rht;
		}
		
		return max +1;
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

	
/*	public boolean Balanced() {
		
	return 	Balanced(this.root);
	}

	private boolean Balanced(Node node) {
		
		int lnh,rnh;
		if(node == null) {
			return true;
		}
		
		lnh = this.ht(node.left);
		rnh = this.ht(node.right);
		
		int ans = lnh-rnh;
		if(ans >-1 && ans <1 && Balanced(node.left) && Balanced(node.right)) {
			return true;
		}
		
		return false;
	}*/
	
	private class Bpair{
		int ht;
		boolean isBalanced;
	}
	
	public void Balanced() {
		Bpair bal = new Bpair();
		Balanced(this.root);
	}

	private Bpair Balanced(Node node) {
		
		if(node == null) {
			Bpair bp = new Bpair();
			bp.ht=-1;
			bp.isBalanced=true;
			return bp;
		}
		
		
		Bpair lp=Balanced(node.left);
		Bpair rp = Balanced(node.right);
		
		Bpair sp = new Bpair();
		
		sp.ht=Math.max(lp.ht, rp.ht) +1 ;
		
		int ans = lp.ht-rp.ht;
		if(ans >-1 && ans <1  && lp.isBalanced && rp.isBalanced) {
			sp.isBalanced=true;
		}else {
			sp.isBalanced=false;
		}
		
		return sp;
		
		
	}
	
/*	public int  diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		int ldia = diameter(node.left);
		int rdia = diameter(node.right);
		
		int spdia =this.ht(node.left) + this.ht(node.right) +2;
		
		int ans  = Math.max(spdia, Math.max(ldia, rdia));
		
		return ans;
		
	}
	*/
	
	private class Dpair{
		int height;
		int dia;
	}
	
	public int  diameter() {
		
		Dpair d = diameter(this.root);
		return d.dia;
		
		
	}

	private Dpair diameter(Node node) {
		
		
		if(node == null) {
			Dpair bp = new Dpair();
			bp.height=0;
			bp.dia = 0;
			return bp;
		}
		
		Dpair lp = diameter(node.left);
		Dpair rp = diameter(node.right);
		
		Dpair sp = new Dpair();
		sp.height=Math.max(lp.height, rp.height)+1;
		
		int lpdia = lp.dia;
		int rpdia = rp.dia;
		
		int spdia = lp.height + rp.height +2;
		
		
		sp.dia = Math.max(spdia, Math.max(lpdia, rpdia));
		
		return sp;
		
		
	}

	
	
	
	

}
