package crux12june2018;

public class Assignments_q1 {
	
	public static void main(String[] args) {
		
		int n,se=0,so=0,c,x=0;
		
		n=5739;
		
		while(n!=0) {
			
			c=n%10;
			if(x%2==0)
				so=so+c;
			else
				se=se+c;
			
			n=n/10;
			x++;
		}
		System.out.println(so);
		System.out.println(se);
		
	}
	
	public static void isPrime(int n) {
		
		int c=0;
		for(int i =1;i<=n;i++) {
			if(n%i == 0) {
				c++;
			}
		}
		if(c == 2) {
			System.out.println("Prime");
			
		}
		else {
			System.out.println("not Prime");
		}
	}

}
