package demo_crux12june;

public class DP {

	public static void main(String[] args) {
		// System.out.println(fib(150));
		// System.out.println(fibTD(150, new int[151]));
		// System.out.println(fibBU(6));
		// System.out.println(fibBUSE(6));
		// System.out.println(boardPathBU(10));
		// System.out.println(boardPathBUSE(10));

//		int prices[] = { 0, 3, 5, 8, 9, 10, 17, 17, 20 };
//		System.out.println(rodProbBU(prices));

		String s = "abcacbd";
		//System.out.println(palindromePartition(s, 0, 4));
	
	System.out.println(palindromePBU(s));
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
		if (curr > end) {
			return 0;
		}

		if (curr == end) {
			return 1;
		}

		for (int dice = 1; dice <= 6; dice++) {
			count += boardPath(curr + dice, end);

		}

		return count;
	}

	public static int boardPathBU(int n) {

		int a[] = new int[n + 6];

		a[n] = 1;

		for (int dice = n - 1; dice >= 0; dice--) {
			int sum = 0;
			for (int i = dice + 1; i <= dice + 6; i++) {
				sum += a[i];
			}
			a[dice] = sum;
		}

		return a[0];
	}

	public static int boardPathBUSE(int n) {

		int a[] = new int[6];
		a[0] = 1;

		for (int i = 1; i <= n; i++) {
			int temp = a[5];
			a[5] = a[4];
			a[4] = a[3];
			a[3] = a[2];
			a[2] = a[1];
			a[1] = a[0];
			a[0] = temp + a[1] + a[2] + a[3] + a[4] + a[5];

		}

		return a[0];
	}

	public static int rodProb(int n, int[] prices) {

		int l = 1;
		int r = n - 1;

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return prices[1];
		}

		int maxP = prices[n];
		while (l <= r) {

			int fp = rodProb(l, prices);
			int sp = rodProb(r, prices);

			int tot = fp + sp;

			if (tot > maxP) {
				maxP = tot;
			}

			l++;
			r--;

		}

		return maxP;

	}

	public static int rodProbBU(int[] prices) {

		int[] n = new int[prices.length];

		n[0] = 0;
		n[1] = prices[1];

		for (int k = 1; k < prices.length; k++) {

			n[k] = prices[k];
			int l = 1;
			int r = k - 1;

			int maxP = prices[k];
			while (l <= r) {

				int fp = n[l];
				int sp = n[r];

				int tot = fp + sp;

				if (tot > maxP) {
					maxP = tot;
				}

				l++;
				r--;

			}

			n[k] = maxP;

		}

		return n[prices.length - 1];
	}

	public static boolean isPalin(String str, int si, int ei) {

		int l = si;
		int r = ei;

		while (l <= r) {

			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}

			l++;
			r--;
		}

		return true;

	}

	public static int palindromePartition(String s, int si, int ei) {

		if (isPalin(s, si, ei)) {
			return 0;
		}

		int min = s.length()-1;

		for (int k = si; k <= ei - 1; k++) {

			int fp = palindromePartition(s, si, k);

			int sp = palindromePartition(s, k + 1, ei);

			int sum = fp + sp + 1;

			if (sum < min) {
				min = sum;
			}

		}

		return min;
	}
	
	public static int  palindromePBU(String s) {
		
		
		int[][] strg = new int [s.length()][s.length()];
		int n = s.length();
		
		for(int slide = 1;slide <n;slide++) {
			for(int si = 0;si<=n-slide-1;si++) {
				int ei = si+slide;
				
				int min = Integer.MAX_VALUE;
				
				if (isPalin(s, si, ei)) {
					min = 0;
				}


				for (int k = si; k <= ei - 1; k++) {

					int fp = strg[si][k];

					int sp =strg[k+1][ei];

					int sum = fp + sp + 1;

					if (sum < min) {
						min = sum;
					}

				}

				strg[si][ei] = min;
				
				
			}
		}
		
		return strg[0][n-1];
	}

}
