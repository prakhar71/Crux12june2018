package crux12june2018;

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
	// false false
	// 10 true 20 true 30 false false true 40 true 50 false false false true 80 true
	// 60 false false true 70 false false
	// 10 true 20 true 30 false false false false
	public static void main(String[] args) {

		int []pre = {10,5,3,7,20,15,25,22,30,40};
		int []in = {3,5,7,10,15,20,22,25,30,40};
		
		BinaryTreeDemo bt = new BinaryTreeDemo(pre,in);
		//bt.biggestBST();
		//bt.printInRange(3,15);
	}
}
