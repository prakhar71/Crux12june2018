
package crux12june2018;

public class Assignments_q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,n=10;
		for(i=1;i<=n;i++) {
			for(j=1;j<=i;j++) {
				if(j==1  || j==i)
					System.out.print(i+"\t");
				else
					System.out.print(0+"\t");
			}
			System.out.println();
		}
	
	}

}
