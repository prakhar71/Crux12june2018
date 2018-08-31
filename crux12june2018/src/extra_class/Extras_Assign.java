package extra_class;

public class Extras_Assign {

	public static void main(String[] args) {
//		int n=10;
//		int[] a = uglyNos(n);
//		for(int ans : a) {
//			System.out.print(ans + " ,");
//		}
//		
//		int a[] = { -5, 6, 7, 1, 4, -8, 16 };
//		System.out.println(kadanesAlgo(a));

//		int[][] a = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
//		System.out.println(kadanesAlgo2D(a));
		int ans=0;
		double arr[] = { 7.48, 6.67, 5.39, 7.04};
		for(int i=0;i<arr.length;i++) {
			ans += (arr[i]-0.75)*10;
		}
		  System.out.println(ans/4);
	    // Calculate size of array.
//	    int n = arr.length;
//	        int k = 3;
//	 System.out.println(painterProb(k, arr, n));
	}

	public static int[] uglyNos(int n) {

		// ugly number is a no. which can b resolved only as prime factors of 2,3,5
		int i2 = 0, i3 = 0, i5 = 0;

		int num2 = 2, num3 = 3, num5 = 5;

		int[] a = new int[n];
		a[0] = 1;

		for (int i = 1; i < a.length; i++) {

			int min = Math.min(num2, Math.min(num3, num5));
			a[i] = min;

			if (min == num2) {

				i2++;
				num2 = a[i2] * 2;
			}

			if (min == num3) {
				i3++;
				num3 = a[i3] * 3;
			}

			if (min == num5) {
				i5++;
				num5 = a[i5] * 5;

			}
		}
		return a;

	}

	public static int kadanesAlgo(int a[]) {

		// max contigious sum in arr
		int[] b = new int[a.length];

		b[0] = a[0];

		for (int i = 1; i < a.length; i++) {

			int sum = a[i] + b[i - 1];
			int max = Math.max(a[i], sum);
			b[i] = max;

		}
		int l = b[0];
		for (int i = 0; i < b.length; i++) {
			if (b[i] > l) {
				l = b[i];
			}
		}

		return l;

	}

	public static int kadanesAlgo2D(int[][] a) {

		int temp[] = new int[a.length];
		int max = Integer.MIN_VALUE;

		for (int left = 0; left < a[0].length; left++) {
			int b[] = new int[a[0].length];
			for (int rt = left; rt < a[0].length; rt++) {

				for (int row = 0; row < a.length; row++) {
					b[row] = b[row] + a[row][rt];
				}

				int ans = kadanesAlgo(b);
				if (ans > max) {
					max = ans;
				}
			}
		}

		return max;
	}

	public boolean wildCardPattern(String src, String pattn) {

		if (src.length() == 0) {
			return false;
		}

		char ch;

		for (int i = 0; i < pattn.length(); i++) {

			ch = pattn.charAt(i);
			if (ch == '*') {

				String ros = pattn.substring(0, i);
				String pstr = pattn.substring(i, i + 2);

				// case1
				pstr = pstr.substring(1);
				// case2
				ros = ros.substring(1);

				return wildCardPattern(ros, pstr);

			} else if (ch == '?') {
				continue;

			} else {
				if (src.charAt(i) != ch)
					return false;
			}
		}

		return false;

	}

	public static int painterProb(int k, int[] a, int n) {

		
		if(k == 1) {
			return findsum(a, 0, n-1);
		}
		
		
		if(n == 1) {
			return a[0];
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i<=n; i++) {
			 int temp = Math.max(painterProb(k-1, a, i),findsum(a, i, n - 1));
                    if(temp < ans) {
                    	ans = temp;
                    }
		}
		
		return ans;

	}
	
	private static int findsum(int[] a,int str,int end) {
		int sum = 0;
		for(int i=str;i<=end;i++) {
			sum += a[i];
		}
		
		return sum;
	}
	
	
	
	
	
	
	
	

}
