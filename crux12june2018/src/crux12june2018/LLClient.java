package crux12june2018;

public class LLClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DemoLL LL = new DemoLL();
		LL.addLast(10);
		LL.addLast(20);
		LL.addLast(30);
		LL.addLast(40);
		LL.addLast(50);
		LL.addAt(45, 2);
		
//		LL.display();
//		LL.reversePointers();
		
		LL.display();
		
		
		
		//LL.fold();
		
		//LL.display();
		
//		LL.display();
//		LL.addFirst(100);
//		LL.addFirst(101);
//		LL.display();
//		
//		LL.addAt(3, 45);
//		LL.display();
	}
}
