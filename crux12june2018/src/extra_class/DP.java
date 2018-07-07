package extra_class;

import java.util.Arrays;

public class DP {

	public static void main(String[] args) {
		// System.out.println(fib(150));
		// System.out.println(fibTD(150, new int[151]));
		// System.out.println(fibBU(6));
		// System.out.println(fibBUSE(6));
		// System.out.println(boardPathBU(10));
		// System.out.println(boardPathBUSE(10));
		// System.out.println(mazePathBUSE_diag(3, 3));
//		int[] price = {1,4,5,7};
//		int[] wt = {1,3,4,5};
//		int cap = 7;
//		System.out.println(knapsackTD(wt, price,0,cap,new int[price.length][cap+1]));
//		System.out.println(KnapSackBU(wt, price, cap));

//		int prices[] = { 0, 3, 5, 8, 9, 10, 17, 17, 20 };
//		System.out.println(rodcut(prices, 8));
		
		System.out.println(palindromePartition("abcbd", 0, 4));
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

	public static int mazePathTU(int cr, int cc, int er, int ec, int a[][]) {

		int counth = 0, countv = 0;

		if (cr == er && cc == ec) {

			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (a[cr][cc] != 0) {
			return a[cr][cc];
		}

		counth = mazePathTU(cr, cc + 1, er, ec, a);
		countv = mazePathTU(cr + 1, cc, er, ec, a);

		a[cr][cc] = counth + countv;
		return counth + countv;

	}

	public static int mazePathBU(int cr, int cc, int er, int ec) {
		int a[][] = new int[er + 1][ec + 1];

		Arrays.fill(a, 1);

		for (int row = er - 1; row >= cr; row--) {
			for (int col = ec - 1; col >= cc; col--) {

				a[row][col] = a[row][col + 1] + a[row + 1][col];

			}
		}

		return a[cr][cc];

	}

	public static int mazePathBUSE(int er, int ec) {
		int a[] = new int[ec + 1];

		Arrays.fill(a, 1);
		for (int row = er - 1; row >= 0; row--) {

			for (int col = ec - 1; col >= 0; col--) {
				int temp = a[col];
				a[col] = temp + a[col + 1];
			}
		}
		return a[0];
	}

	public static int mazePathBUSE_diag(int er, int ec) {

		int[] a = new int[ec + 1];
		Arrays.fill(a, 1);
		int diag = 0;
		for (int row = er - 1; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					diag = 1;

				} else {
					int sum = a[col + 1] + a[col] + diag;
					diag = a[col];
					a[col] = sum;
				}
			}
		}

		return a[0];
	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {

			int opt1 = LCS(ros1, s2);
			int opt2 = LCS(s1, ros2);

			ans = Math.max(opt1, opt2);
		}

		return ans;

	}

	public static int LCS_TD(String s1, String s2, int a[][]) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (a[s1.length()][s2.length()] != 0) {
			return a[s1.length()][s2.length()];
		}

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {

			int opt1 = LCS(ros1, s2);
			int opt2 = LCS(s1, ros2);

			ans = Math.max(opt1, opt2);
		}

		a[s1.length()][s2.length()] = ans;

		return ans;

	}

	public static int LCS_BU(String s1, String s2) {
		int a[][] = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {
				char ch1 = s1.charAt(row);
				char ch2 = s2.charAt(col);

				if (ch1 == ch2) {
					a[row][col] = a[row + 1][col + 1] + 1;
				} else {
					a[row][col] = Math.max(a[row][col + 1], a[row + 1][col]);
				}
			}
		}

		return a[0][0];
	}

	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int res;
		if (ch1 == ch2) {
			res = EditDistance(ros1, ros2);

		} else {

			int i = EditDistance(ros1, s2);
			int d = EditDistance(s1, ros2);
			int r = EditDistance(ros1, ros2);

			res = Math.min(i, Math.min(r, d));

		}

		return res;
	}

	public static int EditDistance_BU(String s1, String s2) {

		int a[][] = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {
				if (row == s1.length()) {
					a[row][col] = s1.length() - col;
				} else if (col == s2.length()) {
					a[row][col] = s2.length() - row;
				} else {

					if (s1.charAt(row) == s2.charAt(col)) {
						a[row][col] = a[row + 1][col + 1];
					} else {
						int res = Math.min(a[row][col + 1], Math.min(a[col][row + 1], a[row + 1][col + 1]));
						a[row][col] = res;
					}

				}
			}
		}

		return a[0][0];

	}

	public static int MCM(int a[], int si, int ei) {

		if ((si + 1) == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCM(a, si, k);
			int sp = MCM(a, k, ei);

			int sw = a[si] * a[k] * a[ei];

			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}

		}

		return min;

	}

	public static int MCMTD(int a[], int si, int ei, int[][] strg) {

		if ((si + 1) == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMTD(a, si, k, strg);
			int sp = MCMTD(a, k, ei, strg);

			int sw = a[si] * a[k] * a[ei];

			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}

		}

		strg[si][ei] = min;
		return min;

	}

	public static int MCMBU(int a[]) {

		int n = a.length;
		int strg[][] = new int[n + 1][n + 1];

		for (int slide = 1; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

				if (si + 1 == ei) {
					strg[si][ei] = 0;
				} else {

					int min = Integer.MAX_VALUE;
					for (int k = si + 1; k <= ei - 1; k++) {

						int fp = strg[si][k];
						int sp = strg[k][ei];

						int sw = a[si] * a[k] * a[ei];

						int sum = fp + sp + sw;

						if (sum < min) {
							min = sum;
						}
					}

					strg[si][ei] = min;
				}
			}
		}

		return strg[0][n - 1];

	}

	public static int WineProblem(int[] prices, int si, int ei, int yr) {

		if (si == ei) {
			return prices[si] * yr;
		}

		int fw = WineProblem(prices, si + 1, ei, yr + 1) + prices[si] * yr;

		int sw = WineProblem(prices, si, ei - 1, yr + 1) + prices[ei] * yr;

		return Math.max(fw, sw);

	}

	public static int WineProblemTD(int[] prices, int si, int ei, int[][] strg) {

		int yr = prices.length - (ei - si);

		if (si == ei) {
			return prices[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int fw = WineProblemTD(prices, si + 1, ei, strg) + prices[si] * yr;

		int sw = WineProblemTD(prices, si, ei - 1, strg) + prices[ei] * yr;

		int res = Math.max(fw, sw);
		return res;

	}

	public static int WineProblem_BU(int[] prices) {

		int n = prices.length;
		int strg[][] = new int[n + 1][n + 1];

		for (int slide = 1; slide <= n; slide++) {
			for (int si = 0; si <= n - slide; si++) {
				int ei = si + slide - 1;

				int yr = prices.length - (ei - si);

				if (si == ei) {
					strg[si][ei] = prices[si] * yr;
				} else {

					int fw = strg[si + 1][ei] + prices[si] * yr;

					int sw = strg[si][ei - 1] + prices[ei] * yr;

					int res = Math.max(fw, sw);

					strg[si][ei] = res;
				}
			}
		}

		return strg[0][n - 1];

	}

	// inclu

	public static int KnapSackBU(int[] wt, int[] price, int cap) {

		int nr = wt.length + 1;
		int nc = cap + 1;

		int strg[][] = new int[nr][nc];

		for (int row = 0; row < nr; row++) {
			for (int col = 0; col < nc; col++) {
				int include = 0, exclude;
				if (row == 0 || col == 0) {
					strg[row][col] = 0;
				} else {

					if (col >= wt[row - 1]) {
						include = price[row - 1] + strg[row - 1][col - wt[row - 1]];
					}
					exclude = strg[row - 1][col];

					strg[row][col] = Math.max(include, exclude);
				}
			}
		}

		return strg[nr - 1][nc - 1];
	}

	public static int knapsack(int[] wt, int[] price, int vidx, int cap) {

		if (vidx == price.length) {
			return 0;
		}
		int include = 0;

		if (cap >= wt[vidx]) {
			include = knapsack(wt, price, vidx + 1, cap - wt[vidx]) + price[vidx];
		}

		int exclude = knapsack(wt, price, vidx + 1, cap);

		return Math.max(include, exclude);

	}

	public static int knapsackTD(int[] wt, int[] price, int vidx, int cap, int strg[][]) {

		int include = 0;
		if (vidx == price.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		if (cap >= wt[vidx]) {
			include = knapsack(wt, price, vidx + 1, cap - wt[vidx]) + price[vidx];
		}

		int exclude = knapsack(wt, price, vidx + 1, cap);

		int res = Math.max(include, exclude);
		strg[vidx][cap] = res;

		return res;

	}

	public static int rodcut(int[] prices, int n) {

		if (n == 0)
			return 0;
		int l = 1;
		int r = n - 1;
		int sum;
		int max = prices[n];

		while (l <= r) {
			int lh = rodcut(prices, l);
			int rh = rodcut(prices, r);

			sum = lh + rh;

			if (sum > max) {
				max = sum;
			}

			l++;
			r--;
		}

		return max;

	}

	public static int rodcutTD(int[] prices, int n, int strg[]) {

		int l = 1;
		int r = n - 1;
		int sum;
		int max = prices[n];

		if (strg[n] != 0) {
			return strg[n];
		}

		while (l <= r) {
			int lh = rodcutTD(prices, l, strg);
			int rh = rodcutTD(prices, r, strg);

			sum = lh + rh;

			if (sum > max) {
				max = sum;
			}

			l++;
			r--;

			strg[n] = max;
		}

		return max;

	}

	public static int name(int[] prices, int n) {

		int strg[] = new int[prices.length];

		for (int i = 1; i < prices.length; i++) {

			int l = 1;
			int r = i - 1;

			int sum;
			int max = prices[i];

			while (l <= r) {
				int lh = strg[l];
				int rh = strg[r];

				sum = lh + rh;

				if (sum > max) {
					max = sum;
				}

				l++;
				r--;

				strg[i] = max;
			}

		}

		return strg[n];

	}

	public static int mixtures(int[] col, int si, int ei, int[][] strg) {

		if ((si) == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int smoke1 = mixtures(col, si, k, strg);
			int smoke2 = mixtures(col, k + 1, ei, strg);

			int fp = color(col, si, k);
			int sp = color(col, k + 1, ei);

			int sum = smoke1 + smoke2 + fp * sp;

			if (sum < min) {
				min = sum;
			}

		}

		strg[si][ei] = min;
		return min;

	}

	public static int color(int[] col, int si, int ei) {
		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += col[i];
		}

		return sum % 100;
	}

	public static int mixtures_BU(int[] col) {

		int n = col.length;

		int[][] strg = new int[n + 1][n + 1];

		for (int slide = 1; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int min = Integer.MAX_VALUE;

				for (int k = si; k <= ei - 1; k++) {

					int smoke1 = strg[si][k];
					int smoke2 = strg[k + 1][ei];

					int fp = color(col, si, k);
					int sp = color(col, k + 1, ei);

					int sum = smoke1 + smoke2 + fp * sp;

					if (sum < min) {
						min = sum;
					}

				}
				
				strg[si][ei]=min;

			}

		}
		return strg[0][n-1];
	}
	
	public static boolean isPalindrome(String str,int si,int ei) {
		
		int l =si;
		int r= ei;
		while(l<=r) {
			if(str.charAt(l) != str.charAt(r)) {
				return false;
			}
			
			l++;
			r--;
		}
		
		return true;
	}
	
	public static int palindromePartition(String str,int si,int ei ) {
		
		if(isPalindrome(str, si, ei)) {
			return 0;
		}
		
		
		
		int min = Integer.MAX_VALUE;
		
		for(int k=si;k<=ei-1;k++) {
			int fh = palindromePartition(str, si, k);
			int sh = palindromePartition(str, k+1, ei);
			
			int ans = fh+sh+1;
			
			if(ans < min) {
				min=ans;
			}
			
			
		}
		
		return min;
	}
	
	
public static int palindromePartitionTD(String str,int si,int ei,int[][] strg) {
		
		if(isPalindrome(str, si, ei)) {
			return 0;
		}
		
		if(strg[si][ei] != 0) {
			return strg[si][ei];
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int k=si;k<=ei-1;k++) {
			int fh = palindromePartitionTD(str, si, k,strg);
			int sh = palindromePartitionTD(str, k+1, ei,strg);
			
			int ans = fh+sh+1;
			
			if(ans < min) {
				min=ans;
			}
			
			
		}
		strg[si][ei] = min;
		return min;
	}
}
