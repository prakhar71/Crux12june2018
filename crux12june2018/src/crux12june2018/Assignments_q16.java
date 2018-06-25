package crux12june2018;

public class Assignments_q16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N=7;
		int a[] = {1,2,3,1,2,4,1};
		int b[] = {2,1,3,1,5,2,2};

		 a = bubbleSort(a);
		 b= bubbleSort(b);
		 
		 for (int i = 0; i < b.length; i++) {
			
			 if(a[i] == b[i]) {
				 System.out.print(a[i] + ",");
			 }
		}
		System.out.print("  "+ "END");
	}
	
	public static int[] bubbleSort(int a[]) {
		
		int i,j,temp,n;
		n = a.length;
		for(i=0;i<n-1;i++) {
			for(j=0;j<n-i-1;j++) {
				
				if(a[j]>a[j+1]) {
					//swap
					
					temp = a[j];
					a[j]= a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		return a;
	}

}
