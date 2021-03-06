package crux12june2018;

public class Crux17june_RecursionPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.out.println(boardPath(0,10,""));
		// System.out.println(mazePath(0,0,2,2,""));
		// permutation("abc","");
		// printSS("abc","");
		// printKPC("145", "");
		// lecxicographicCounting(0, 1000);

		//permutationDuplicates("abac", "");

	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		if (ch == '4')
			return "jk";
		if (ch == '5')
			return "lmno";
		return "";

	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;

		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans);// no
		printSS(roq, ans + ch); // yes

	}

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch1;
		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String str = getCode(ch);
		for (int i = 0; i < str.length(); i++) {

			ch1 = str.charAt(i);
			printKPC(roq, ans + ch1);

		}
	}

	public static void permutationDuplicates(String ques, String ans) {

		char ch;
		String roq;

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		boolean a[] = new boolean[256];
		for (int i = 0; i < ques.length(); i++) {
			ch = ques.charAt(i);
			roq = ques.substring(0, i) + ques.substring(i + 1);
			if (a[ch] == false) {
				permutationDuplicates(roq, ans + ch);
				a[ch] = true;
			}
		}

	}

	// public static void permutationLexicoLarger(String ques,String ans) {
	//
	// }
	//
	public static void lecxicographicCounting(int curr, int end) {

		if (curr > end) {
			return;
		}
		if (curr == end) {
			System.out.println(curr);
			return;
		}

		System.out.println(curr);
		if (curr == 0) {
			for (int i = 1; i <= 9; i++) {

				lecxicographicCounting(curr * 10 + i, end);

			}
		}

		else {

			for (int i = 0; i <= 9; i++) {

				lecxicographicCounting(curr * 10 + i, end);

			}
		}

	}

	public static int mazePath(int cr, int cc, int er, int ec, String ans) {

		int counth = 0, countv = 0;

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		counth = mazePath(cr, cc + 1, er, ec, ans + "V");
		countv = mazePath(cr + 1, cc, er, ec, ans + "H");

		return counth + countv;

	}

	public static int boardPath(int curr, int end, String ans) {

		int count = 0;
		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		for (int dice = 1; dice <= 6; dice++) {
			count = count + boardPath(curr + dice, end, ans + dice);
		}

		return count;

	}

	public static void permutation(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			permutation(ques.substring(0, i) + ques.substring(i + 1), ans + ques.charAt(i));
		}
	}

}
