package crux12june2018;



public class BSTclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] in = { 10, 20, 30, 40, 50, 60, 70 };

		BinarySearchTree bst = new BinarySearchTree(in);
		//bst.display();
		bst.replaceWithSum();
		bst.display();

	}

}
