package crux12june2018;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Scanner sc = new Scanner(System.in); System.out.println("enter ur name");
		 * String name = sc.nextLine(); char ch = sc.nextLine().charAt(0);
		 * System.out.println("enter ur roll");
		 * 
		 * int rollno=sc.nextInt();
		 * 
		 * System.out.println(name); System.out.println(ch); System.out.println(rollno);
		 * 
		 * 
		 */
		// printPattern(0, 0, 10);
		
		int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		boolean res = sudokuSolver(board, 0, 0);

		if (res)
			display(board);
		else {
			System.out.println("not possible");
		}

	}

	public static int permutation(String ques, String ans) {

		int count = 0;

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			count = count + permutation(roq, ans + ch);

		}

		return count;

	}

	public static void printPattern(int row, int col, int n) {

		if (col == n) {
			System.out.println();
			printPattern(row + 1, 0, n);
			return;
		}

		if (row == n) {
			return;
		}

		System.out.print("x  ");
		printPattern(row, col + 1, n);

	}

	public static void display(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean sudokuSolver(int[][] board, int row, int col) {

		if (row == board.length) {
			return true;
		}

		if (col == board[0].length) {
			return sudokuSolver(board, row + 1, 0);
		}

		if (board[row][col] != 0) {
			return sudokuSolver(board, row, col + 1);
		}

		for (int num = 1; num <= 9; num++) {

			if (isItSafe(board, row, col, num)) {
				board[row][col] = num;
				boolean res = sudokuSolver(board, row, col + 1);
				if (res) {
					return true;
				}

				board[row][col] = 0;
			}
		}

		return false;
	}

	public static boolean isItSafe(int[][] board, int row, int col, int num) {

		return isItSafeRow(board, row, num) && isItSafeCol(board, col, num) && isItSafeGrid(board, row, col, num);
	}

	public static boolean isItSafeRow(int[][] board, int row, int num) {

		for (int col = 0; col < board[0].length; col++) {
			if (board[row][col] == num) {
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeCol(int[][] board, int col, int num) {

		for (int row = 0; row < board.length; row++) {
			if (board[row][col] == num) {
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeGrid(int[][] board, int row, int col, int num) {

		int rsp = row - (row % 3);
		int csp = col - (col % 3);

		for (int r = rsp; r < rsp + 3; r++) {
			for (int c = csp; c < csp + 3; c++) {
				if (board[r][c] == num) {
					return false;
				}
			}
		}

		return true;
	}
}
