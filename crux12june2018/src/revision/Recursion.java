package revision;

import java.util.ArrayList;
import java.util.HashMap;

public class Recursion {

	public static void main(String[] args) {

		// System.out.println(ascii("abc"));

		String str = "abad";
		// lexicographicallyLarger(str, "");
		
		//permutationDuplicates(str, "");
		// System.out.println(str.compareTo("b"));
		
	}

	public static ArrayList<String> ascii(String str) {

		ArrayList<String> ans = new ArrayList<>();

		if (str.length() == 0) {
			ans.add("");
			return ans;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = ascii(ros);

		for (String s : rr) {

			ans.add(s);
			ans.add(ch + s);
			ans.add((int) ch + s);
		}

		return ans;
	}

	public static ArrayList<String> codesOS(String str) {

		ArrayList<String> ans = new ArrayList<>();

		if (str.length() == 0) {
			ans.add("");
			return ans;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = codesOS(ros);

		String code = getCode(ch);
		for (int i = 0; i < code.length(); i++) {

			char c = code.charAt(i);
			for (String s : rr) {
				ans.add(c + s);
			}
		}

		return ans;
	}

	private static String getCode(char ch) {

		switch (ch) {
		case 1:
			return "abc";
		case 4:
			return "jk";
		case 5:
			return "lmno";
		default:
			return "";
		}
	}

	public static ArrayList<String> permutation(String str) {

		ArrayList<String> ans = new ArrayList<>();
		if (str.length() == 0) {
			ans.add("");
			return ans;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = permutation(ros);

		for (String s : rr) {
			for (int i = 0; i <= s.length(); i++) {
				String ns = s.substring(0, i) + ch + s.substring(i);
				ans.add(ns);
			}
		}

		return ans;

	}

	public static ArrayList<String> boardPath(int curr, int end) {

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;

		}

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}
		ArrayList<String> ans = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {

			ArrayList<String> rr = boardPath(curr + dice, end);
			// self
			for (String s : rr) {
				ans.add(dice + s);
			}

		}

		return ans;

	}

	public static ArrayList<String> mazePath(int cr, int cc, int er, int ec) {

		if (cr == er || cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();

			return br;
		}

		ArrayList<String> ans = new ArrayList<>();

		ArrayList<String> rrh = mazePath(cr, cc + 1, er, ec);
		ArrayList<String> rrv = mazePath(cr + 1, cc, er, ec);

		for (String s : rrh) {
			ans.add("H" + s);
		}

		for (String s : rrv) {
			ans.add("V" + s);
		}

		return ans;
	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans + ch);
	}

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			char c = code.charAt(i);
			printKPC(roq, ans + c);
		}

	}

	public static void printPermutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			printPermutation(roq, ans + ch);
		}
	}

	public static void boardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return;
		}

		if (curr > end) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			boardPath(curr + dice, end, ans + dice);

		}

	}

	public static void mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}

		mazePath(cr, cc + 1, er, ec, ans + "H");
		mazePath(cr + 1, cc, er, ec, ans + "V");

	}

	
	
	
	public static void permutationDuplicates(String ques, String ans) {

		

		if(ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		HashMap<Character, Boolean> map = new HashMap<>();
		
		for(int i=0;i<ques.length();i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i+1);
			if(!map.containsKey(ch)) {
				permutationDuplicates(roq, ans + ch);
				map.put(ch, true);
			}
		}
	}

	public static void lexicographicallyLarger(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			String anoString = ch + "";
			if (ques.compareTo(anoString) > 0) {
				lexicographicallyLarger(roq, ans + ch);
			}

		}
	}

}
