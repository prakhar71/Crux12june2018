package revision;

import java.util.ArrayList;
import java.util.HashMap;

public class Recursion {

	public static void main(String[] args) {

		// System.out.println(ascii("abc"));

		// String str = "abad";
		// lexicographicallyLarger(str, "");

		// permutationDuplicates(str, "");
		// System.out.println(str.compareTo("b"));
		// pattern(0, 0);
		
		int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		boolean res = sudukoSolver(board, 0, 0);

		if (res)
			display(board);
		else {
			System.out.println("not possible");
		}

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

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		HashMap<Character, Boolean> map = new HashMap<>();

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			if (!map.containsKey(ch)) {
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

	public static void nqueens(boolean[][] brd, int row, String ans) {

		if (row == brd.length) {

			System.out.println(ans);
			return;
		}

		for (int col = 0; col < brd[0].length; col++) {
			brd[row][col] = true;
			nqueens(brd, row + 1, ans + "{" + row + "," + col + "}");
			brd[row][col] = false;

		}

	}

	public static void pattern(int row, int col) {

		if (row == 5) {
			return;

		}

		System.out.print("#");

		if (col + 1 != 5) {
			pattern(row, col + 1);
		} else {
			System.out.println();
			pattern(row + 1, 0);
		}
	}

	public static boolean sudukoSolver(int[][] brd, int row, int col) {

		if (row == brd.length) {
			return true;
		}
		if (col == brd[0].length) {
			return sudukoSolver(brd, row + 1, 0);

		}

		if (brd[row][col] == 0) {

			for (int data = 1; data <= 9; data++) {
				if (isitSafe(brd, row, col, data)) {
					brd[row][col] = data;
					boolean ans = sudukoSolver(brd, row, col + 1);

					if(ans == true) {
						return true;
					}
					
					brd[row][col] = 0;

				}
			}

		} else {
			return sudukoSolver(brd, row, col + 1);
		}

		return false;
	}

	public static boolean isitSafe(int[][] brd, int row, int col, int data) {

		return isitSafeRow(brd, row, col, data) && isitSafeCol(brd, row, col, data) && isitSafeGrid(brd, row, col, data);
	}

	public static boolean isitSafeRow(int[][] brd, int row, int col, int data) {

		for (int c = 0; c < brd[0].length; c++) {
			if (brd[row][c] == data)
				return false;
		}

		return true;

	}

	public static boolean isitSafeCol(int[][] brd, int row, int col, int data) {

		for (int r = 0; r < brd.length; r++) {
			if (brd[r][col] == data) {
				return false;
			}

		}
		return true;
	}

	public static boolean isitSafeGrid(int[][] brd, int row, int col, int data) {

		int rsp = row - (row % 3);
		int csp = col - (col % 3);

		for (int r = rsp; r < rsp + 3; r++) {
			for (int c = csp; c < csp + 3; c++) {

				if(brd[r][c] == data) {
					return false;
				}
			}
		}
		
		
		return true;
	}
	
	
	public static void display(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
