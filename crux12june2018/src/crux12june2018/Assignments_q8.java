package crux12june2018;

public class Assignments_q8 {

	//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int c,z;
		double s;
		
		int N1=400,N2=1000;
		
		for(int i=N1;i<=N2;i++) {
			
			 s=0;
			z=i;
			while(z!=0) {
				c= z% 10;
				s = s+ Math.pow(c, digits(i));
				z = z/10;
				
			}
			if( s== i)
				System.out.println(i);
			//else
				//System.out.println("not");
			
			
		}

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
