
package crux12june2018;

public class Assignments_q14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int x0=0,x1=0,done =0,i,j;
		int a[] = {1,0,0,0,1,0,0,0,1};
		for( i = 0;i< a.length;i++) {
			
			if(a[i] == 0)x0++;
			else x1++;
			
		}
		
		if(x0 == 0 || x1 == 0)
			System.out.println("none");
		
		else {
			int s=2*(smallerOf(x0, x1));
			
			for( i= 0;i<= a.length - s;i++) {
				int x=0,y=0;
				for( j=i;j<=i+s-1;j++) {
					if(a[j] == 0)x++;
					else y++;
				}
				
				if((x == y)  && (x == s/2)) {
					done = 1;
					break;
				}
					
			}
			
			if(done == 1) {
				System.out.println(i+" ," +(i+s-1));
			}
			else {
				System.out.println("none");
			}
			
		}
		
		
		
	}
	
	public static int smallerOf(int n1,int n2) {
		if(n1<n2)
			return n1;
		else
			return n2;
	}

}
