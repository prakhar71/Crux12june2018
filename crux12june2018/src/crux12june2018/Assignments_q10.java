package crux12june2018;

import java.util.Scanner;

public class Assignments_q10 {

	//ARRAYS-REVERSE AN ARRAY

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N,i;
		N=5;
		int a[] = new int[N];
		int b[] = new int[N];

		Scanner sc = new Scanner(System.in);
	
		for(i=0;i<N;i++) {
			System.out.println("enter");
			
			a[i]=sc.nextInt();
			
			
		}
		for(i=N-1;i>=0;i--) {
			b[N-i-1]=a[i];
		}
		
		for(i=0;i<N;i++) {
			System.out.println(b[i]);

		}
		
		sc.close();
	}

}
