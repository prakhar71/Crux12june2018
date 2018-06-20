package crux12june2018;

import java.util.Scanner;

public class Assignments_q9 {
	
	//ARRAYS-MAX VALUE IN ARRAY


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N,i;
		N=5;
		int a[] = new int[N];

		Scanner sc = new Scanner(System.in);
	
		for(i=0;i<N;i++) {
			System.out.println("enter");
			
			a[i]=sc.nextInt();
			
			
		}
		int max = 0;
		for(i=0;i<N;i++) {
			if(a[i]>max)
				max=a[i];
		}
		
		System.out.println(max);
		
		sc.close();

	}
	
	

}
