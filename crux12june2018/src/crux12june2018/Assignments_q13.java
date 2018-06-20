package crux12june2018;

import java.util.Scanner;

public class Assignments_q13 {

	// SORTING IN LINEAR TIME

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N, i,n0 = 0,n1 = 0,n2 = 0;
		N=5;
		int a[] = new int[N];
		int b[] = new int [N];

		Scanner sc = new Scanner(System.in);

		for (i = 0; i < N; i++) {
		//	System.out.println("enter");

			a[i] = sc.nextInt();
			
			if(a[i]== 0)
				n0++;
			else if(a[i] == 1)
				n1++;
			else
				n2++;

		}
		
		int x,y,z;
		x=0;
		y=n0;
		z=n1+n0;
		
		for(i = 0;i<N;i++) {
			if(a[i] == 0) {
				b[x]=a[i];
				x++;
			}
			else if(a[i]==1) {
				b[y]=a[i];
				y++;
			}
			else if(a[i] == 2) {
				b[z] = a[i];
				z++;
			}
		}
		
		for (i = 0; i < N; i++) {
			System.out.println(b[i]);
		}

		
		sc.close();
	}

}
