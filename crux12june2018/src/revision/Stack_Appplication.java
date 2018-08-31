package revision;

import crux12june2018.Stack;


public class Stack_Appplication {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
//		
//		
		Stack s1 = new Stack();
		
//		
		s.display();
		//displayRev(s);
		
		actualRev(s,s1);
		s.display();
		
		
		
	}

	private static void actualRev(Stack s,Stack helper) throws Exception {
		// TODO Auto-generated method stub
		
		if(s.isEmpty()) {
			
			s=helper;
			return;
			
		}
		
		
		
		int temp = s.pop();
		helper.push(temp);
		actualRev(s,helper);
		
		
		
		
	}

	private static void displayRev(Stack s) throws Exception {
		// TODO Auto-generated method stub
		
		if(s.isEmpty() == true) {
			return;
		}
		
		int temp = s.pop();
		displayRev(s);
		System.out.println(temp);
		
	}
	
	
	
	
	
	

}
