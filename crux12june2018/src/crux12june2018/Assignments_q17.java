package crux12june2018;

public class Assignments_q17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int N=5;
		int a[] = {7,7,0,2,9};
		int M=5;
		int b[] = {3,4,5,6,7};
		
		int x,y,s,ones=0,unit=0;
		x=N-1;
		y=M-1;
		
		String z="";
		
		while((x>=0)  || (y>=0)) {
			
			if(x == -1) {
				s = b[y] + ones;
				
			}
			
			else if(y == -1) {
				s= a[x] + ones;
			}else {
				s=a[x] + b[y] + ones;
			}
			
			
			unit = s% 10;
			ones = s/10;
			
			z = unit + z;
			
			
			x--;
			y--;
		}
		
		if(ones != 0) {
			z = ones +z;
		}
		System.out.println(z);
			
			
	}
	


}
