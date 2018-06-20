package crux12june2018;

public class Assignments_q7 {
	
	public static void main(String[] args) {
		
		int n,c,z;
		double s=0;
		
		n=54748;
		z=n;
		while(n!=0) {
			c= n% 10;
			s = s+ Math.pow(c, digits(z));
			n = n/10;
			
		}
		if( s== z)
			System.out.println("amr");
		else
			System.out.println("not ");
		
	}
	
	public static int digits(int n) {
		int x=0;
		while(n!=0) {
			int c= n% 10;
			x++;
			n= n/10;
		}
		return x;
		
	}

}
