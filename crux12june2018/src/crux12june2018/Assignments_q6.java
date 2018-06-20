package crux12june2018;

public class Assignments_q6 {
	
	public static void main(String[] args) {
		int i,j,n,x,c=1,k;
		
		n=4;
		
		for(i=1;i<=n ;i=i+1) {
			
			for(k=1;k<=4-i;k++) {
				System.out.print("\t");
			}
			
			x=i;
			for(j=1;j<=c;j++) {
				if(j<i) {
					System.out.print(x + "\t");
					x++;
				}
				
				else if(j==i)
					System.out.print(x + "\t");
				else {
					x--;
					System.out.print(x+"\t");
				}
				
				
			}
			System.out.println();
			c=c+2;
		}
	}

}
