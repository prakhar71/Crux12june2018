package crux12june2018;

public class LLClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		LinkedList LL = new LinkedList();
		LL.addLast(10);
		LL.addLast(80);
		LL.addLast(40);
		LL.addLast(30);
		LL.addLast(90);
		//LL.addLast(60);
		LL.addLast(20);
		LL.addLast(105);
		
		
	LL.display();
	
//		LL.reversePointers();
		
//		LL.display();
//		
//		LinkedList l1 = new LinkedList();
//		l1.addLast(15);
//		l1.addLast(25);
//		l1.addLast(28);
//		l1.addLast(35);
//		l1.addLast(45);
//		l1.addLast(70);
//		l1.addLast(85);
//		l1.addLast(90);
		
		//l1.display();
		//LL.fold();
		
		//LL.display();
		
//		LL.display();
//		LL.addFirst(100);
//		LL.addFirst(101);
//		LL.display();
//		
//		LL.addAt(3, 45);
//		LL.display();
		
		//LL.kReverse(3);
		//System.out.println(LL.kthFromLast(2));
		
		
		LinkedList list = LinkedList.mergeSort(LL);
		list.display();
		
		
	}
	
	
}
