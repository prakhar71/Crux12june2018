package DynamicPrograming;

import java.util.Arrays;

public class DP {

	public static void main(String[] args) {

//		System.out.println(boardPathBPSE(5));
		// System.out.println(mazePathBU(1, 1, 3, 3));
		// System.out.println(mazePathBU_diag(3, 3));

//		System.out.println(EditDistance("abcd", "agcfd"));
//		System.out.println(EditDistanceTD("abcdjaslcfmasmfl", "agcfdsdnaidasdiq", new int[50][60]));
		int a[] = { 2, 3, 5, 1, 4 };
		// System.out.println(MCM_BU(a));
		//System.out.println(WineProblemTD(a,0,4,new int[6][6]));
		System.out.println(boardPathBU(10));
	}

	public static int fib(int n) {
		if(n==0) {
			return 0;
		}
		else if(n ==1) {
			return 1;
		}
		
		int fn  = fib(n-1) + fib(n-2);
		return fn;
	}
	
	
	public static int fibTD(int n,int []a) {
		
		if(n==0) {
			return 0;
		}
		else if(n ==1) {
			return 1;
		}
		
		if(a[n] !=0) {
			return a[n];
		}
		
		int fn  = fibTD(n-1,a) + fibTD(n-2,a);
		
		a[n] = fn;
		
		
		return fn;
	}
	
	public static int fibBU(int n) {
		int a[] = new int [n+1];
		a[0]=0;
		a[1] =1;
		
		for(int i=2;i<a.length;i++) {
			a[i] = a[i-1] + a[i-2];
			
		}
			return a[n];
	}
	
	public static int fibBUSE(int n) {
		int a[] = new int [2];
		
		a[0]=0;
		a[1]=1;
		
		//doubt why shd it be i< n
		for(int i=1;i<n;i++) {
			int temp=a[0];
			a[0] = a[1];
			a[1]=temp+a[0];
		}
		
		return a[1];
	}
	

	public static int boardPathTD(int curr, int end, int[] strg) {

		int count = 0;
		if (curr == end) {

			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		for (int dice = 1; dice <= 6; dice++) {
			count = count + boardPathTD(curr + dice, end, strg);
		}

		strg[curr] = count;

		return count;

	}

	public static int boardPathBU(int n) {

		int strg[] = new int[n + 6];

		strg[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];
	}

	public static int boardPathBPSE(int n) {
		int a[] = new int[6];
		a[0] = 1;

		for (int i = n; i >= 1; i--) {
			int sum = a[0] + a[1] + a[2] + a[3] + a[4] + a[5];

			a[5] = a[4];
			a[4] = a[3];
			a[3] = a[2];
			a[2] = a[1];
			a[1] = a[0];

			a[0] = sum;
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

		int a[][] = new int[er][ec];

		for (int i = 0; i < er; i++) {
			a[i][ec - 1] = 1;

		}
		for (int i = 0; i < ec; i++) {
			a[er - 1][i] = 1;

		}
		for (int i = er - 2; i >= 0; i--) {
			for (int j = ec - 2; j >= 0; j--) {

				a[i][j] = a[i + 1][j] + a[i][j + 1];
			}
		}
		return a[0][0];
	}

	public static int mazePathBUSE(int er, int ec) {
		// taking rows from 0,0
		int a[] = new int[ec + 1];
		Arrays.fill(a, 1);

		for (int row = er - 1; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					a[col] = 1;
				} else {
					a[col] = a[col + 1] + a[col];
				}
			}
		}
		return a[0];

	}

	public static int mazePathBU_diag(int er, int ec) {

		int a[] = new int[ec + 1];
		Arrays.fill(a, 1);

		int diag = 0;
		for (int row = er - 1; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					a[col] = 1;
					diag = 1;

				} else {
					int temp = a[col] + a[col + 1] + diag;
					diag = a[col];
					a[col] = temp;

				}
			}
		}
		return a[0];
	}

	public static int LCS_BU(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int a[][] = new int[l1 + 1][l2 + 1];

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col > 0; col--) {

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
		int ans;

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {
			int insert = EditDistance(ros1, s2);
			int del = EditDistance(s1, ros2);
			int remove = EditDistance(ros1, ros2);

			ans = Math.min(insert, Math.min(del, remove)) + 1;
		}

		return ans;
	}

	public static int EditDistanceTD(String s1, String s2, int a[][]) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		if (a[s1.length()][s2.length()] != 0) {
			return a[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = EditDistanceTD(ros1, ros2, a);
		} else {
			int insert = EditDistanceTD(ros1, s2, a);
			int del = EditDistanceTD(s1, ros2, a);
			int remove = EditDistanceTD(ros1, ros2, a);

			ans = Math.min(insert, Math.min(del, remove)) + 1;

		}

		a[s1.length()][s2.length()] = ans;

		return ans;

	}

	public static int EditDitanceBU(String s1, String s2) {
		int a[][] = new int[s1.length() + 1][s2.length() + 1];

		Arrays.fill(a, 0);

		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col > 0; col--) {
				a[row][col] = a[row + 1][col + 1] + a[row + 1][col] + a[row][col + 1];

			}
		}

		return a[0][0];

	}

	public static int MCM(int[] a, int si, int ei) {

		int min = Integer.MAX_VALUE;

		if (si + 1 == ei) {
			return 0;
		}

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCM(a, si, k);
			int sp = MCM(a, k, ei);

			int sw = fp * sp * k;
			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}

		}

		return min;
	}

	public static int MCM(int[] a, int si, int ei, int strg[][]) {

		int min = Integer.MAX_VALUE;

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCM(a, si, k);
			int sp = MCM(a, k, ei);

			int sw = a[si] * a[ei] * a[k];
			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}

		}

		strg[si][ei] = min;

		return min;
	}

	public static int MCM_BU(int a[]) {

		int strg[][] = new int[a.length][a.length];
		int n = a.length;

		for (int slide = 1; slide <= n - 2; slide++) {
			for (int si = 0; si <= n - slide - 2; si++) {
				int ei = si + slide + 1;

				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fp = strg[si][k];

					int sp = strg[k][ei];

					int sw = a[si] * a[ei] * a[k];// self work
					int sum = fp + sp + sw;

					if (sum < min) {
						min = sum;
					}

				}

				strg[si][ei] = min;

			}
		}

		return strg[0][n - 1];

	}

	public static int WineProblem(int prices[], int si, int ei, int yr) {

		if (si == ei) {
			return prices[si] * yr;
		}

		int fw = WineProblem(prices, si + 1, ei, yr) + (prices[si] * yr);
		int lw = WineProblem(prices, si, ei - 1, yr) + (prices[ei] * yr);

		int res = Math.max(fw, lw);

		return res;
	}

	public static int WineProblemTD(int prices[], int si, int ei, int a[][]) {

		int yr = prices.length - (ei - si);

		if (si == ei) {
			return prices[si] * yr;
		}

		if (a[si][ei] != 0) {
			return a[si][ei];
		}
		int fw = WineProblemTD(prices, si + 1, ei, a) + (prices[si] * yr);
		int lw = WineProblemTD(prices, si, ei - 1, a) + (prices[ei] * yr);

		int res = Math.max(fw, lw);

		a[si][ei] = res;

		return res;
	}

	public static int WineProblemBU(int prices[]) {
		int a[][] = new int[prices.length][prices.length];

		int n = prices.length;

		for (int slide = 1; slide <= n; slide++) {
			for (int si = 0; si <= n - slide; si++) {
				int ei = si + slide - 1;

				int yr = prices.length - (ei - si);

				if (si == ei) {
					a[si][ei]=prices[si] * yr;
				} else {

					int fw = a[si + 1][ei] + (prices[si] * yr);
					int lw = a[si][ei - 1] + (prices[ei] * yr);

					int res = Math.max(fw, lw);
					a[si][ei] = res;
				}
			}
		}

		return a[0][n - 1];
	}
}
