package crux12june2018;

import java.util.Scanner;

public class Assignments_q12 {

	
	//ARRAYS-TARGET SUM TRIPLETS

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N,i,target,j,k,sum;
		N=9;
		int a[] = new int[N];
		

		Scanner sc = new Scanner(System.in);
	
		for(i=0;i<N;i++) {
			System.out.println("enter");
			
			a[i]=sc.nextInt();
			
			
		}
		
		target = sc.nextInt();
		
		outer:for(i=0;i<N;i++) {
			
			inner:for(j=0;j<N;j++) {
				
				if(j == i)
					continue outer;
				
				for(k=0;k<N;k++) {
					
					if(k == i)
						continue outer;
					if(k == j)
						continue inner;
					
					sum = a[i] + a[j] + a[k];
					if(sum == target)
						System.out.println(a[i] + "and " + a[j] + "and" + a[k]);
					
				}
				
				
			}
		}
		
	}

}
