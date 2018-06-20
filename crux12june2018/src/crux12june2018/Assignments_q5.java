package crux12june2018;

public class Assignments_q5 {

	public static void main(String[] args) {
		
		int n,r=0,c;
		n=123456789;
		
		while(n!=0) {
			c=n%10;
			
			r= r*10 + c;
			n=n/10;
			
		}
		
		System.out.println(r);
		
		
	}
	
}
