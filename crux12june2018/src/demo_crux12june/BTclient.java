package demo_crux12june;

public class BTclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str = "10 true 5 true 3 false false true 7 false false true 20 true 15 false false true 25 false false false";
		BinaryTree bt = new BinaryTree(str);
		//System.out.println(bt.ht());
		
		//bt.display();
		//System.out.println(bt.Balanced());
		bt.printInRange(3, 15);
	}

}
