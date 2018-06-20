package crux12june2018;

public class Crux17june_RecursionPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 //System.out.println(boardPath(0,10,""));
		// System.out.println(mazePath(0,0,2,2,""));
		// permutation("abc","");
		// printSS("abc","");
		//printKPC("145", "");

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

	// public static void permutation(String ques,String ans) {
	//
	// }
	//
	// public static void permutationDuplicates(String ques,String ans) {
	//
	// }
	// public static void permutationLexicoLarger(String ques,String ans) {
	//
	// }
	//
	// public static void LecxicographicCounting(int curr,int end) {
	//
	// }

	public static int mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int c = mazePath(cr, cc + 1, er, ec, ans + "V");
		int d = mazePath(cr + 1, cc, er, ec, ans + "H");

		return c + d;

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
