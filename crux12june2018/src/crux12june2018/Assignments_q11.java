package crux12june2018;

import java.util.Scanner;

public class Assignments_q11 {

	
	//ARRAYS-TARGET SUM PAIRS

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int N,i,target,j,sum;
		N=5;
		int a[] = new int[N];
		

		Scanner sc = new Scanner(System.in);
	
		for(i=0;i<N;i++) {
			System.out.println("enter");
			
			a[i]=sc.nextInt();
			
			
		}
		
		target = sc.nextInt();
		
		outer:for(i=0;i<N;i++) {
			for(j=0;j<N;j++) {
				
				if(i == j)
					continue outer;
				
					sum = a[i] + a[j];
					if(sum == target)
						System.out.println(a[i] + "and " + a[j]);
					
				
				
			}
		}
		
		
		sc.close();

	}

}
