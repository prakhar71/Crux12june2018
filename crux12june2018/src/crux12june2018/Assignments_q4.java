package crux12june2018;

public class Assignments_q4 {
	
	public static void main(String[] args) {
		
		int n,i,y;
		n=13;
		for(i=0;i<=n;i++) {
			y=prime(i);
			if(y==1)
				System.out.print(i);
			
		}
	}
	
	public static int prime(int n) {
		
		int x=0;
		
		for(int i=1;i<=n;i++) {
			if(n%i == 0)
				x++;
		}
		
		if(x == 2)
			return 1;
		else
			return 0;
		
	}

}
