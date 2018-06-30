package crux12june2018;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		DemoDynamicQueue q = new DemoDynamicQueue(5);
		q.enque(10);
		q.enque(20);
		q.enque(30);
		q.enque(40);
		q.enque(50);
		q.displayQueue();
//		q.deque();
//		q.displayQueue();
		q.enque(60);
		q.displayQueue();
	}

}
