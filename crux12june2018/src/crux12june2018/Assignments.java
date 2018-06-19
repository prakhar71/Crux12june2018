package crux12june2018;

public class Assignments {
	
	private static  int a=0,b=1,x=1;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j;
		
		for(i=1;i<=4;i++) {
			for(j=1;j<=i;j++) {
				System.out.print(fab(x)+"  ");
				x++;
				
			}
			System.out.println();
		}
		

	}
	
	public  static int fab(int x) {
		
		int c;
		
		if(x>2) {
			c=a+b;
			
			
			a=b;
			b=c;
			return c;
			
			
			
			
		}
		else if(x==1)
			return 0;
		else
			return 1;
		
	}

}
