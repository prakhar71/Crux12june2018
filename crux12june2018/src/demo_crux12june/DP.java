package demo_crux12june;

public class DP {

	public static void main(String[] args) {
		// System.out.println(fib(150));
		// System.out.println(fibTD(150, new int[151]));
		// System.out.println(fibBU(6));
		//System.out.println(fibBUSE(6));
		//System.out.println(boardPathBU(10));
		System.out.println(boardPathBUSE(10));
	}

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		int fn = fib(n - 1) + fib(n - 2);
		return fn;
	}

	public static int fibTD(int n, int[] a) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		if (a[n] != 0) {
			return a[n];
		}

		int fn = fibTD(n - 1, a) + fibTD(n - 2, a);

		a[n] = fn;

		return fn;
	}

	public static int fibBU(int n) {
		int a[] = new int[n + 1];
		a[0] = 0;
		a[1] = 1;

		for (int i = 2; i < a.length; i++) {
			a[i] = a[i - 1] + a[i - 2];

		}
		return a[n];
	}

	public static int fibBUSE(int n) {
		int a[] = new int[2];

		a[0] = 0;
		a[1] = 1;

		// doubt why shd it be i< n
		for (int i = 1; i < n; i++) {
			int temp = a[0];
			a[0] = a[1];
			a[1] = temp + a[0];
		}

		return a[1];
	}

	public static int boardPath(int curr, int end) {

		int count = 0;
		if(curr > end) {
			return 0;
		}
		
		if(curr == end) {
			return 1;
		}
		
		for (int dice = 1; dice <= 6; dice++) {
			count += boardPath(curr + dice, end);

		}
		
		return count;
	}
	
	public static int boardPathBU(int n) {

		int a[] = new int[n+6];
		
		a[n]=1;
		
		for(int dice = n-1;dice >=0;dice--) {
			int sum = 0;
			for(int i=dice+1;i<=dice+6;i++) {
				sum += a[i];
			}
			a[dice]=sum;
		}
		
		
		return a[0];
	}
	
	public static int boardPathBUSE(int n) {
		
		int a[] = new int[6];
		a[0]=1;
		 
		for(int i=1;i<= n;i++) {
			int temp = a[5];
			a[5]=a[4];
			a[4]=a[3];
			a[3]=a[2];
			a[2]=a[1];
			a[1]=a[0];
			a[0]=temp+a[1]+a[2]+a[3]+a[4]+a[5];
			
		}
		
		return a[0];
	}
	
	
	
	
	
	
	
	
	
	
	

}
