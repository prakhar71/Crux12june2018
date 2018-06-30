package crux12june2018;

public class GenericTreeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		// 10 3 20 2 50 0 60 0 30 0 40 1 70 0 
		String str = "10 3 20 2 50 0 60 0 30 0 40 1 70 0 ";
		GenericTree tree = new GenericTree(str);
		tree.levelTraversal();
	}

}
