package crux12june2018;

public class StackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Stack s = new Stack();
		// s.push(10);
		// s.push(20);
		// s.push(30);
		// s.push(40);
		// s.display();
		// //Stack helper = new Stack();
		// displayReverse(s);
		// s.display();

//		int[] prices = { 10, 5, 13, 17, 12, 9, 15, 6, 11 };
//		// ans : 113411312
//		int[] span = stockSpan(prices);
//		for (int val : span) {
//			System.out.println(val + " ");
//		}
		
//		int a[] = {100,5,2,20,7,3,9};
//		nextGreater(a);
		
		Stack s= new DynamicStack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		
		s.display();
		

	}

	public static void displayReverse(Stack s) throws Exception {

		if (s.isEmpty()) {

			return;
		}

		int c = s.pop();
		displayReverse(s);
		System.out.print(c + ", ");
		s.push(c);

	}

	public static void actualReverse(Stack s, Stack helper) throws Exception {

		if (s.isEmpty()) {

			if (helper.isEmpty()) {
				return;
			}

			int temph = helper.pop();
			actualReverse(s, helper);
			s.push(temph);

			return;
		}

		int c = s.pop();
		helper.push(c);
		actualReverse(s, helper);

	}

	public static void nextGreater(int[] a) throws Exception {
int temp1,temp2;
		Stack s = new Stack();
		s.push(a[0]);

		for (int i = 1; i < a.length; i++) {
			while (!(s.isEmpty()) && (a[i] > s.peek())) {
				temp1 = s.pop();
				System.out.println(temp1 + "->" + a[i]);
				
			}

			s.push(a[i]);
		}
		
		while(!s.isEmpty()) {
			System.out.println(s.pop() + "->" + -1);
		}
	}

	public static int[] stockSpan(int[] prices) throws Exception {

		int span[] = new int[prices.length];
		Stack s = new Stack();

		for (int i = 0; i < prices.length; i++) {

			while (!(s.isEmpty()) && (prices[s.peek()] < prices[i])) {
				s.pop();
			}

			if (s.isEmpty()) {
				span[i] = i + 1;
			}

			else {
				span[i] = i - s.peek();
			}
			s.push(i);

		}

		return span;
	}

}
